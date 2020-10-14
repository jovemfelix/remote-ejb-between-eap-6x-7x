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
package org.jboss.as.quickstarts.web.multi.server.app;

import org.jboss.as.quickstarts.ejb.multi.server.CalculatorClient;
import org.jboss.as.quickstarts.ejb.multi.server.CalculatorReverseClient;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 * A simple servlet that is used to invoke all other application EJB's.
 *
 * @author <a href="mailto:wfink@redhat.com">Wolf-Dieter Fink</a>
 */
@WebServlet(urlPatterns = "/*")
public class Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Servlet.class.getName());
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/plain");
            int a,b;

            a = 1;
            b = 10;
            write(response, "------ NATURAL ORDER");
            CalculatorReverseClient calc = new CalculatorReverseClient();

            write(response, String.format("%s %s %s = %s", a, "+", b, calc.add(a, b)));
            write(response, "------");

            a = 99;
            b = 7;
            write(response, String.format("%s %s %s = %s", a, "-", b, calc.subtract(a, b)));
            write(response, "------");
            write(response, "OK!");

            LOGGER.info("SUCESS!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Servlet is called in " + new Date());
    }


    private static void write(HttpServletResponse writer, String message) {

        try {
            writer.getWriter().write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
