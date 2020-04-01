package org.jboss.as.quickstarts.ejb.remote.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Jaikiran Pai
 */
@Stateless
@Remote(RemoteCalculatorReverse.class)
public class CalculatorReverseBean implements RemoteCalculatorReverse {

    @Override
    public int add(int a, int b) {
        System.out.println("\n\n no REVERSE \n\n");
        return a - b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("\n\n no REVERSE \n\n");
        return a + b;
    }
}
