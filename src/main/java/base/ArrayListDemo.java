package base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ender
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(1);
        list.add("1");
        list.add("2");
        System.out.println(list.size());
    }
}
