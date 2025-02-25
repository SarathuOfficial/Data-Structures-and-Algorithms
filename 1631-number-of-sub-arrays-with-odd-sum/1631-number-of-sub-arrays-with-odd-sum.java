class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0;
        int evenCount = 1; 
        int total = 0;
        int prefixSum = 0;

        for (int ele : arr) {
            prefixSum += ele;
            if ((prefixSum & 1) == 1) { 
                total = (total + evenCount) % MOD;
                oddCount++;
            } else { 
                total = (total + oddCount) % MOD;
                evenCount++;
            }
        }
        return total;
    }
}