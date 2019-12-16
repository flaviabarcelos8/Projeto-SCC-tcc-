package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Candidato;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-18T09:53:21")
@StaticMetamodel(Cola.class)
public class Cola_ { 

    public static volatile SingularAttribute<Cola, Usuario> usuario_id;
    public static volatile ListAttribute<Cola, Candidato> candidatos;
    public static volatile SingularAttribute<Cola, Long> id;

}