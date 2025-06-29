class Solution {
    public boolean isNumber(String s) 
    {
        boolean num=false,exp=false,sign=false,dec=false;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c>='0' && c<='9')
            {
                num=true;
            }
            else if(c=='e' || c=='E')
            {
                if(exp || !num)return false;
                    exp = true;
                    sign=false;
                    num=false;
                    dec=false;
                
            }
            else if(c=='+' || c=='-')
            {
                if(sign||num||dec) return false;
                    sign =true;
                
            }
            else if(c=='.')
            {
                if(dec||exp) return false;
                    dec=true;
                
            }
            else
            {
                return false;
            }
        }
        return num;
    }
}