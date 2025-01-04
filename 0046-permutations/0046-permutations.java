class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res,temp,nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int num : nums){
            if(temp.contains(num)){
                continue;
            }
            temp.add(num);
            backtrack(res,temp,nums);
            temp.remove(temp.size() - 1);
        }
    }
}