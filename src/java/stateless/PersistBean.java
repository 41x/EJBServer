/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entity.DItem;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        BigInteger count = (BigInteger)entityManager.createNativeQuery("SELECT Count(*) from testdata").getSingleResult();
        return count.longValue();
    }
    @Override
    public void cleanTable(){
        entityManager.createNativeQuery("delete FROM testdata").executeUpdate();
    }
}
