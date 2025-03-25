class Solution {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private boolean countLineIntersections(List<Pair> coordinates) {
        int lines = 0, overlap = 0;
        for (Pair coord : coordinates) {
            if (coord.second == 1) overlap++;
            else overlap--;
            if (overlap == 0) lines++;
        }
        return lines >= 3;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<Pair> yCoordinates = new ArrayList<>();
        List<Pair> xCoordinates = new ArrayList<>();

        for (int[] rectangle : rectangles) {
            yCoordinates.add(new Pair(rectangle[1], 1)); // Start of vertical segment
            yCoordinates.add(new Pair(rectangle[3], 0)); // End of vertical segment
            xCoordinates.add(new Pair(rectangle[0], 1)); // Start of horizontal segment
            xCoordinates.add(new Pair(rectangle[2], 0)); // End of horizontal segment
        }

        // Sort first by coordinate value, then by type (ensuring starts come before ends)
        Comparator<Pair> comparator = (a, b) -> a.first == b.first ? Integer.compare(a.second, b.second) : Integer.compare(a.first, b.first);
        
        Collections.sort(yCoordinates, comparator);
        Collections.sort(xCoordinates, comparator);

        // Line-Sweep on x and y coordinates
        return countLineIntersections(yCoordinates) || countLineIntersections(xCoordinates);
    }
}