/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Partido;

/**
 *
 * @author flavi
 */
public class PartidoDAO extends GenericDAO<Partido, Long>{
    
    public PartidoDAO(){
        super(Partido.class);
    }
    @Override
     public List<Partido> listar(String filtro) {
        return em.createNamedQuery("Partido.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }
}