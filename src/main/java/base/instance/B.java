package base.instance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class B extends A {
    public B() {
        log.debug("make B in new");
    }
}
