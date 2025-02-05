class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
       if(s1.length() != s2.length()){
            return false;
       }

       HashMap<Character,Integer> map = new  HashMap<>();
       for(int i = 0;i < s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i), 0) + 1);
       }

       for(int i =0;i < s2.length();i++){
            if(map.getOrDefault(s2.charAt(i), 0) > 0){
                map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i), 0) - 1);
            }else{
                return false;
            }
       }

       int count = 0;
       for(int i = 0;i < s1.length();i++){
        if(s1.charAt(i) != s2.charAt(i)){
            count++;
        }
       }

        return count == 2 || count == 0;
    }
}