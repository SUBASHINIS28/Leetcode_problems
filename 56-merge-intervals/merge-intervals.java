class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int index = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while(index < intervals.length){
            int newst = intervals[index][0];
            int currend = intervals[index][1];
            while(index < intervals.length-1 && currend >=  intervals[index+1][0]){
                currend =  Math.max(currend,intervals[index+1][1]);
                index++;
            }
            int newend = currend;
            res.add(new int[]{newst,newend});
            index++; 
        }
        index = 0;
        int[][]ans = new int[res.size()][2];

        for(int[] arr : res){
            ans[index++] = arr;
        }
        return ans;
    }
}
