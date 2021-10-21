package com.company.calc;

import com.company.rpn.Rpn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rpn rpn = new Rpn();
        Scanner in = new Scanner(System.in);
        Calc calc = new Calc();
        while (true) {
            ArrayList<String> expression = rpn.transformationRpn(in.next());
            System.out.println(calc.getResult(expression));
        }
    }
}