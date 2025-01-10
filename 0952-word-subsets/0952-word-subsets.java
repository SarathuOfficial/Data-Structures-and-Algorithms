class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList();

        int[] maxfreq1 = new int[26];
        for (String word : words2) {
            int[] charFreqInWord = new int[26];
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                charFreqInWord[index]++;
                maxfreq1[index] = Math.max(maxfreq1[index], charFreqInWord[index]);
            }
        }

        for (String word : words1) {
            int[] charFreqInWord1 = new int[26];
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                charFreqInWord1[index]++;
            }

            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (charFreqInWord1[i] < maxfreq1[i]) {
                    isValid = false;
                    break; 
                }
            }

            if (isValid) {
                res.add(word);
            }
        }

        return res;
    }
}