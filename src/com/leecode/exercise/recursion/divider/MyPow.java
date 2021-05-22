package com.leecode.exercise.recursion.divider;

public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow2(2, 10));
    }

    /**
     * 暴力法 ， 超时
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double result = x;

        int count = Math.abs(n);
        for (int i = 0; i < count - 1; i++) {
            result = result * x;
        }
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }

    /**
     * 递归
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        long N = n;
        return N > 0 ? _myPow2(x, N) : 1.0 / _myPow2(x, -N);
    }

    private static double _myPow2(double x, long n) {
        if (n == 0) {
            System.out.println("n1:" + n);
            return 1.0;
        }
        double y = _myPow2(x, n / 2);
        return n % 2 == 1 ? y * y * x : y * y;
    }


}
