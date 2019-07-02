/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author flavi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
   @NamedQuery(name = "Candidato.findFilter", query = "SELECT c FROM Candidato c WHERE c.nome like :filtro"),
   
})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nome;
    private Integer idade;
    private Integer numcandidato;
    private String biocandidato;
    private String fotocandidato;
    private String planospdf;
    @ManyToOne
    private Cargo cargo;
    @ManyToOne
    private Localizacao localizacao;
    @ManyToOne
    private Partido partido;
    
    @OneToMany(mappedBy = "candidato")
    private List<Proposta> propostas;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getNumcandidato() {
        return numcandidato;
    }

    public void setNumcandidato(Integer numcandidato) {
        this.numcandidato = numcandidato;
    }

    public String getBiocandidato() {
        return biocandidato;
    }

    public void setBiocandidato(String biocandidato) {
        this.biocandidato = biocandidato;
    }

    public String getFotocandidato() {
        return fotocandidato;
    }

    public void setFotocandidato(String fotocandidato) {
        this.fotocandidato = fotocandidato;
    }

    public String getPlanospdf() {
        return planospdf;
    }

    public void setPlanospdf(String planospdf) {
        this.planospdf = planospdf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

   
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Candidato[ id=" + id + " ]";
    }
    
}
