class Solution {
    public int maximumSum(int[] nums) {
        int res = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int sum = sumofdigits(num);
            if (map.containsKey(sum)) {
                res = Math.max(res, num + map.get(sum));
                map.put(sum, Math.max(map.get(sum), num));
            } else {
                map.put(sum, num);
            }
        }
        return res;
    }

    public int sumofdigits(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}