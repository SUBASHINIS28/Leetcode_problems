class Solution {
    public String nearestPalindromic(String n) 
    {
        int len = n.length();
        long num = Long.parseLong(n);
        Set<Long>candidates = new HashSet<>();

        candidates.add((long)Math.pow(10,len)+1);
        candidates.add((long)Math.pow(10,len-1)-1);

        long p = Long.parseLong(n.substring(0,(len+1)/2));
        for(long i=p-1;i<=p+1;i++)
        {
            StringBuilder s = new StringBuilder();
            s.append(i);
            String firsthalf = s.toString();
            String secondhalf;
            if(len%2==0)
            {
                secondhalf = new StringBuilder(firsthalf).reverse().toString();
            }
            else
            {
                secondhalf = new StringBuilder(firsthalf.substring(0,firsthalf.length()-1)).reverse().toString();
            }
            String pal = firsthalf + secondhalf;
            candidates.add(Long.parseLong(pal));
        }
        candidates.remove(num);
        long md = Long.MAX_VALUE;
        long closest = -1;
        for(long cand:candidates)
        {
            long dif = Math.abs(cand - num);
            if(dif<md || (dif==md && cand < closest))
            {
                md = dif;
                closest = cand;
            }
        }
        return String.valueOf(closest);

    }
}