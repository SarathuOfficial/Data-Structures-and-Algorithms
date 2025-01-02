class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        boolean positive = true;
        StringBuilder sb = new StringBuilder(s);
         while (sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.delete(0, 1);
        }
        if (sb.length() > 0 && sb.charAt(0) == '-') {
            positive = false;
            sb.delete(0, 1);
        }else if (sb.length() > 0 && sb.charAt(0) == '+') {
            sb.delete(0, 1);
        }
        for(int i = 0;i < sb.length();i++){
            if (Character.isDigit(sb.charAt(i))) {
                int num = Character.getNumericValue(sb.charAt(i));
                if (ans > (Integer.MAX_VALUE - num) / 10) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + num;
            }else{
                break;
            }
        }
        if(!positive){
            ans = ans * -1;
        }
        return ans;
    }
}