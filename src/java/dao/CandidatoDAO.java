/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Candidato;

/**
 *
 * @author flavi
 */
public class CandidatoDAO  extends GenericDAO<Candidato, Long>{
    
    public CandidatoDAO(){
        super(Candidato.class);
    }
    
    public List<Candidato> listar(String filtro) {
        return em.createNamedQuery("Candidato.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }
    
     public List<Candidato> listar(Long partido, Long localizacao, Long cargo) {
         //WHERE c.cargo.id=1 AND c.localizacao.id=1 AND c.partido.id=1
         String consulta = "SELECT * FROM Candidato ";
         if(partido!=0 ||localizacao!=0 || cargo!=0)
         {
             consulta = consulta + " WHERE ";
             if(partido!=0)
             {
                 consulta = consulta + "partido_id = "+partido + " AND ";
             }
             
             if(localizacao!=0)
             {
                 consulta = consulta + "localizacao_id = "+localizacao + " AND ";
             }
             
             if(cargo!=0)
             {
                 consulta = consulta + "cargo_id = "+cargo + " AND ";
             }
             
             consulta = consulta.substring(0, consulta.length()-4); //tira o AND do final da String
         }
         
         return em.createNativeQuery(consulta,Candidato.class).getResultList();
      //  return em.createNamedQuery(consulta).getResultList();
    }
    
}
