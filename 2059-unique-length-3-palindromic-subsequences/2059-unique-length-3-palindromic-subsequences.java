class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> left = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        HashMap<Character, Integer> right = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0;i < s.length();i++){
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) - 1);
            if(right.get(s.charAt(i)) == 0){
                right.remove(s.charAt(i));
            }

            for (Character c : left) {
                if(right.containsKey(c)){
                    res.add(String.valueOf(c) + s.charAt(i));
                }
            }
            left.add(s.charAt(i));
        }

        return res.size();
    }
}