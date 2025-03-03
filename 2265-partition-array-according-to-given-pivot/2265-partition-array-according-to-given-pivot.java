class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        int pivotCount = 0;

        for (int num : nums) {
            if (num < pivot) {
                res[left++] = num;
            } else if (num == pivot) {
                pivotCount++;
            }
        }

        for (int i = 0; i < pivotCount; i++) {
            res[left++] = pivot;
        }

        for (int num : nums) {
            if (num > pivot) {
                res[left++] = num;
            }
        }

        return res;
    }
}