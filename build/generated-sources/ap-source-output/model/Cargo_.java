package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Candidato;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-18T09:53:21")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile ListAttribute<Cargo, Candidato> candidatos;
    public static volatile SingularAttribute<Cargo, Long> id;
    public static volatile SingularAttribute<Cargo, String> cargo;

}