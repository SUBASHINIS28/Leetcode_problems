public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        String[] words = text.split(" ");
        int count = 0;
        outer:
        for (String w : words) {
            for (char ch : w.toCharArray()) {
                if (broken[ch - 'a']) {
                    continue outer; // this word can't be typed
                }
            }
            count++;
        }
        return count;
    }

}