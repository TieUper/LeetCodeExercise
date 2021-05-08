package com.leecode.exercise.array;

class ArrayExeClass {

    public static void main(String[] args) {
        int max = 0;
        int n = 20;
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
            System.out.println(a[i]);
        }
        System.out.println(a[n]);
    }
}
