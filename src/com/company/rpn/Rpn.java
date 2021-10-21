package com.company.rpn;

import com.company.stack.Stack;

import java.util.*;

public class Rpn {
    public static String[] signs = new String[]{"+", "-", "*", "/", "(", ")"};
    // реализовать через метод
    public static Map<String, Integer> priority = new HashMap<>();

    static {
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("/", 2);
        priority.put("*", 2);
    }

    public boolean prioritySigns(String x, String y) {
        if (!priority.containsKey(x) || !priority.containsKey(y)) {
            return false;
        }
        return (priority.get(x) >= priority.get(y));
    }

    public ArrayList<String> addingGaps(String expression) {
        for (String sign : signs) {
            expression = expression.replace(sign, " " + sign + " ").trim();
        }
        ArrayList<String> subExpression = new ArrayList();
        subExpression.addAll(Arrays.asList(expression.split(" ")));
        while (subExpression.contains("")) {
            subExpression.remove("");
        }
        return subExpression;
    }

    public ArrayList<String> convertingNegativeNumbers(ArrayList<String> expression) {
        for (int count = 0; count < expression.size(); count++) {
            if (expression.get(0).charAt(0) == '-' && count == 0) {
                expression.remove(0);
                expression.set(0, "-" + expression.get(0));
            } else if (expression.get(count).charAt(0) == "-".charAt(0) && count > 0
                       && expression.get(count - 1).charAt(0) != ')') {
                if (Arrays.asList(signs).contains(expression.get(count - 1))) {
                    expression.remove(count);
                    expression.set(count, "-" + expression.get(count));
                }
            }
        }
        return expression;
    }

    public ArrayList<String> transformationRpn(String expression) {
        ArrayList<String> subExpression = convertingNegativeNumbers(addingGaps(expression));
        Stack stack = new Stack();
        ArrayList<String> result = new ArrayList<>();
        for (String s : subExpression) {
            if (priority.containsKey(s)) {
                while (stack.isEmpty() && prioritySigns(stack.stringElem(), s)) {
                    result.add(stack.pop());
                }
                stack.push(s);
            } else if (s.charAt(0) == "(".charAt(0)) {
                stack.push(s);
            } else if (s.charAt(0) == ")".charAt(0)) {
                while (stack.stringElem().charAt(0) != "(".charAt(0)) {
                    result.add(stack.pop());
                }
                stack.pop();
            } else {
                result.add(s);
            }
        }
        while (stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
