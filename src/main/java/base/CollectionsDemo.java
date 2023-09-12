package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ender
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(1);
        list.add("1");
        list.add("2");
        List list1 = Collections.synchronizedList(list);

    }
}
