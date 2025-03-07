class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> prime = new ArrayList<>();
        // if(left == 1){
        //     prime.add(1);
        // }
        for(int i = left;i <= right;i++){
            if(isPrime(i)){
                prime.add(i);
            }
        }
        int res[] = {-1,-1};
        int range = Integer.MAX_VALUE;
        for(int i = 0;i < prime.size() - 1;i++){
            int updated = range;
            range = Math.min(range,prime.get(i + 1) - prime.get(i));
            if(range != updated){
                res[0] = prime.get(i);
                res[1] = prime.get(i+1);
            }
        }
        return res;
    }

    public boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2;i * i <= num;i++){
            if(num%i== 0){
                return false;
            }
        }
        return true;
    }
}