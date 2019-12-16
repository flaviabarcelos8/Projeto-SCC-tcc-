/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cola;

/**
 *
 * @author flavi
 */
public class ColaDAO  extends GenericDAO<Cola, Long>{
    
    public ColaDAO(){
        super(Cola.class);
    }
    
    public List<Cola> listar(String filtro) {
        return em.createNamedQuery("Cola.findFilter").setParameter("filtro","%" + filtro.toUpperCase() + "%").getResultList();
    }
}
