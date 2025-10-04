class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }

    backtracking(0, nums, result);
    return result;
  }

  private void backtracking(int index, int[] nums, List<List<Integer>> result) {
    if (index == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (int num : nums) {
        temp.add(num);
      }
      result.add(temp);
      return;
    }

    // Set<Integer> used = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      // if(used.contains(nums[i])) continue;
      // used.add(nums[i]);

      boolean skip = false;
      for (int j = index; j < i; j ++) {
        if (nums[i] == nums[j]) {
          skip = true;
          break;
        }
      }
      if (skip) continue;
      
      swap(nums, i, index);
      backtracking (index + 1, nums, result);
      swap(nums, i, index);
    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}