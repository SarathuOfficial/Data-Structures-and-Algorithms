class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> colorFreq = new HashMap<>(); 
        Map<Integer, Integer> ballColor = new HashMap<>(); 
        int res[] = new int[n];

        for (int i = 0; i < n; ++i) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorFreq.put(prevColor, colorFreq.get(prevColor) - 1); 
                if (colorFreq.get(prevColor) == 0) {
                    colorFreq.remove(prevColor); 
                }
            }

            ballColor.put(ball, color);
            colorFreq.put(color, colorFreq.getOrDefault(color, 0) + 1);

            res[i] = colorFreq.size();
        }

        return res;
    }
}