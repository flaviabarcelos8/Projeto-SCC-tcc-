/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cargo;


/**
 *
 * @author flavi
 */
public class CargoDAO extends GenericDAO<Cargo, Long>{
    
    public CargoDAO(){
        super(Cargo.class);
    }
    
}
