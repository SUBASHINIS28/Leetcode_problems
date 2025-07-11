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
            int lpos=-1;
            for(int i=0;i<wordlen;i++)
            {
                lpos=s.indexOf(word.charAt(i),lpos+1);
                if(lpos==-1)
                {
                    break;
                }
            }
            if(lpos !=-1)
            {
                longest=word;
            }
        }
        return longest;
    }
}