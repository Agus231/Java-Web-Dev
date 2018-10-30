package timer;

import entity.Port;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class TimedInfo extends TimerTask {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void run() {
        var instance = Port.getInstance();
        var portWh = instance.getPortWarehouse();

        logger.info("Port WH : " + portWh);
    }
}
