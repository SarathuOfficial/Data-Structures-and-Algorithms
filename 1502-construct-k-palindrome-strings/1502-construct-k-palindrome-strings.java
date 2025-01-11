class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }

        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        int Odd = 0;
        for(int i = 0;i < s.length();){
            char current = ch[i];
            int count = 0;
            while(i < ch.length && current == ch[i]){
                count++;
                i++;
            }

            if(count % 2 != 0){
                Odd++;
            }
        }

        return Odd <= k;
    }
}