package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Candidato;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-18T09:53:21")
@StaticMetamodel(Partido.class)
public class Partido_ { 

    public static volatile SingularAttribute<Partido, String> fotopartido;
    public static volatile ListAttribute<Partido, Candidato> candidatos;
    public static volatile SingularAttribute<Partido, String> bio;
    public static volatile SingularAttribute<Partido, String> favoravel;
    public static volatile SingularAttribute<Partido, String> numpartido;
    public static volatile SingularAttribute<Partido, Long> id;
    public static volatile SingularAttribute<Partido, String> partido;

}