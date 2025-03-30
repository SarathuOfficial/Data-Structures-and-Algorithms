class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        
        // Traverse the string and find partition points
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            
            // If the current index reaches the last occurrence of the partition, store size
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        
        return res;
    }
}