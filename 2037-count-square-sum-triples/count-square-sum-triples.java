class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int c=0;c<=n;c++){
            for(int a=1;a<c;a++){
                int rem=(c*c)-(a*a);
                int b=(int)Math.sqrt(rem);
                if((b*b)==rem && b>=1){
                    count++;
                }
            }
        }
        return count;
    }
}