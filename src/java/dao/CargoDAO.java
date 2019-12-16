/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cargo;


/**
 *
 * @author flavi
 */
public class CargoDAO extends GenericDAO<Cargo, Long>{
    
    public CargoDAO(){
        super(Cargo.class);
    }
    @Override
     public List<Cargo> listar(String filtro) {
        return em.createNamedQuery("Cargo.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }
}
