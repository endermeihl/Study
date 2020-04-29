package netty;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
public class BIODemoTest {

    @Test
    public void test() throws IOException {
        BIODemo bioDemo=new BIODemo();
        bioDemo. bio();
    }
}
