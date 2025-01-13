class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        for(int i = 0;i < s.length();i++){
            freq[s.charAt(i) - 'a']++;
        } 

        int res = 0;
        for(int i = 0;i < freq.length;i++){
            if(freq[i] % 2 == 1){
                res++;
            }else{
                res = res + Math.min(2,freq[i]);
            }
        }
        return res;
    }
}