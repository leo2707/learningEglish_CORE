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
import co.com.powersoft.learningenglish.querymanager.entity.LessonType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class LessonTypeJpaController implements Serializable {

    public LessonTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LessonType lessonType) throws PreexistingEntityException, Exception {
        if (lessonType.getLessonCollection() == null) {
            lessonType.setLessonCollection(new ArrayList<Lesson>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Lesson> attachedLessonCollection = new ArrayList<Lesson>();
            for (Lesson lessonCollectionLessonToAttach : lessonType.getLessonCollection()) {
                lessonCollectionLessonToAttach = em.getReference(lessonCollectionLessonToAttach.getClass(), lessonCollectionLessonToAttach.getLeId());
                attachedLessonCollection.add(lessonCollectionLessonToAttach);
            }
            lessonType.setLessonCollection(attachedLessonCollection);
            em.persist(lessonType);
            for (Lesson lessonCollectionLesson : lessonType.getLessonCollection()) {
                LessonType oldLeIdLessonTypeOfLessonCollectionLesson = lessonCollectionLesson.getLeIdLessonType();
                lessonCollectionLesson.setLeIdLessonType(lessonType);
                lessonCollectionLesson = em.merge(lessonCollectionLesson);
                if (oldLeIdLessonTypeOfLessonCollectionLesson != null) {
                    oldLeIdLessonTypeOfLessonCollectionLesson.getLessonCollection().remove(lessonCollectionLesson);
                    oldLeIdLessonTypeOfLessonCollectionLesson = em.merge(oldLeIdLessonTypeOfLessonCollectionLesson);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLessonType(lessonType.getLtId()) != null) {
                throw new PreexistingEntityException("LessonType " + lessonType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LessonType lessonType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LessonType persistentLessonType = em.find(LessonType.class, lessonType.getLtId());
            Collection<Lesson> lessonCollectionOld = persistentLessonType.getLessonCollection();
            Collection<Lesson> lessonCollectionNew = lessonType.getLessonCollection();
            Collection<Lesson> attachedLessonCollectionNew = new ArrayList<Lesson>();
            for (Lesson lessonCollectionNewLessonToAttach : lessonCollectionNew) {
                lessonCollectionNewLessonToAttach = em.getReference(lessonCollectionNewLessonToAttach.getClass(), lessonCollectionNewLessonToAttach.getLeId());
                attachedLessonCollectionNew.add(lessonCollectionNewLessonToAttach);
            }
            lessonCollectionNew = attachedLessonCollectionNew;
            lessonType.setLessonCollection(lessonCollectionNew);
            lessonType = em.merge(lessonType);
            for (Lesson lessonCollectionOldLesson : lessonCollectionOld) {
                if (!lessonCollectionNew.contains(lessonCollectionOldLesson)) {
                    lessonCollectionOldLesson.setLeIdLessonType(null);
                    lessonCollectionOldLesson = em.merge(lessonCollectionOldLesson);
                }
            }
            for (Lesson lessonCollectionNewLesson : lessonCollectionNew) {
                if (!lessonCollectionOld.contains(lessonCollectionNewLesson)) {
                    LessonType oldLeIdLessonTypeOfLessonCollectionNewLesson = lessonCollectionNewLesson.getLeIdLessonType();
                    lessonCollectionNewLesson.setLeIdLessonType(lessonType);
                    lessonCollectionNewLesson = em.merge(lessonCollectionNewLesson);
                    if (oldLeIdLessonTypeOfLessonCollectionNewLesson != null && !oldLeIdLessonTypeOfLessonCollectionNewLesson.equals(lessonType)) {
                        oldLeIdLessonTypeOfLessonCollectionNewLesson.getLessonCollection().remove(lessonCollectionNewLesson);
                        oldLeIdLessonTypeOfLessonCollectionNewLesson = em.merge(oldLeIdLessonTypeOfLessonCollectionNewLesson);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lessonType.getLtId();
                if (findLessonType(id) == null) {
                    throw new NonexistentEntityException("The lessonType with id " + id + " no longer exists.");
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
            LessonType lessonType;
            try {
                lessonType = em.getReference(LessonType.class, id);
                lessonType.getLtId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lessonType with id " + id + " no longer exists.", enfe);
            }
            Collection<Lesson> lessonCollection = lessonType.getLessonCollection();
            for (Lesson lessonCollectionLesson : lessonCollection) {
                lessonCollectionLesson.setLeIdLessonType(null);
                lessonCollectionLesson = em.merge(lessonCollectionLesson);
            }
            em.remove(lessonType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LessonType> findLessonTypeEntities() {
        return findLessonTypeEntities(true, -1, -1);
    }

    public List<LessonType> findLessonTypeEntities(int maxResults, int firstResult) {
        return findLessonTypeEntities(false, maxResults, firstResult);
    }

    private List<LessonType> findLessonTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LessonType.class));
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

    public LessonType findLessonType(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LessonType.class, id);
        } finally {
            em.close();
        }
    }

    public int getLessonTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LessonType> rt = cq.from(LessonType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
