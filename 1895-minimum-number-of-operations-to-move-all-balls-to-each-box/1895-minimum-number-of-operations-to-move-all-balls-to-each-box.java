class Solution {
    public int[] minOperations(String boxes) {
        int ans[] = new int[boxes.length()];
        int balls = 0 ;
        int moves = 0;

        for(int i = 0;i < boxes.length();i++){
            ans[i] = balls + moves;
            moves = ans[i];
            balls = balls + (boxes.charAt(i) - '0');
        }
        moves = 0;
        balls = 0;
        for(int i = boxes.length() - 1;i >= 0 ;i--){
            ans[i] += balls + moves;
            moves = balls + moves;
            balls = balls + (boxes.charAt(i) - '0');
        }

        return ans;
    }
}