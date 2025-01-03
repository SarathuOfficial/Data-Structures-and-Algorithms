class Solution {
    public List<String> generateParenthesis(int n) {
        // only add open paranthesis if open < n
        // only add a closing paranthesis if closed < open
        // valid IIF open == closed == n
        List<String> result = new ArrayList<>();
        backtrack(n,new StringBuilder(),0,0,result);
        return result;
    }

    public void backtrack(int n,StringBuilder sb,int open,int close,List<String> result){
        if(open == n && close == n){
            result.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(n,sb,open + 1,close,result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            backtrack(n,sb,open,close+1,result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}