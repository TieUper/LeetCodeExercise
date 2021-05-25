package com.leecode.exercise.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombineExercise {

    List<Integer> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
//        _combine(1,n, k);
        return null;
    }

    private void _combine(int index, int n, int k) {
        if (n == index) {
            return;
        }
        System.out.println(index);
        for (int i = index; i < n; i++) {
            _combine(i, n, k);
        }
    }
}
