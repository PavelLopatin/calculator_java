package com.company.stack;

import java.util.ArrayList;

public class Stack {
    ArrayList<String> stack;

    public void push(String elem) {
        stack.add(elem);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String aString : stack) {
            res.append(aString);
            res.append(" ");
        }
        return res.toString();
    }

    public String stringElem() {
        if (isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return (stack.size() != 0);
    }

    public String pop() {
        if (isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            System.out.println("Stack is empty");
            return "None";
        }
    }

    public Stack() {
        stack = new ArrayList<>();
    }
}
