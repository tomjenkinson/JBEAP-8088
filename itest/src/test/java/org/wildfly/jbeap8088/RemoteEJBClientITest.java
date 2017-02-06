/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.jbeap8088;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.junit.Test;

import ch.rp.jboss.test.project1.Service1;

/**
 * A sample program which acts a remote client for a EJB deployed on AS7 server. This program shows how to lookup stateful and
 * stateless beans via JNDI and then invoke on them
 *
 * @author Jaikiran Pai
 */
public class RemoteEJBClientITest {

    private static final Logger log = Logger.getLogger(RemoteEJBClientITest.class);

    @Test
    public void invokeStatefulBean() throws NamingException, InterruptedException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
        Context ctx = new InitialContext(jndiProps);
        // lookup the bean     Foo
        Service1 service1 = (Service1) ctx.lookup("ejb:/project1/project1/Service1!ch.rp.jboss.test.project1.Service1");
        service1.executeAction9();

        ctx.close();
    }

}
