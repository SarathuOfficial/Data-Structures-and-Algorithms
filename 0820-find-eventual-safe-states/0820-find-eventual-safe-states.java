class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int visited[] = new int[graph.length]; 
        boolean safe[] = new boolean[graph.length];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) { 
                checksafe(i, visited, safe, graph);
            }
        }

        for (int i = 0; i < safe.length; i++) {
            if (safe[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public boolean checksafe(int node, int visited[], boolean safe[], int[][] graph) {
        if (visited[node] == 1) { 
            return false;
        }
        if (visited[node] == 2) { 
            return true;
        }

        visited[node] = 1; 

        for (int neigh : graph[node]) {
            if (!checksafe(neigh, visited, safe, graph)) {
                return safe[node] = false; 
            }
        }

        visited[node] = 2; 
        return safe[node] = true; 
    }
}