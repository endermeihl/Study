package base.instance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A implements Cloneable {
    public A() {
        log.debug("make a use new");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        log.debug("clone A");
        return super.clone();
    }
}
