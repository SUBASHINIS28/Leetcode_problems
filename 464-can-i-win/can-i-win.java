import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int total = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (total < desiredTotal) return false;
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(desiredTotal, 0, maxChoosableInteger, memo);
    }

    private boolean dfs(int target, int mask, int max, Map<Integer, Boolean> memo) {
        if (memo.containsKey(mask)) return memo.get(mask);
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                if (i >= target || !dfs(target - i, mask | bit, max, memo)) {
                    memo.put(mask, true);
                    return true;
                }
            }
        }
        memo.put(mask, false);
        return false;
    }
}
