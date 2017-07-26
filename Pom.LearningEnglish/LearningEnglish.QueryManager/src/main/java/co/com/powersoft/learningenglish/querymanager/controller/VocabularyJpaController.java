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
import co.com.powersoft.learningenglish.querymanager.entity.Vocabulary;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.ParameterExpression;

/**
 *
 * @author Leonardo
 */
public class VocabularyJpaController implements Serializable {

    public VocabularyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vocabulary vocabulary) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lesson voIdLesson = vocabulary.getVoIdLesson();
            if (voIdLesson != null) {
                voIdLesson = em.getReference(voIdLesson.getClass(), voIdLesson.getLeId());
                vocabulary.setVoIdLesson(voIdLesson);
            }
            em.persist(vocabulary);
            if (voIdLesson != null) {
                voIdLesson.getVocabularyCollection().add(vocabulary);
                voIdLesson = em.merge(voIdLesson);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vocabulary vocabulary) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vocabulary persistentVocabulary = em.find(Vocabulary.class, vocabulary.getVoId());
            Lesson voIdLessonOld = persistentVocabulary.getVoIdLesson();
            Lesson voIdLessonNew = vocabulary.getVoIdLesson();
            if (voIdLessonNew != null) {
                voIdLessonNew = em.getReference(voIdLessonNew.getClass(), voIdLessonNew.getLeId());
                vocabulary.setVoIdLesson(voIdLessonNew);
            }
            vocabulary = em.merge(vocabulary);
            if (voIdLessonOld != null && !voIdLessonOld.equals(voIdLessonNew)) {
                voIdLessonOld.getVocabularyCollection().remove(vocabulary);
                voIdLessonOld = em.merge(voIdLessonOld);
            }
            if (voIdLessonNew != null && !voIdLessonNew.equals(voIdLessonOld)) {
                voIdLessonNew.getVocabularyCollection().add(vocabulary);
                voIdLessonNew = em.merge(voIdLessonNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vocabulary.getVoId();
                if (findVocabulary(id) == null) {
                    throw new NonexistentEntityException("The vocabulary with id " + id + " no longer exists.");
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
            Vocabulary vocabulary;
            try {
                vocabulary = em.getReference(Vocabulary.class, id);
                vocabulary.getVoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vocabulary with id " + id + " no longer exists.", enfe);
            }
            Lesson voIdLesson = vocabulary.getVoIdLesson();
            if (voIdLesson != null) {
                voIdLesson.getVocabularyCollection().remove(vocabulary);
                voIdLesson = em.merge(voIdLesson);
            }
            em.remove(vocabulary);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vocabulary> findVocabularyEntities() {
        return findVocabularyEntities(true, -1, -1);
    }

    public List<Vocabulary> findVocabularyEntities(int maxResults, int firstResult) {
        return findVocabularyEntities(false, maxResults, firstResult);
    }

    private List<Vocabulary> findVocabularyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vocabulary.class));
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

    public Vocabulary findVocabulary(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vocabulary.class, id);
        } finally {
            em.close();
        }
    }

    public int getVocabularyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vocabulary> rt = cq.from(Vocabulary.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    /*NEWWWWW*/
    public List<Vocabulary> findVocabularyFromLesson2(String lessonId) {
        return findVocabularyFromLesson2(lessonId, true, -1, -1);
    }

    public List<Vocabulary> findVocabularyFromLesson2(String lessonId, int maxResults, int firstResult) {
        return findVocabularyFromLesson2(lessonId, false, maxResults, firstResult);
    }
    
    private List<Vocabulary> findVocabularyFromLesson2(String lessonId, boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            
            CriteriaQuery<Vocabulary> cq = cb.createQuery(Vocabulary.class);
            Root<Vocabulary> c = cq.from(Vocabulary.class);
            cq.select(c);
            ParameterExpression<Integer> param = cb.parameter(Integer.class);
            cq.where(cb.equal(c.get(lessonId), param));
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
    
    public List<Vocabulary> findVocabularyFromLesson(String lessonId) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT * FROM learning_english.Vocabulary v WHERE vo_id_lesson = ?  ORDER BY vo_order, vo_english_value, vo_spanish_value", Vocabulary.class);
            query.setParameter(1, lessonId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
