class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        for(int i = 0;i < words.length; i++){
            String word1 = words[i];
            for(int j = 0;j < words.length;j++){
                if(i == j){
                    continue;
                }
                String word2 = words[j];
                if(word1.length() > word2.length()){
                    continue;
                }
                
                for(int index = 0;index < word2.length();index++){
                    if(word1.charAt(0) == word2.charAt(index)){
                        if(word2.length() - index >= word1.length()){
                            String substr = word2.substring(index, index + word1.length());
                            if(word1.equals(substr)){
                                if(!res.contains(word1)){
                                    res.add(word1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}