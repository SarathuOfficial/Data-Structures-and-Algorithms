class Solution {
    private static final long MOD = 1000000007;

    private void calculateScore(List<Integer> nums, long[] score) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int ele = nums.get(i);
            long count = 0;
            for (int j = 2; j * j <= ele; j++) {
                if (ele % j == 0) count++;
                while (ele % j == 0) ele /= j;
            }
            if (ele > 1) count++;
            score[i] = count;
        }
    }

    private void calculateSubarrayCountPerScore(long[] score, long[] subarrayCount) {
        int n = score.length;
        long[] pge = new long[n]; // Previous Greater or Equal
        Arrays.fill(pge, -1);
        Stack<Integer> stack = new Stack<>();

        // Compute Previous Greater or Equal Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && score[stack.peek()] < score[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }

        // Compute Next Greater Element and count subarrays
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            long count = 0;
            while (!stack.isEmpty() && score[stack.peek()] <= score[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                count = (n - i) * (i - pge[i]);
            } else {
                count = (stack.peek() - i) * (i - pge[i]);
            }
            stack.push(i);
            subarrayCount[i] = count;
        }
    }

    private long binaryExponentiation(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        return res;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        long[] score = new long[n];
        calculateScore(nums, score);

        long[] subarrayCount = new long[n];
        calculateSubarrayCountPerScore(score, subarrayCount);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{nums.get(i), i});
        }

        long res = 1;
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int value = curr[0];
            int index = curr[1];
            long power = Math.min(k, subarrayCount[index]);
            res = (res * binaryExponentiation(value, power)) % MOD;
            k -= power;
        }
        return (int) res;
    }
}