class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int start[] = { 0 , 0 , 0}; 
        min.add(start);

        int dx[] ={0,0,1,-1};
        int dy[] ={1,-1,0,0};
        while(!min.isEmpty()){
            int[] small = min.poll();
            int cost = small[0];
            int x = small[1];
            int y = small[2];
            
            if(visited[x][y] == true){
                continue;
            }
            if(x == m - 1 && y == n - 1){
                return cost;
            }
            visited[x][y] = true;

            for(int i = 0;i < 4;i++){
                int newx = x + dx[i];
                int newy = y + dy[i];

                if(isValid(newx, newy, m, n) && !visited[newx][newy]){
                    int newcost = cost;
                    if( i + 1 != grid[x][y]){
                        newcost += 1;
                    }
                    min.add(new int[]{newcost,newx,newy});
                }
            }

        }

        return 0;
    }

    public boolean isValid(int x,int y,int m,int n){
        return x < m && y < n && x >= 0 && y >= 0;
    }
}