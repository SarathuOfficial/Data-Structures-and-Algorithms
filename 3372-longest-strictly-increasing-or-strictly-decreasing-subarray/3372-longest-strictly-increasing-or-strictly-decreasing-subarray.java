class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incr = 1;
        int decr = 1;

        int low = 1;int high = 1;

        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] > nums[i+1]){
                high++;
                low = 1;
                incr = Math.max(incr,high);
            }else if(nums[i] < nums[i+1]){
                low++;
                high = 1;
                decr = Math.max(decr,low);
            }else{
                high = 1;
                low = 1;
            }
        }
        return incr > decr ? incr : decr;
    }
}