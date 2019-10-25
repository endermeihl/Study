package fuction;

import base.BaseDemo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDemo extends BaseDemo {

    @Test
    public void listFilter() {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 101).forEach(list::add);
        list.stream().filter((item) -> item % 5 == 0)
                .filter((item) -> item % 3 == 0)
                .map(integer -> integer * integer)
                .forEach((integer -> logger.debug(String.valueOf(integer))));
        //list.stream().filter((item) -> item % 9 == 0).forEach((item) -> logger.debug(String.valueOf(item)));
        List<Integer> list2 = list.stream().filter((item) -> item % 2 == 0).collect(Collectors.toList());
        list2.forEach((item) -> logger.debug(String.valueOf(item)));
        logger.debug(String.valueOf(list2.size()));
    }
}
