/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninphu.ejb;

import edu.uninphu.models.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Portatil-BM
 */
@Stateless
public class LoginFacade {

    
    @PersistenceContext(unitName = "proyecto2PU")
    private EntityManager em;
    
    
    public Usuario loginUsuario(String user, String pass){
    
        try {
            return  em.createNamedQuery("Usuario.Login",Usuario.class)
                    .setParameter("user", user)
                    .setParameter("pass", pass)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
