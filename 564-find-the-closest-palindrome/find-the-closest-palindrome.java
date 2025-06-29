public class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        Set<Long> candidates = new HashSet<>();

        // Edge case palindromes
        candidates.add((long)Math.pow(10, len) + 1);      // e.g. 1001 for 999
        candidates.add((long)Math.pow(10, len - 1) - 1);  // e.g. 99 for 100

        // Get prefix to generate palindromes
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String firstHalf = sb.toString();

            String secondHalf;
            if (len % 2 == 0) {
                secondHalf = new StringBuilder(firstHalf).reverse().toString();
            } else {
                secondHalf = new StringBuilder(firstHalf.substring(0, firstHalf.length() - 1)).reverse().toString();
            }

            String palindrome = firstHalf + secondHalf;
            candidates.add(Long.parseLong(palindrome));
        }

        candidates.remove(num);

        // Find the closest
        long minDiff = Long.MAX_VALUE;
        long closest = -1;
        for (long cand : candidates) {
            long diff = Math.abs(cand - num);
            if (diff < minDiff || (diff == minDiff && cand < closest)) {
                minDiff = diff;
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}
