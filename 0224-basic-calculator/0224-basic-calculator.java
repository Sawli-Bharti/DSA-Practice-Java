class Solution {
    private void value(Stack<Integer> st, Stack<Character> op){
        while(!op.isEmpty() && op.peek()!='('){
                    int b=st.pop();
                    int a=st.pop();
                    if(op.peek()=='+') st.push(a+b);
                    else st.push(a-b);
                    op.pop();
         }
    }
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Character> op=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c!=' ') sb.append(c);
        }
        int i=0;
        while(i<sb.length()){
            char c=sb.charAt(i);
           if(c==')'){
                value(st,op);
                if(!op.isEmpty()) op.pop();
                value(st,op);
            }else if(c>='0' && c<='9'){
                int num=0;
                while(i<sb.length() && sb.charAt(i)>='0' && sb.charAt(i)<='9'){
                    num*=10;
                    num+=sb.charAt(i)-'0';
                    i++;
                }
                st.push(num);
                value(st,op);
                continue;
            }else if(c=='+' || c=='-' || c=='('){
                if(c=='-' && (i==0 ||sb.charAt(i-1)=='(')) st.push(0);
                op.push(c);
            }
            i++;
        }
        return st.peek();
    }
}