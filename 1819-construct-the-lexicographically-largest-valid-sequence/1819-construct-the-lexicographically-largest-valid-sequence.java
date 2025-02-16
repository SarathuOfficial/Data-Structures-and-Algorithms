class Solution {
    private boolean findLargestArray(int[] res, boolean[] used, int pos, int n) {
        if (pos == 2 * n - 1) return true;
        if (res[pos] != 0) 
            return findLargestArray(res, used, pos + 1, n);

        for (int i = n; i >= 1; --i) { 
            if (used[i]) continue;

            used[i] = true;
            res[pos] = i;
            if (i == 1 && findLargestArray(res, used, pos + 1, n))
                return true;
            if (i > 1 && (pos + i) < (2 * n - 1) && res[pos + i] == 0) {
                res[pos + i] = i;
                if (findLargestArray(res, used, pos + 1, n))
                    return true;
                res[pos + i] = 0;
            }
            used[i] = false;
            res[pos] = 0;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        Arrays.fill(res, 0);
        Arrays.fill(used, false);

        findLargestArray(res, used, 0, n);
        return res;
    }
}