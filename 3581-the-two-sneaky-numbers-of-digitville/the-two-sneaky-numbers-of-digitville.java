class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int[] arr=new int[2];
        int i=0;
        for(int num:nums){
            if(set.contains(num)){
                arr[i++]=num;
            }
            set.add(num);
        }
        return arr;
    }
}