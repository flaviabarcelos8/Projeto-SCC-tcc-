package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Candidato;
import model.Topico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-18T09:53:21")
@StaticMetamodel(Proposta.class)
public class Proposta_ { 

    public static volatile SingularAttribute<Proposta, Topico> topico;
    public static volatile SingularAttribute<Proposta, String> solucao;
    public static volatile SingularAttribute<Proposta, String> fonte;
    public static volatile SingularAttribute<Proposta, Long> id;
    public static volatile SingularAttribute<Proposta, Candidato> candidato;

}