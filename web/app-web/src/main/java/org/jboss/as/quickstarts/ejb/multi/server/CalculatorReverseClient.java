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
package org.jboss.as.quickstarts.ejb.multi.server;

import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculator;
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
    private static final Logger LOGGER = Logger.getLogger(CalculatorReverseClient.class.getName());

    public CalculatorReverseClient() throws NamingException {
        // suppress output of client messages
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
        Logger.getLogger("org.xnio").setLevel(Level.OFF);
        Logger.getLogger("org.jboss.as.quickstarts").setLevel(Level.FINEST);

        InitialContext context = getInitialContext();
        String moduleName = "ejb-remote-server-side-reverse";
        String simpleName = "CalculatorReverseBean";
        String lookupName = "ejb:/" + moduleName + "/" + simpleName + "!" + RemoteCalculatorReverse.class.getName();
//        String lookupName = "ejb:/" + moduleName + "/" + simpleName + "!" + RemoteCalculatorReverse.class.getName();
        LOGGER.info("[lookupName] " + lookupName);
        Object lookup = context.lookup(lookupName);
        LOGGER.info("** lookup >> " + lookup);
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
        LOGGER.info(RemoteCalculatorReverse.class.getSimpleName());
    }

    public int add(int a, int b) {
        LOGGER.info("** Adicionando " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = calculator.add(a, b);
        LOGGER.info("Remote calculator returned = " + sum);

        return sum;
    }

    public int subtract(int a, int b) {
        LOGGER.info("** Subtraindo " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = calculator.subtract(a, b);
        LOGGER.info("Remote calculator returned = " + sum);

        return sum;
    }

}
