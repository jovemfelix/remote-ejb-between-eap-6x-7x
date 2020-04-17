package org.jboss.as.quickstarts.ejb.remote.stateless;

import org.jboss.as.quickstarts.ejb.client.CalculatorReverseClient;

import javax.ejb.*;
import javax.naming.NamingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jaikiran Pai
 */
@Stateless
@Remote(RemoteCalculator.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CalculatorBean implements RemoteCalculator {
    private static final Logger LOGGER = Logger.getLogger(CalculatorBean.class.getName());


    private final CalculatorReverseClient reverse;

    public CalculatorBean() throws NamingException {
        this.reverse = new CalculatorReverseClient();
        // suppress output of client messages
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
        Logger.getLogger("org.xnio").setLevel(Level.OFF);
        Logger.getLogger("org.jboss.as.quickstarts").setLevel(Level.FINEST);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int add(int a, int b) {
        LOGGER.info("*** chamada remota INI");
        int x = reverse.add(a, b);
        LOGGER.info("*** chamada remota FIM");

        return x;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int subtract(int a, int b) {
        LOGGER.info("*** chamada remota INI");
        int x = reverse.subtract(a, b);
        LOGGER.info("*** chamada remota FIM");
        return x;
    }
}
