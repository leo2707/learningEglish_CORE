/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.controller;

import co.com.powersoft.learningenglish.querymanager.controller.exceptions.NonexistentEntityException;
import co.com.powersoft.learningenglish.querymanager.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import co.com.powersoft.learningenglish.querymanager.entity.Theme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class ThemeJpaController implements Serializable {

    public ThemeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Theme theme) throws PreexistingEntityException, Exception {
        if (theme.getLessonCollection() == null) {
            theme.setLessonCollection(new ArrayList<Lesson>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Lesson> attachedLessonCollection = new ArrayList<Lesson>();
            for (Lesson lessonCollectionLessonToAttach : theme.getLessonCollection()) {
                lessonCollectionLessonToAttach = em.getReference(lessonCollectionLessonToAttach.getClass(), lessonCollectionLessonToAttach.getLeId());
                attachedLessonCollection.add(lessonCollectionLessonToAttach);
            }
            theme.setLessonCollection(attachedLessonCollection);
            em.persist(theme);
            for (Lesson lessonCollectionLesson : theme.getLessonCollection()) {
                Theme oldLeIdThemeOfLessonCollectionLesson = lessonCollectionLesson.getLeIdTheme();
                lessonCollectionLesson.setLeIdTheme(theme);
                lessonCollectionLesson = em.merge(lessonCollectionLesson);
                if (oldLeIdThemeOfLessonCollectionLesson != null) {
                    oldLeIdThemeOfLessonCollectionLesson.getLessonCollection().remove(lessonCollectionLesson);
                    oldLeIdThemeOfLessonCollectionLesson = em.merge(oldLeIdThemeOfLessonCollectionLesson);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTheme(theme.getThId()) != null) {
                throw new PreexistingEntityException("Theme " + theme + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Theme theme) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Theme persistentTheme = em.find(Theme.class, theme.getThId());
            Collection<Lesson> lessonCollectionOld = persistentTheme.getLessonCollection();
            Collection<Lesson> lessonCollectionNew = theme.getLessonCollection();
            Collection<Lesson> attachedLessonCollectionNew = new ArrayList<Lesson>();
            for (Lesson lessonCollectionNewLessonToAttach : lessonCollectionNew) {
                lessonCollectionNewLessonToAttach = em.getReference(lessonCollectionNewLessonToAttach.getClass(), lessonCollectionNewLessonToAttach.getLeId());
                attachedLessonCollectionNew.add(lessonCollectionNewLessonToAttach);
            }
            lessonCollectionNew = attachedLessonCollectionNew;
            theme.setLessonCollection(lessonCollectionNew);
            theme = em.merge(theme);
            for (Lesson lessonCollectionOldLesson : lessonCollectionOld) {
                if (!lessonCollectionNew.contains(lessonCollectionOldLesson)) {
                    lessonCollectionOldLesson.setLeIdTheme(null);
                    lessonCollectionOldLesson = em.merge(lessonCollectionOldLesson);
                }
            }
            for (Lesson lessonCollectionNewLesson : lessonCollectionNew) {
                if (!lessonCollectionOld.contains(lessonCollectionNewLesson)) {
                    Theme oldLeIdThemeOfLessonCollectionNewLesson = lessonCollectionNewLesson.getLeIdTheme();
                    lessonCollectionNewLesson.setLeIdTheme(theme);
                    lessonCollectionNewLesson = em.merge(lessonCollectionNewLesson);
                    if (oldLeIdThemeOfLessonCollectionNewLesson != null && !oldLeIdThemeOfLessonCollectionNewLesson.equals(theme)) {
                        oldLeIdThemeOfLessonCollectionNewLesson.getLessonCollection().remove(lessonCollectionNewLesson);
                        oldLeIdThemeOfLessonCollectionNewLesson = em.merge(oldLeIdThemeOfLessonCollectionNewLesson);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = theme.getThId();
                if (findTheme(id) == null) {
                    throw new NonexistentEntityException("The theme with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Theme theme;
            try {
                theme = em.getReference(Theme.class, id);
                theme.getThId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The theme with id " + id + " no longer exists.", enfe);
            }
            Collection<Lesson> lessonCollection = theme.getLessonCollection();
            for (Lesson lessonCollectionLesson : lessonCollection) {
                lessonCollectionLesson.setLeIdTheme(null);
                lessonCollectionLesson = em.merge(lessonCollectionLesson);
            }
            em.remove(theme);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Theme> findThemeEntities() {
        return findThemeEntities(true, -1, -1);
    }

    public List<Theme> findThemeEntities(int maxResults, int firstResult) {
        return findThemeEntities(false, maxResults, firstResult);
    }

    private List<Theme> findThemeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Theme.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Theme findTheme(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Theme.class, id);
        } finally {
            em.close();
        }
    }

    public int getThemeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Theme> rt = cq.from(Theme.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
