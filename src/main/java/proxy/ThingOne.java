package proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThingOne implements Anything {
    @Override
    public void doSomething(String who) {
        log.info(who + " do it!");
    }
}
