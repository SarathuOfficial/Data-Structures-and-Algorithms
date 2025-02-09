class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        long goodPairs = 0;
        
        for (int i = 0; i < n; ++i) {
            int key = nums[i] - i;
            if (freq.containsKey(key)) {
                goodPairs += freq.get(key);
            }
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        
        long badPairs = n * (n - 1) / 2 - goodPairs;
        return badPairs;
    }
}