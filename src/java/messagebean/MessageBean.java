/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagebean;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.DItem;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
//import org.codehaus.jackson.map.ObjectMapper;
import stateless.PersistBeanRemote;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/ejb3Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageBean implements MessageListener {

    public MessageBean() {
    }

    @Resource
    private MessageDrivenContext mdctx;

    @EJB
    PersistBeanRemote entityBean;

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = null;
        try {
            objectMessage = (ObjectMessage) message;
            String jsn = (String) objectMessage.getObject();

            DItem item = jsnToDitem(jsn);
            if (item == null) {
                return;
            }
            entityBean.addData(item);
        } catch (Exception ex) {
            logError(ex);
            mdctx.setRollbackOnly();
        }
    }

    private DItem jsnToDitem(String jsn) {
        ObjectMapper mapper = new ObjectMapper();
        DItem item = null;
        try {
            item = mapper.readValue(jsn, DItem.class);
        } catch (Exception e) {
            logError(e);
            return null;
        }
        return item;
    }

    private void logError(Exception e) {
        System.out.println(e.getMessage());
    }

}
