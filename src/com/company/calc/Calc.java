package com.company.calc;

import com.company.rpn.Rpn;
import com.company.stack.Stack;

import java.util.*;

public class Calc {

    public String getResult(ArrayList<String> rpn) {
        Stack stack = new Stack();
        for (String s : rpn) {
            if (Rpn.priority.containsKey(s)) {
                float x, y;
                x = Float.parseFloat(stack.pop());
                y = Float.parseFloat(stack.pop());
                if (s.charAt(0) == "*".charAt(0)) {
                    stack.push(Float.toString(x * y));
                } else if (s.charAt(0) == "/".charAt(0)) {
                    stack.push(Float.toString(y / x));
                } else if (s.charAt(0) == "+".charAt(0)) {
                    stack.push(Float.toString(x + y));
                } else if (s.charAt(0) == "-".charAt(0)) {
                    stack.push(Float.toString(y - x));
                }
            } else {
                stack.push(s);
            }
        }
        return stack.pop();
    }
}
