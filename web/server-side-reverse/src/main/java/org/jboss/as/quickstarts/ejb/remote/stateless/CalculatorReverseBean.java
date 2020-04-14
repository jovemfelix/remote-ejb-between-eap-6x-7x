package org.jboss.as.quickstarts.ejb.remote.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jaikiran Pai
 */
@Stateless
@Remote(RemoteCalculatorReverse.class)
public class CalculatorReverseBean implements RemoteCalculatorReverse {
    private static final Logger LOGGER = Logger.getLogger(CalculatorReverseBean.class.getName());

    public CalculatorReverseBean() {
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
        Logger.getLogger("org.xnio").setLevel(Level.OFF);
        Logger.getLogger("org.jboss.as.quickstarts").setLevel(Level.FINEST);
    }

    @Override
    public int add(int a, int b) {
        LOGGER.info("no REVERSE");
        return a - b;
    }

    @Override
    public int subtract(int a, int b) {
        LOGGER.info("no REVERSE");
        return a + b;
    }
}
