package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDemo {
    protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void log(Object o) {
        this.logger.debug(o.toString());
    }
}
