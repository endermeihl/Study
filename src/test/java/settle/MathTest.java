package settle;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathTest {
    @Test
    public void test1() {
        BigDecimal fee = new BigDecimal("39.99");
        BigDecimal result = fee.multiply(new BigDecimal(10)).divide(new BigDecimal("100"));


        System.out.println(BigDecimalUtil.setScaleRound(result));
    }

    static class BigDecimalUtil {

        /**
         * 保留两位小树-四舍五入
         *
         * @param object
         * @return
         */
        static BigDecimal setScaleRound(BigDecimal object) {
            if (object == null) {
                return null;
            }
            return object.setScale(2, RoundingMode.HALF_UP);
        }

        static BigDecimal stringToBigDecimal(String num) {
            if (num == null) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal(num);
        }
    }
}
