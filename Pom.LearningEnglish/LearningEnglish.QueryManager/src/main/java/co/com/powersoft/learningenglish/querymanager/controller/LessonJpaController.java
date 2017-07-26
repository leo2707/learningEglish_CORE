/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.controller;

import co.com.powersoft.learningenglish.querymanager.controller.exceptions.NonexistentEntityException;
import co.com.powersoft.learningenglish.querymanager.controller.exceptions.PreexistingEntityException;
import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.com.powersoft.learningenglish.querymanager.entity.LessonType;
import co.com.powersoft.learningenglish.querymanager.entity.Theme;
import co.com.powersoft.learningenglish.querymanager.entity.Vocabulary;
import java.util.ArrayList;
import java.util.Collection;
import co.com.powersoft.learningenglish.querymanager.entity.Verb;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo
 */
public class LessonJpaController implements Serializable {

    public LessonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lesson lesson) throws PreexistingEntityException, Exception {
        if (lesson.getVocabularyCollection() == null) {
            lesson.setVocabularyCollection(new ArrayList<Vocabulary>());
        }
        if (lesson.getVerbCollection() == null) {
            lesson.setVerbCollection(new ArrayList<Verb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LessonType leIdLessonType = lesson.getLeIdLessonType();
            if (leIdLessonType != null) {
                leIdLessonType = em.getReference(leIdLessonType.getClass(), leIdLessonType.getLtId());
                lesson.setLeIdLessonType(leIdLessonType);
            }
            Theme leIdTheme = lesson.getLeIdTheme();
            if (leIdTheme != null) {
                leIdTheme = em.getReference(leIdTheme.getClass(), leIdTheme.getThId());
                lesson.setLeIdTheme(leIdTheme);
            }
            Collection<Vocabulary> attachedVocabularyCollection = new ArrayList<Vocabulary>();
            for (Vocabulary vocabularyCollectionVocabularyToAttach : lesson.getVocabularyCollection()) {
                vocabularyCollectionVocabularyToAttach = em.getReference(vocabularyCollectionVocabularyToAttach.getClass(), vocabularyCollectionVocabularyToAttach.getVoId());
                attachedVocabularyCollection.add(vocabularyCollectionVocabularyToAttach);
            }
            lesson.setVocabularyCollection(attachedVocabularyCollection);
            Collection<Verb> attachedVerbCollection = new ArrayList<Verb>();
            for (Verb verbCollectionVerbToAttach : lesson.getVerbCollection()) {
                verbCollectionVerbToAttach = em.getReference(verbCollectionVerbToAttach.getClass(), verbCollectionVerbToAttach.getVeId());
                attachedVerbCollection.add(verbCollectionVerbToAttach);
            }
            lesson.setVerbCollection(attachedVerbCollection);
            em.persist(lesson);
            if (leIdLessonType != null) {
                leIdLessonType.getLessonCollection().add(lesson);
                leIdLessonType = em.merge(leIdLessonType);
            }
            if (leIdTheme != null) {
                leIdTheme.getLessonCollection().add(lesson);
                leIdTheme = em.merge(leIdTheme);
            }
            for (Vocabulary vocabularyCollectionVocabulary : lesson.getVocabularyCollection()) {
                Lesson oldVoIdLessonOfVocabularyCollectionVocabulary = vocabularyCollectionVocabulary.getVoIdLesson();
                vocabularyCollectionVocabulary.setVoIdLesson(lesson);
                vocabularyCollectionVocabulary = em.merge(vocabularyCollectionVocabulary);
                if (oldVoIdLessonOfVocabularyCollectionVocabulary != null) {
                    oldVoIdLessonOfVocabularyCollectionVocabulary.getVocabularyCollection().remove(vocabularyCollectionVocabulary);
                    oldVoIdLessonOfVocabularyCollectionVocabulary = em.merge(oldVoIdLessonOfVocabularyCollectionVocabulary);
                }
            }
            for (Verb verbCollectionVerb : lesson.getVerbCollection()) {
                Lesson oldVeIdLessonOfVerbCollectionVerb = verbCollectionVerb.getVeIdLesson();
                verbCollectionVerb.setVeIdLesson(lesson);
                verbCollectionVerb = em.merge(verbCollectionVerb);
                if (oldVeIdLessonOfVerbCollectionVerb != null) {
                    oldVeIdLessonOfVerbCollectionVerb.getVerbCollection().remove(verbCollectionVerb);
                    oldVeIdLessonOfVerbCollectionVerb = em.merge(oldVeIdLessonOfVerbCollectionVerb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLesson(lesson.getLeId()) != null) {
                throw new PreexistingEntityException("Lesson " + lesson + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lesson lesson) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lesson persistentLesson = em.find(Lesson.class, lesson.getLeId());
            LessonType leIdLessonTypeOld = persistentLesson.getLeIdLessonType();
            LessonType leIdLessonTypeNew = lesson.getLeIdLessonType();
            Theme leIdThemeOld = persistentLesson.getLeIdTheme();
            Theme leIdThemeNew = lesson.getLeIdTheme();
            Collection<Vocabulary> vocabularyCollectionOld = persistentLesson.getVocabularyCollection();
            Collection<Vocabulary> vocabularyCollectionNew = lesson.getVocabularyCollection();
            Collection<Verb> verbCollectionOld = persistentLesson.getVerbCollection();
            Collection<Verb> verbCollectionNew = lesson.getVerbCollection();
            if (leIdLessonTypeNew != null) {
                leIdLessonTypeNew = em.getReference(leIdLessonTypeNew.getClass(), leIdLessonTypeNew.getLtId());
                lesson.setLeIdLessonType(leIdLessonTypeNew);
            }
            if (leIdThemeNew != null) {
                leIdThemeNew = em.getReference(leIdThemeNew.getClass(), leIdThemeNew.getThId());
                lesson.setLeIdTheme(leIdThemeNew);
            }
            Collection<Vocabulary> attachedVocabularyCollectionNew = new ArrayList<Vocabulary>();
            for (Vocabulary vocabularyCollectionNewVocabularyToAttach : vocabularyCollectionNew) {
                vocabularyCollectionNewVocabularyToAttach = em.getReference(vocabularyCollectionNewVocabularyToAttach.getClass(), vocabularyCollectionNewVocabularyToAttach.getVoId());
                attachedVocabularyCollectionNew.add(vocabularyCollectionNewVocabularyToAttach);
            }
            vocabularyCollectionNew = attachedVocabularyCollectionNew;
            lesson.setVocabularyCollection(vocabularyCollectionNew);
            Collection<Verb> attachedVerbCollectionNew = new ArrayList<Verb>();
            for (Verb verbCollectionNewVerbToAttach : verbCollectionNew) {
                verbCollectionNewVerbToAttach = em.getReference(verbCollectionNewVerbToAttach.getClass(), verbCollectionNewVerbToAttach.getVeId());
                attachedVerbCollectionNew.add(verbCollectionNewVerbToAttach);
            }
            verbCollectionNew = attachedVerbCollectionNew;
            lesson.setVerbCollection(verbCollectionNew);
            lesson = em.merge(lesson);
            if (leIdLessonTypeOld != null && !leIdLessonTypeOld.equals(leIdLessonTypeNew)) {
                leIdLessonTypeOld.getLessonCollection().remove(lesson);
                leIdLessonTypeOld = em.merge(leIdLessonTypeOld);
            }
            if (leIdLessonTypeNew != null && !leIdLessonTypeNew.equals(leIdLessonTypeOld)) {
                leIdLessonTypeNew.getLessonCollection().add(lesson);
                leIdLessonTypeNew = em.merge(leIdLessonTypeNew);
            }
            if (leIdThemeOld != null && !leIdThemeOld.equals(leIdThemeNew)) {
                leIdThemeOld.getLessonCollection().remove(lesson);
                leIdThemeOld = em.merge(leIdThemeOld);
            }
            if (leIdThemeNew != null && !leIdThemeNew.equals(leIdThemeOld)) {
                leIdThemeNew.getLessonCollection().add(lesson);
                leIdThemeNew = em.merge(leIdThemeNew);
            }
            for (Vocabulary vocabularyCollectionOldVocabulary : vocabularyCollectionOld) {
                if (!vocabularyCollectionNew.contains(vocabularyCollectionOldVocabulary)) {
                    vocabularyCollectionOldVocabulary.setVoIdLesson(null);
                    vocabularyCollectionOldVocabulary = em.merge(vocabularyCollectionOldVocabulary);
                }
            }
            for (Vocabulary vocabularyCollectionNewVocabulary : vocabularyCollectionNew) {
                if (!vocabularyCollectionOld.contains(vocabularyCollectionNewVocabulary)) {
                    Lesson oldVoIdLessonOfVocabularyCollectionNewVocabulary = vocabularyCollectionNewVocabulary.getVoIdLesson();
                    vocabularyCollectionNewVocabulary.setVoIdLesson(lesson);
                    vocabularyCollectionNewVocabulary = em.merge(vocabularyCollectionNewVocabulary);
                    if (oldVoIdLessonOfVocabularyCollectionNewVocabulary != null && !oldVoIdLessonOfVocabularyCollectionNewVocabulary.equals(lesson)) {
                        oldVoIdLessonOfVocabularyCollectionNewVocabulary.getVocabularyCollection().remove(vocabularyCollectionNewVocabulary);
                        oldVoIdLessonOfVocabularyCollectionNewVocabulary = em.merge(oldVoIdLessonOfVocabularyCollectionNewVocabulary);
                    }
                }
            }
            for (Verb verbCollectionOldVerb : verbCollectionOld) {
                if (!verbCollectionNew.contains(verbCollectionOldVerb)) {
                    verbCollectionOldVerb.setVeIdLesson(null);
                    verbCollectionOldVerb = em.merge(verbCollectionOldVerb);
                }
            }
            for (Verb verbCollectionNewVerb : verbCollectionNew) {
                if (!verbCollectionOld.contains(verbCollectionNewVerb)) {
                    Lesson oldVeIdLessonOfVerbCollectionNewVerb = verbCollectionNewVerb.getVeIdLesson();
                    verbCollectionNewVerb.setVeIdLesson(lesson);
                    verbCollectionNewVerb = em.merge(verbCollectionNewVerb);
                    if (oldVeIdLessonOfVerbCollectionNewVerb != null && !oldVeIdLessonOfVerbCollectionNewVerb.equals(lesson)) {
                        oldVeIdLessonOfVerbCollectionNewVerb.getVerbCollection().remove(verbCollectionNewVerb);
                        oldVeIdLessonOfVerbCollectionNewVerb = em.merge(oldVeIdLessonOfVerbCollectionNewVerb);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lesson.getLeId();
                if (findLesson(id) == null) {
                    throw new NonexistentEntityException("The lesson with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lesson lesson;
            try {
                lesson = em.getReference(Lesson.class, id);
                lesson.getLeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lesson with id " + id + " no longer exists.", enfe);
            }
            LessonType leIdLessonType = lesson.getLeIdLessonType();
            if (leIdLessonType != null) {
                leIdLessonType.getLessonCollection().remove(lesson);
                leIdLessonType = em.merge(leIdLessonType);
            }
            Theme leIdTheme = lesson.getLeIdTheme();
            if (leIdTheme != null) {
                leIdTheme.getLessonCollection().remove(lesson);
                leIdTheme = em.merge(leIdTheme);
            }
            Collection<Vocabulary> vocabularyCollection = lesson.getVocabularyCollection();
            for (Vocabulary vocabularyCollectionVocabulary : vocabularyCollection) {
                vocabularyCollectionVocabulary.setVoIdLesson(null);
                vocabularyCollectionVocabulary = em.merge(vocabularyCollectionVocabulary);
            }
            Collection<Verb> verbCollection = lesson.getVerbCollection();
            for (Verb verbCollectionVerb : verbCollection) {
                verbCollectionVerb.setVeIdLesson(null);
                verbCollectionVerb = em.merge(verbCollectionVerb);
            }
            em.remove(lesson);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lesson> findLessonEntities() {
        return findLessonEntities(true, -1, -1);
    }

    public List<Lesson> findLessonEntities(int maxResults, int firstResult) {
        return findLessonEntities(false, maxResults, firstResult);
    }

    private List<Lesson> findLessonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lesson.class));
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

    public Lesson findLesson(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lesson.class, id);
        } finally {
            em.close();
        }
    }

    public int getLessonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lesson> rt = cq.from(Lesson.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
