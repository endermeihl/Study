package proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaDevelop implements Develop {

    private String name;

    JavaDevelop(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        log.info(this.name + " is coding java.");
    }

    @Override
    public void deBug() {
        log.info(this.name + " is debugging java.");
    }
}
