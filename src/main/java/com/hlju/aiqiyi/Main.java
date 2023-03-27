package com.hlju.aiqiyi;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int n;
    private volatile int num = 1;
    Lock lock = new ReentrantLock();
    Condition zeroCondition = lock.newCondition();
    Condition evenCondition = lock.newCondition();
    Condition oddCondition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                printNumber.accept(0);
                zeroCondition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                while ((num & 1) != 0) {
                    evenCondition.await();
                }
                zeroCondition.signal();
                if (num <= n) {
                    printNumber.accept(num++);
                }
                oddCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (num <= n) {
                while ((num & 1) != 1) {
                    oddCondition.await();
                }
                zeroCondition.signal();
                if (num <= n) {
                    printNumber.accept(num++);
                }
                evenCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}