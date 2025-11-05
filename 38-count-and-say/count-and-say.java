class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
            for (int j = 1; j < result.length(); j++) {
                char ch = result.charAt(j);
                if (ch == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    prev = ch;
                    count = 1;
                }
            }
            sb.append(count).append(prev);
            result = sb.toString();
        }
        return result;
    }
}
