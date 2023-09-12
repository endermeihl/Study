package Algorithm.study.first;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
    /**这个要注意一个比较大的问题，这个方法要求输入不省略任何的括号，每个运算都必须用括号扩起来**/
    public Double evaluate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(':
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c);
                    break;
                case ')': {
                    Character op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case '+':
                            v = vals.pop() + v;
                            break;
                        case '-':
                            v = vals.pop() - v;
                            break;
                        case '*':
                            v = vals.pop() * v;
                            break;
                        case '/':
                            v = vals.pop() / v;
                            break;
                    }
                    vals.push(v);
                    break;
                }
                default:
                    vals.push(Double.parseDouble(c.toString()));
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        Evaluate evaluate = new Evaluate();
        StdOut.print(evaluate.evaluate("1+2+3"));
    }
}
