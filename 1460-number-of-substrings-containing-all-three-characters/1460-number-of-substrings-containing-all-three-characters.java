class Solution {
    public int numberOfSubstrings(String s) {
         int n = s.length();
        int subarrays = 0;
        int[] freq = new int[3];
        int left = 0, right = 0;
        while (right < n) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) { // Valid window found
                subarrays += n - right; // All subarrays starting at left and ending at right or beyond are valid
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return subarrays;
    }
}