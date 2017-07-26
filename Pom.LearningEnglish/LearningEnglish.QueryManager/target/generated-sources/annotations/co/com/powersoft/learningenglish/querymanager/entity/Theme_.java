package co.com.powersoft.learningenglish.querymanager.entity;

import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T10:10:49")
@StaticMetamodel(Theme.class)
public class Theme_ { 

    public static volatile SingularAttribute<Theme, String> thDescription;
    public static volatile SingularAttribute<Theme, String> thKeywords;
    public static volatile SingularAttribute<Theme, String> thIcon;
    public static volatile SingularAttribute<Theme, Integer> thOrder;
    public static volatile SingularAttribute<Theme, Integer> thId;
    public static volatile CollectionAttribute<Theme, Lesson> lessonCollection;
    public static volatile SingularAttribute<Theme, String> thName;
    public static volatile SingularAttribute<Theme, Boolean> thState;

}