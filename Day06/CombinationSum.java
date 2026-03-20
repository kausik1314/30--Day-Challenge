/*
Problem: Combination Sum
Platform: LeetCode
Topic: Backtracking

Approach:
Use backtracking to build combinations that sum to the target.
Since we can use the same element multiple times, we pass the same start index recursively.

Time Complexity: O(N^(T/M)) where N is candidates, T is target, M is min value
Space Complexity: O(T/M)
*/

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] cands, int remain, int start, List<Integer> temp, List<List<Integer>> res) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < cands.length; i++) {
            temp.add(cands[i]);
            backtrack(cands, remain - cands[i], i, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
