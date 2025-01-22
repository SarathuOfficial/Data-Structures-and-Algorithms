class Solution {
    public int[][] highestPeak(int[][] isWater) {
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] high = new int[isWater.length][isWater[0].length];

        for(int i = 0;i < isWater.length;i++){
            for(int j = 0;j < isWater[0].length;j++){
                if(isWater[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int[] arr = queue.poll();
                for(int k = 0;k < 4;k++){
                    int newx = arr[0] + dx[k];
                    int newy = arr[1] + dy[k];
                    if(isValid(newx,newy,isWater.length,isWater[0].length) && !visited[newx][newy]){
                        queue.add(new int[]{newx,newy});
                        visited[newx][newy] = true;
                        high[newx][newy] = level + 1;
                    }
                }
            }
            level++;
        }

        return high;
    }

    public boolean isValid(int x,int y,int m,int n){
        return x < m && y < n && x >= 0 && y >= 0;
    }
}