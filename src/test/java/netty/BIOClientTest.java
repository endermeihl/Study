package netty;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BIOClientTest {
    @Test
    public void test() {
        BioClient bioClient = new BioClient();
        bioClient.client();
    }
}
