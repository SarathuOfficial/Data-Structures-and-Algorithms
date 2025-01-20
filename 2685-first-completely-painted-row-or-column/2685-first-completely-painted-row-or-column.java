class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
                map.put(mat[i][j],new int[] {i , j});
            }
        }
        int m[] = new int[mat.length];
        int n[] = new int[mat[0].length];

        for(int i = 0;i < arr.length;i++){
            int get[] = map.get(arr[i]);
            m[get[0]]++;
            n[get[1]]++;
            if(m[get[0]] == mat[0].length){ // Note: 'm' should be compared with 'mat[0].length' (the total number of columns), not with 'mat.length' (the total number of rows in the matrix)
                return i;
            }
            if(n[get[1]] == mat.length){
                return i;
            }
        }

        return 0;
    }
}