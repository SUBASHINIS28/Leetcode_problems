class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        int[] freq=new int[n];
        int[] arr=new int[2];
        int i=0;
        for(int num:nums){
            freq[num]++;
            if(freq[num]==2){
                arr[i++]=num;
            }
        }
        return arr;
    }
}