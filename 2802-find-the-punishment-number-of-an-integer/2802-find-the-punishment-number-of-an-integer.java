class Solution {
    private boolean isValid(String sq, int pos, int sum, int val) {
        if (pos >= sq.length()) {
            return sum == val;
        }
        
        for (int i = 0; i + pos < sq.length(); ++i) {
            int currVal = Integer.parseInt(sq.substring(pos, pos + i + 1));
            if (isValid(sq, pos + i + 1, sum + currVal, val)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNumber = 1;
        for (int i = 2; i <= n; ++i) {
            String sq = Integer.toString(i * i);
            if (isValid(sq, 0, 0, i)) {
                punishmentNumber += i * i;
            }
        }
        return punishmentNumber;
    }
}