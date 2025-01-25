class Solution {
    public int maxScore(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i + 1 < s.length()) {
                res = Math.max(setbits(s.substring(0, i + 1),false) + setbits(s.substring(i + 1),true),res);
            }
        }
        return res;
    }
    public int setbits(String s,boolean setbit){
        int bit = 0;
        if(setbit){
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == '1'){
                    bit++;
                }
            }
        }else{
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == '0'){
                    bit++;
                }
            }
        }
        return bit;
    }
}