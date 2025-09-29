package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        TimeUnit unit2 = new Milliseconds(1000);
        printTimeUnit(unit1);
        printTimeUnit(unit2);
    }

    private static void printTimeUnit(TimeUnit unit) {

        System.out.println(unit.toSeconds());
    }
}
