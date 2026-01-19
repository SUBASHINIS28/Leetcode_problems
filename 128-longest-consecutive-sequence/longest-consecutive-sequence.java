class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currlength=1;
                while(set.contains(currlength+num)){
                    currlength++;
                }
                maxLen=Math.max(currlength, maxLen);
            }
        }
        return maxLen;
    }
}
