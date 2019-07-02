/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Topico;

/**
 *
 * @author flavi
 */
public class TopicoDAO extends GenericDAO<Topico, Long>{
    
    public TopicoDAO(){
        super(Topico.class);
    }
    
}
