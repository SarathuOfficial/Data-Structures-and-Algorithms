class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int leftMax = nums[0];

        for (int j = 1; j < n; j++) {
            if (nums[j] > leftMax) {
                leftMax = nums[j];
                continue;
            }

            for (int k = j + 1; k < n; k++) {
                res = Math.max(res, (long) (leftMax - nums[j]) * nums[k]);
            }
        }
        
        return res;
    }
}