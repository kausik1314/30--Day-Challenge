/*
Problem: Combination Sum II
Platform: LeetCode
Topic: Backtracking / Array

Approach:
Sort the array first to handle duplicates easily.
Use backtracking to explore combinations. If the current sum exceeds target, stop.
If the current candidate is same as the previous one, and not picked in this depth, skip it to avoid duplicates.

Time Complexity: O(2^N) in the worst case
Space Complexity: O(N) for recursion stack
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int[] candidates, int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (remain < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            curr.add(candidates[i]);
            backtrack(res, curr, candidates, remain - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
