package com.leecode.exercise.recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0,0,"",res);
        return res;
    }

    private static void dfs(String s,int depth, int total, String result, List<String> res) {
//        if (result > 3) {
//            System.out.println(result);
//            return;
//        }
        for (int i = depth; i < s.length(); i++) {
            int value = s.charAt(i) - '0';
            value += total;
            if (value < 255) {
                result += value;
                if (result.length() == s.length() + 3) {
                    res.add(result);
                }
                result += ".";
                dfs(s, depth + 1, value,result,res);
            }else {
                break;
            }

        }
    }
}
