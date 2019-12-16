/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Cola;
import model.Usuario;

/**
 *
 * @author flavi
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long>{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    public Usuario fazerLogin(String email, String senha){
        //a senha deve chegar nesse método criptografada
       // String senha_cripto = Criptografia.convertPasswordToMD5(senha);
        List<Usuario> admins = em.createNamedQuery("Usuario.login")
                .setParameter("email",email).setParameter("senha",senha)
                .getResultList();
        
        if(0==admins.size()){
            return new Usuario();
        }else{
            return admins.get(0);
        }
    }
   // public List<Cola> getCola(Usuario usuario) {
   //    Query query = em.createQuery("SELECT o FROM Cola o where o.usuario_id = ?1");
     //   query.setParameter(1, usuario);
      // return (List<Cola>) query.getResultList();
        
   // }
}
