package com.company.rpn;

public class Main {

    public static void main(String[] args) {
        Rpn rpn = new Rpn();
        System.out.println(rpn.transformationRpn("(-5+6)*(-95*6)"));
    }
}

