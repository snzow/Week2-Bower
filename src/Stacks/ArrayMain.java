package Stacks;

import java.util.Stack;
public class ArrayMain {

    public static void main(String[] args) {
        ArrayStack test = new ArrayStack();
        Stack s = new Stack();
        s.push(3);
        s.push(5);
        s.push(9);
        s.push(3);
        s.push(4);
        s.push(1);
        test.removeMin(s);
        System.out.println(test.isSorted(s));
        Stack s2 = new Stack();
        s2.push(10);
        s2.push(8);
        s2.push(6);
        s2.push(4);
        System.out.println(test.isSorted(s2));
    }
}