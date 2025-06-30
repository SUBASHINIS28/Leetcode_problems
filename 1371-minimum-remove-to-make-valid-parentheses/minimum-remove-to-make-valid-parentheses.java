class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str  = new StringBuilder(s);
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c=='(')
            {
                stack.push(i);
            }
            else if(c==')')
            {
                if(stack.empty())
                {
                    str.deleteCharAt(i);
                    i -= 1;
                }
                if(!stack.empty())
                {
                    stack.pop();
                }
            }
        }
        while(!stack.empty())
        {
            str.deleteCharAt(stack.peek());
            stack.pop();
        }
        return str.toString();
    }
}