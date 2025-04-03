class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int prefixMax = nums[0];
        int maxDiff = 0;
        long res = 0;

        for (int k = 1; k < n; k++) {
            res = Math.max(res, (long) maxDiff * nums[k]);
            prefixMax = Math.max(prefixMax, nums[k]);
            maxDiff = Math.max(maxDiff, prefixMax - nums[k]);
        }

        return res;
    }
}