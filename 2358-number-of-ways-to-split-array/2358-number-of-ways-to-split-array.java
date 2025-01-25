class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long prefixSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) { 
            prefixSum += nums[i]; 
            if (prefixSum >= total - prefixSum) { 
                res++;
            }
        }

        return res;
    }
}