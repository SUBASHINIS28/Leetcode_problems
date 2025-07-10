class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));
        List<Integer> ht=new ArrayList<>();
        for(int arr[]:envelopes){
            int h=arr[1];
            int ind=Collections.binarySearch(ht,h);
            if(ind<0){
                ind=-(ind+1);
            }
            if(ht.size()==ind){
                ht.add(h);
            }else{
                ht.set(ind,h);
            }
        }
        return ht.size();
    }
}