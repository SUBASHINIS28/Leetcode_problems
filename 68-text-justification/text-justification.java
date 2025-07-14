class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List <String> ans = new ArrayList<>();
        int first = 0;
        while(first < words.length)
        {
            int last = first + 1;
            int len = words[first].length();
            while(last < words.length && len+1+words[last].length()<=maxWidth)
            {
                len = len+1+words[last].length();
                last++;
            }
            int totalspace = 0,totalword = last - first,totalchar = 0;

            for(int i=first;i<last;i++){
                totalchar = totalchar + words[i].length();
            }
            totalspace = maxWidth - totalchar;
            StringBuilder line = new StringBuilder();
            if(totalword == 1 || last == words.length){
                for(int i=first ; i<last ; i++)
                {
                    line.append(words[i]);
                    if(i < last-1)
                    {
                    line.append(" ");
                    }
                }
                while(line.length()<maxWidth){
                    line.append(" ");
                }
            }
            else{
                int mandatory = totalspace/(totalword-1);
                int extra = totalspace % (totalword - 1);
                for(int i=first ; i<last ; i++)
                {
                    line.append(words[i]);
                    if(i < last-1){
                    int space = mandatory + (extra-- >0 ? 1 : 0);
                    for(int j=0;j<space;j++){
                        line.append(" ");
                    }
                }

                } 
                
            }
            ans.add(line.toString());
            first = last;
        }
        return ans;
    }
}