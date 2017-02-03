package ch.rp.jboss.test.project.gui;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.rp.jboss.test.project1.Service1;

public class Main {

    public static void main(String[] args) throws NamingException {

        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        // lookup the bean     Foo
        Service1 service1 = (Service1) ctx.lookup("ejb:/project1/project1/Service1!ch.rp.jboss.test.project1.Service1");
        service1.executeAction9();

        ctx.close();
    }
}
