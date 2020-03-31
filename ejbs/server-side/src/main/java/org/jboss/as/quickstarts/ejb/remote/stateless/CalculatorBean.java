package org.jboss.as.quickstarts.ejb.remote.stateless;

import org.jboss.as.quickstarts.ejb.client.CalculatorReverseClient;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.NamingException;

/**
 * @author Jaikiran Pai
 */
@Stateless
@Remote(RemoteCalculator.class)
public class CalculatorBean implements RemoteCalculator {

    @Override
    public int add(int a, int b) {
        try {
            System.out.println("*** chamada remota INI");
            System.out.println(new CalculatorReverseClient().add(a + 100, b + 100));
            System.out.println("*** chamada remota FIM");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
