/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.controller;

import co.com.powersoft.learningenglish.querymanager.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import co.com.powersoft.learningenglish.querymanager.entity.Verb;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class VerbJpaController implements Serializable {

    public VerbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Verb verb) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lesson veIdLesson = verb.getVeIdLesson();
            if (veIdLesson != null) {
                veIdLesson = em.getReference(veIdLesson.getClass(), veIdLesson.getLeId());
                verb.setVeIdLesson(veIdLesson);
            }
            em.persist(verb);
            if (veIdLesson != null) {
                veIdLesson.getVerbCollection().add(verb);
                veIdLesson = em.merge(veIdLesson);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Verb verb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Verb persistentVerb = em.find(Verb.class, verb.getVeId());
            Lesson veIdLessonOld = persistentVerb.getVeIdLesson();
            Lesson veIdLessonNew = verb.getVeIdLesson();
            if (veIdLessonNew != null) {
                veIdLessonNew = em.getReference(veIdLessonNew.getClass(), veIdLessonNew.getLeId());
                verb.setVeIdLesson(veIdLessonNew);
            }
            verb = em.merge(verb);
            if (veIdLessonOld != null && !veIdLessonOld.equals(veIdLessonNew)) {
                veIdLessonOld.getVerbCollection().remove(verb);
                veIdLessonOld = em.merge(veIdLessonOld);
            }
            if (veIdLessonNew != null && !veIdLessonNew.equals(veIdLessonOld)) {
                veIdLessonNew.getVerbCollection().add(verb);
                veIdLessonNew = em.merge(veIdLessonNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = verb.getVeId();
                if (findVerb(id) == null) {
                    throw new NonexistentEntityException("The verb with id " + id + " no longer exists.");
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
            Verb verb;
            try {
                verb = em.getReference(Verb.class, id);
                verb.getVeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The verb with id " + id + " no longer exists.", enfe);
            }
            Lesson veIdLesson = verb.getVeIdLesson();
            if (veIdLesson != null) {
                veIdLesson.getVerbCollection().remove(verb);
                veIdLesson = em.merge(veIdLesson);
            }
            em.remove(verb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Verb> findVerbEntities() {
        return findVerbEntities(true, -1, -1);
    }

    public List<Verb> findVerbEntities(int maxResults, int firstResult) {
        return findVerbEntities(false, maxResults, firstResult);
    }

    private List<Verb> findVerbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Verb.class));
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

    public Verb findVerb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Verb.class, id);
        } finally {
            em.close();
        }
    }

    public int getVerbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Verb> rt = cq.from(Verb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Verb> findVerbsFromLesson(String lessonId) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT * FROM learning_english.Verb v WHERE ve_id_lesson = ?  ORDER BY ve_english_present_value, ve_spanish_value", Verb.class);
            query.setParameter(1, lessonId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
