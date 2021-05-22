package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(phoneMap, 0, digits.toCharArray(), new StringBuilder(), combinations);

        return combinations;
    }

    private static void dfs(Map<Character, String> phoneMap, int depth, char[] digits, StringBuilder builder, List<String> combinations) {
        if (depth == digits.length) {
            combinations.add(builder.toString());
        } else {
            char digit = digits[depth];
            String s = phoneMap.get(digit);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                builder.append(chars[i]);
                dfs(phoneMap, depth + 1, digits, builder, combinations);
                builder.deleteCharAt(depth);
            }
        }
    }

}
