package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        if (length < 4 || length > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, length,0, 4, path, res);
        return res;
    }

    private static void dfs(String s, int length, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == length) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= length) {
                break;
            }

            if (residue * 3 < length - i) {
                //剪枝， 后面不满足
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentInSegment = s.substring(begin, i + 1);
                path.add(currentInSegment);
//                System.out.println(path);
                dfs(s, length, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left;
        if (len > 0 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
