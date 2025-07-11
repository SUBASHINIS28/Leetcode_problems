class Solution {
    public String findLongestWord(String s, List<String> dictionary) 
    {
        String longest = "";
        for(String word : dictionary)
        {
            int longlen = longest.length();
            int wordlen = word.length();
            if(wordlen<longlen || wordlen==longlen && word.compareTo(longest)>0)
            {
                continue;
            }
            int pos=-1;
            for(int i=0;i<wordlen;i++)
            {
                pos = s.indexOf(word.charAt(i),pos+1);
                if(pos==-1)
                {
                    break;
                }
            }
            if(pos !=-1)
            {
                longest=  word;
            }
        }
        return longest;
    }
}