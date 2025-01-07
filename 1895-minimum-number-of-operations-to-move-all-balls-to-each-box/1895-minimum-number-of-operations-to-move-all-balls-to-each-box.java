class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (boxes.charAt(j) == '1') {
                    count[i] += Math.abs(j - i); 
                }
            }
        }
        return count;
    }
}