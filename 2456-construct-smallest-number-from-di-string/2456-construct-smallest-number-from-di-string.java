class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        HashMap<Integer, Boolean> visited = new HashMap<>(); 

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= n; i++) {
            stack.push(i + 1);  
            
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    int num = stack.pop();
                    if (!visited.containsKey(num)) {
                        result.append(num);
                        visited.put(num, true);  
                    }
                }
            }
        }
        
        return result.toString();
    }
}