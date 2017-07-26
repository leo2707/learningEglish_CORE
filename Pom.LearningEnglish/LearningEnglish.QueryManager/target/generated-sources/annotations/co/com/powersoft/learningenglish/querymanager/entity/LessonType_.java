package co.com.powersoft.learningenglish.querymanager.entity;

import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T10:10:49")
@StaticMetamodel(LessonType.class)
public class LessonType_ { 

    public static volatile SingularAttribute<LessonType, Integer> ltId;
    public static volatile SingularAttribute<LessonType, String> ltValue;
    public static volatile CollectionAttribute<LessonType, Lesson> lessonCollection;

}