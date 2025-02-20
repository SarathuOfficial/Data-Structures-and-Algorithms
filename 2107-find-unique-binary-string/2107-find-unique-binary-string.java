class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(getValue(nums[i]));
        }

        for (int i = 0; i < Math.pow(2, nums[0].length()); i++) {
            if (!set.contains(i)) {
                return String.format("%" + nums[0].length() + "s", Integer.toBinaryString(i)).replace(' ', '0');
            }
        }
        return "";
    }

    public int getValue(String num) {
        int res = 0;
        int bit = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            res += Character.getNumericValue(num.charAt(i)) * Math.pow(2, bit++);
        }
        return res;
    }
}