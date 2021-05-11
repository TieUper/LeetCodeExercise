package com.leecode.exercise.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {

    private static ArrayList<String> list;

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList();
        _generateParenthesis(0, 0, n , "");
        return list;
    }

    private static void _generateParenthesis(int left, int right, int n, String s) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            _generateParenthesis(left + 1, right, n, s + "(");
        }
        if (right < left) {
            _generateParenthesis(left, right + 1, n,s + ")");
        }
    }
}
