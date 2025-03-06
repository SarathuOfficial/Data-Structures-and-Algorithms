class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeating = 0, missing = 0;
        int n = grid.length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int curr = Math.abs(grid[i][j]);
                int row = (curr - 1) / n;
                int col = (curr - 1) % n;
                
                if (grid[row][col] < 0) {
                    repeating = Math.abs(curr);
                } else {
                    grid[row][col] *= -1;
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    missing = i * n + (j + 1);
                    break;
                }
            }
        }
        
        return new int[]{repeating, missing}; 
    }
}