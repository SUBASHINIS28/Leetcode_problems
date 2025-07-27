class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    res.add(a);
                    break;
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
