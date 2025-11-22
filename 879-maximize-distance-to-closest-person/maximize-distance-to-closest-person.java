class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev=-1;
        int n=seats.length;
        int maxdist=0;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                if(prev==-1){
                    maxdist=Math.max(maxdist, i);
                }
                else{
                    maxdist=Math.max(maxdist, (i-prev)/2);
                }
                prev=i;
            }
        }
        maxdist=Math.max(maxdist, n-1-prev);
        return maxdist;
    }
}