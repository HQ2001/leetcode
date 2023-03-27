package com.hlju;

public class Singleton {

    private volatile Singleton obj = null;

    private Singleton() {}

    public synchronized Singleton getSingleton() {
        if (obj == null) {
            synchronized (Singleton.class) {
                if (obj == null) {
                    return new Singleton();
                }
            }
        }
        return obj;
    }

}
