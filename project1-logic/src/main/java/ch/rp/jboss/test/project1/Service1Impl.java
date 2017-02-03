package ch.rp.jboss.test.project1;

import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.rp.jboss.test.project2.Service2;

@Remote(Service1.class)
@Stateless(name = "Service1")
public class Service1Impl implements Service1 {

    @Override
    public void executeAction9() {

        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
        Context ctx;
        try {
            ctx = new InitialContext(jndiProps);
            Service2 service2 = (Service2) ctx.lookup("ejb:/project2/project2/Service2!ch.rp.jboss.test.project2.Service2");
            service2.testEnlistRessource();
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
