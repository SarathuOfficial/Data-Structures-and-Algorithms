class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1){
            return 0;
        }

        int split[] = new int[weights.length - 1];
        for(int i = 0;i < weights.length - 1;i++){
            split[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(split);

        long min = sum(split, k, true);
        long max = sum(split, k, false); 
        return max - min;
    }
    public long sum(int[] split, int k, boolean isMin) {
        long total = 0;
        int n = split.length;
        if (isMin) {
            for (int i = 0; i < k - 1; i++) {
                total += split[i];
            }
        } else {
            for (int i = n - (k - 1); i < n; i++) {
                total += split[i];
            }
        }
        return total;
    }
}