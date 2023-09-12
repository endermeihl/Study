package test;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMbject {

    }

    public static void main(String[] args) {
        List<OOMbject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMbject());
        }
    }
}
