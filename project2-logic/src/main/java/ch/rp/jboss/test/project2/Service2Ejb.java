package ch.rp.jboss.test.project2;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

@Remote(Service2.class)
@Stateless(name = "Service2")
public class Service2Ejb implements Service2 {

    @Resource(mappedName = "java:jboss/TransactionManager")
    TransactionManager transactionManager;

    @Override
    public void testEnlistRessource() {
        try {
            transactionManager.getTransaction().enlistResource(new DummyXARessource("resource1"));
            transactionManager.getTransaction().enlistResource(new DummyXARessource("resource2"));
        } catch (IllegalStateException | RollbackException | SystemException e) {
            e.printStackTrace();
        }
    }

}
