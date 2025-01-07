class Solution {
    public int[] minOperations(String boxes) {
        ArrayList<Character> box = new ArrayList<>();
        for (char c : boxes.toCharArray()) {
            box.add(c);
        }
        int n = boxes.length();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (box.get(j) == '1') {
                    count[i] += Math.abs(j - i); 
                }
            }
        }
        return count;
    }
}