class Solution {
    public boolean isNumber(String S) {
        boolean num = false, exp = false, sign = false, dec = false;
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            if (c >= '0' && c <= '9') {
                num = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !num) 
                return false;// false, if no number before exp
                exp = true;
                sign = false;
                num = false;
                dec = false;
            } else if (c == '+' || c == '-')
             {
                if (sign || num || dec) 
                return false; // false, any num or dec before
                sign = true;
            } else if (c == '.') {
                if (dec || exp) 
                return false; //false if any exp before 
                dec = true;
            } else {
                return false;
            }
        }
        return num;
    }
}