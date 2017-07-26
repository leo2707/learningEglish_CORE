package co.com.powersoft.learningenglish.querymanager.entity;

import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T10:10:49")
@StaticMetamodel(Vocabulary.class)
public class Vocabulary_ { 

    public static volatile SingularAttribute<Vocabulary, String> voSpanishValue;
    public static volatile SingularAttribute<Vocabulary, Integer> voOrder;
    public static volatile SingularAttribute<Vocabulary, Integer> voId;
    public static volatile SingularAttribute<Vocabulary, String> voOtherValue;
    public static volatile SingularAttribute<Vocabulary, String> voSpanishPronunciation;
    public static volatile SingularAttribute<Vocabulary, String> voSpanishSound;
    public static volatile SingularAttribute<Vocabulary, String> voEnglishPronunciation;
    public static volatile SingularAttribute<Vocabulary, String> voImg;
    public static volatile SingularAttribute<Vocabulary, String> voEnglishSound;
    public static volatile SingularAttribute<Vocabulary, String> voEnglishValue;
    public static volatile SingularAttribute<Vocabulary, Lesson> voIdLesson;

}