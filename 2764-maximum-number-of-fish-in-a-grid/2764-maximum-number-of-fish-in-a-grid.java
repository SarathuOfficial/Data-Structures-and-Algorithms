class Solution {
    public int findMaxFish(int[][] grid) {
        int fish = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    visited[i][j] = true;
                    fish = Math.max(fish,check(i,j,grid,visited));
                }
            }
        }
        return fish;
    }

    public int check(int x,int y,int[][] grid,boolean visited[][]){
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        int val = grid[x][y];
        for(int i = 0;i < 4;i++){
            int newx = x + dx[i];
            int newy = y + dy[i];
            if(isValid(newx,newy,grid.length,grid[0].length) && !visited[newx][newy] && grid[newx][newy] != 0){
                visited[newx][newy] = true;
                val += check(newx,newy,grid,visited);
            }
        }
        return val;
    }

    public boolean isValid(int x,int y,int m,int n){
        return x >= 0 && y >=0 && x < m && y < n;
    }
}