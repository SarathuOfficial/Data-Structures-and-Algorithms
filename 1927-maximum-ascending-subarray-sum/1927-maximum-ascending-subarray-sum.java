class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i - 1] < nums[i]){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(sum,res);
        }

        return res;
    }
}