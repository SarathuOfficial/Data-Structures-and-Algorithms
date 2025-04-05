class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        int with = dfs(nums, index + 1, currentXOR ^ nums[index]);
        int without = dfs(nums, index + 1, currentXOR);
        return with + without;
    }
}