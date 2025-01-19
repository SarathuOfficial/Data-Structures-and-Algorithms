class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int m = heightMap.length;
        int n = heightMap[0].length;
        if(m < 2 || n < 2){
            return 0;
        }
        int level = 0;
        int filled = 0;
        boolean visited[][] = new boolean[m][n];
        int dx[] ={0,0,1,-1};
        int dy[] ={1,-1,0,0};

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    min.add(new int[]{heightMap[i][j],i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!min.isEmpty()){
            int current[] = min.poll();
            int height = current[0];
            int x = current[1];
            int y = current[2];
            level = Math.max(height,level);

            for(int i = 0;i < 4;i++){
                int newx = x + dx[i];
                int newy = y + dy[i];

                if(isValid(newx, newy, m, n) && !visited[newx][newy]){
                    visited[newx][newy] = true;
                    min.add(new int[]{heightMap[newx][newy],newx,newy});
                    if(heightMap[newx][newy] < level){
                        filled += level - heightMap[newx][newy];
                    }
                }
            }
        }
        return filled;
    }

    public boolean isValid(int x,int y,int m,int n){
        return x < m && y < n && x >= 0 && y >= 0;
    }
}