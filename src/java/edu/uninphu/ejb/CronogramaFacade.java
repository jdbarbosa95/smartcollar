/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninphu.ejb;

import edu.uninphu.models.Cronograma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Portatil-BM
 */
@Stateless
public class CronogramaFacade extends AbstractFacade<Cronograma> {

    @PersistenceContext(unitName = "proyecto2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CronogramaFacade() {
        super(Cronograma.class);
    }
    
}
