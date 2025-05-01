class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Step 1: Add all numbers to HashSet
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // Step 2: Check if num is start of sequence
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak); // Step 3: Update longest
            }
        }

        return longest;
    }
}

        