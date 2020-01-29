package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Covert {

    public String covert(String s, int numRows) {
        if (numRows <= 1) return s;
        int flag = -1;
        int i = 0;
        List<StringBuilder> arr = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            arr.add(new StringBuilder());
        }
        for (int j = 0; j < s.length(); j++) {
            if (i == 0 || i == numRows - 1) flag *= -1;
            arr.get(i).append(s.charAt(j));
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            res.append(arr.get(j));
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Covert covert = new Covert();
        System.out.println(covert.covert("LEETCODEISHIRING", 4));
    }
}
