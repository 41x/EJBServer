/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entity.DItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iskra
 */
@Stateless
public class PersistBean implements PersistBeanRemote {

    public PersistBean() {
    }

    @PersistenceContext(unitName = "EjbComponentPU")
    private EntityManager entityManager;

    @Override
    public void addData(DItem item) {
        entityManager.persist(item);
    }

    @Override
    public long getDbCount() {
        return (long) entityManager.createQuery("select count(*) from data").getSingleResult();
    }
}
