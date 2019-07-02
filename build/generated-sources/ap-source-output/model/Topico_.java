package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Proposta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T13:14:26")
@StaticMetamodel(Topico.class)
public class Topico_ { 

    public static volatile SingularAttribute<Topico, String> topico;
    public static volatile ListAttribute<Topico, Proposta> propostas;
    public static volatile SingularAttribute<Topico, Long> id;

}