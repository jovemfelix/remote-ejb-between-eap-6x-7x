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
    private final CalculatorReverseClient reverse;

    public CalculatorBean() throws NamingException {
        this.reverse = new CalculatorReverseClient();
    }

    @Override
    public int add(int a, int b) {
        System.out.println("*** chamada remota INI");
        int x = reverse.add(a, b);
        System.out.println("*** chamada remota FIM");

        return x;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("*** chamada remota INI");
        int x = reverse.subtract(a, b);
        System.out.println("*** chamada remota FIM");
        return x;
    }
}
