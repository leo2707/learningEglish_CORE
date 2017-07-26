package co.com.powersoft.learningenglish.querymanager.entity;

import co.com.powersoft.learningenglish.querymanager.entity.LessonType;
import co.com.powersoft.learningenglish.querymanager.entity.Theme;
import co.com.powersoft.learningenglish.querymanager.entity.Verb;
import co.com.powersoft.learningenglish.querymanager.entity.Vocabulary;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T10:10:49")
@StaticMetamodel(Lesson.class)
public class Lesson_ { 

    public static volatile CollectionAttribute<Lesson, Verb> verbCollection;
    public static volatile SingularAttribute<Lesson, Theme> leIdTheme;
    public static volatile CollectionAttribute<Lesson, Vocabulary> vocabularyCollection;
    public static volatile SingularAttribute<Lesson, String> leId;
    public static volatile SingularAttribute<Lesson, LessonType> leIdLessonType;
    public static volatile SingularAttribute<Lesson, Boolean> leState;
    public static volatile SingularAttribute<Lesson, String> leName;
    public static volatile SingularAttribute<Lesson, Integer> leOrder;
    public static volatile SingularAttribute<Lesson, String> leDescription;
    public static volatile SingularAttribute<Lesson, String> leIcon;

}