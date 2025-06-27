class Solution {
    public int maxProduct(int[] a) 
    {
        int m = a[0], n = a[0], r = a[0];
        for (int i = 1; i < a.length; i++) {
            int t = m;
            m = Math.max(a[i], Math.max(a[i] * m, a[i] * n));
            n = Math.min(a[i], Math.min(a[i] * t, a[i] * n));
            r = Math.max(r, m);
        }
        return r;
    }
}