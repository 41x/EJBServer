/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entity.DItem;
import java.math.BigInteger;
import javax.ejb.Remote;

/**
 *
 * @author iskra
 */
@Remote
public interface PersistBeanRemote {
    void addData(DItem item);
    long getDbCount();
    void cleanTable();
}
