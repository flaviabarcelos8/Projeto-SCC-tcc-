package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cargo;
import model.Localizacao;
import model.Partido;
import model.Proposta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T13:14:26")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, Integer> idade;
    public static volatile SingularAttribute<Candidato, Localizacao> localizacao;
    public static volatile ListAttribute<Candidato, Proposta> propostas;
    public static volatile SingularAttribute<Candidato, Integer> numcandidato;
    public static volatile SingularAttribute<Candidato, String> planospdf;
    public static volatile SingularAttribute<Candidato, String> nome;
    public static volatile SingularAttribute<Candidato, Long> id;
    public static volatile SingularAttribute<Candidato, String> fotocandidato;
    public static volatile SingularAttribute<Candidato, Cargo> cargo;
    public static volatile SingularAttribute<Candidato, String> biocandidato;
    public static volatile SingularAttribute<Candidato, Partido> partido;

}