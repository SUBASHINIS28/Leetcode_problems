public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int i = 0, n = s.length();
        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        if (i == n) return 0;

        // Check sign
        int sign = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }

        long result = 0;
        boolean digitFound = false;

        // Read digits
        while (i < n) {
            c = s.charAt(i);
            if (c < '0' || c > '9') break;

            digitFound = true;
            int digit = c - '0';

            result = result * 10 + digit;

            // Check overflow and clamp
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        if (!digitFound) return 0;

        return sign * (int) result;
    }
}