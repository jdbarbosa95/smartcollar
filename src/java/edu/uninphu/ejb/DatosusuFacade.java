/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninphu.ejb;

import edu.uninphu.models.Datosusu;
import edu.uninphu.models.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Portatil-BM
 */
@Stateless
public class DatosusuFacade extends AbstractFacade<Datosusu> {

    @PersistenceContext(unitName = "proyecto2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosusuFacade() {
        super(Datosusu.class);
    }
    
    public Datosusu datoslog(Usuario usu){
        try {
            return em.createNamedQuery("Dtosusu.datoslogin",Datosusu.class)
                    .setParameter("idusu", usu.getIdUsuario())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
