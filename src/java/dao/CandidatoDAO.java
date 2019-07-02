/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Candidato;

/**
 *
 * @author flavi
 */
public class CandidatoDAO  extends GenericDAO<Candidato, Long>{
    
    public CandidatoDAO(){
        super(Candidato.class);
    }
    
}
