/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
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
package org.jboss.as.quickstarts.ejb.client;

import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculatorReverse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * A simple standalone application which uses the JBoss API to invoke the MainApp demonstration Bean.
 * </p>
 *
 * @author <a href="mailto:wfink@redhat.com">Wolf-Dieter Fink</a>
 */
public class CalculatorReverseClient {
    public CalculatorReverseClient() throws NamingException {
        // suppress output of client messages
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
        Logger.getLogger("org.xnio").setLevel(Level.OFF);

        InitialContext context = getInitialContext();

        String lookupName = "ejb:" + "ear-6.4.0.GA/org.jboss.quickstarts.eap-ejb-remote-server-side-reverse-6.4.0.GA/CalculatorReverseBean!org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculatorReverse";
//        String lookupName = "ejb:/" + "ear-6.4.0.GA/org.jboss.quickstarts.eap-ejb-remote-server-side-reverse-6.4.0.GA/CalculatorReverseBean!org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculatorReverse";


        System.out.println("\t [lookupName] " + lookupName);
        Object lookup = context.lookup(lookupName);
        System.out.println("\t ** lookup >> " + lookup);
        calculator = (RemoteCalculatorReverse) lookup;
    }

    private RemoteCalculatorReverse calculator;

    public static InitialContext getInitialContext() throws NamingException {
        Properties p = new Properties();
        p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        return new InitialContext(p);
    }

    public static void main(String[] args) throws Exception {
//        int a = 204;
//        int b = 340;
//        new CalculatorReverseClient().add(a, b);
        System.out.println(RemoteCalculatorReverse.class.getSimpleName());
    }

    public int add(int a, int b) {
        System.out.println("\t ** Adicionando " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = calculator.add(a, b);
        System.out.println("Remote calculator returned = " + sum);

        return sum;
    }

    public int subtract(int a, int b) {
        System.out.println("\t ** Subtraindo " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = calculator.subtract(a, b);
        System.out.println("Remote calculator returned = " + sum);

        return sum;
    }

}
