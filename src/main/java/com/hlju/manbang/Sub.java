package com.hlju.manbang;

public class Sub extends Super {
    public Sub() {
        System.out.println("sub...");
    }
    @Override
    public long method() {
        return 1;
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}
