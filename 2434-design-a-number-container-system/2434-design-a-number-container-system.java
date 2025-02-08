class NumberContainers {
private Map<Integer, Integer> indexNumber;
    private Map<Integer, TreeSet<Integer>> numberIndices; 

    public NumberContainers() {
        indexNumber = new HashMap<>();
        numberIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexNumber.containsKey(index)) {
            int oldNumber = indexNumber.get(index);
            numberIndices.get(oldNumber).remove(index);
            if (numberIndices.get(oldNumber).isEmpty()) {
                numberIndices.remove(oldNumber); 
            }
        }

        indexNumber.put(index, number);
        numberIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numberIndices.containsKey(number)) {
            return -1; 
        }
        return numberIndices.get(number).first(); 
    }
}