class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
       int prefix[] = new int[words.length + 1];
       for(int i = 0;i < words.length;i++){
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            if (isVowel(first) && isVowel(last)) {
                prefix[i + 1] = prefix[i] + 1;
            }else {
                prefix[i + 1] = prefix[i];
            }
       }

       int res[] = new int[queries.length];

       for(int i = 0;i < queries.length;i++){
            int range[] = queries[i];
            res[i] = prefix[range[1] + 1] - prefix[range[0]];
       } 

       return res;
    }
     private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}