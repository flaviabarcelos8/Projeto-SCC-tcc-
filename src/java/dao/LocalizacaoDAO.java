/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Localizacao;

/**
 *
 * @author flavi
 */
public class LocalizacaoDAO extends GenericDAO<Localizacao, Long>{
    
    public LocalizacaoDAO(){
        super(Localizacao.class);
    }
     public List<Localizacao> listar(String filtro) {
        return em.createNamedQuery("Localizacao.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }
    
}
