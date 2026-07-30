class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, 0 , target, new ArrayList() , result);
        return result;
                
    }

    private void backTrack(int[] cond, int start, int target, List<Integer> list, List<List<Integer>> result){
        
        if (target < 0)
        return;
        if (target == 0)
        result.add(new ArrayList(list));

        for (int i = start; i < cond.length; i++)
        {
            list.add(cond[i]);
            backTrack(cond , i , target - cond[i], list, result );
            list.remove(list.size() - 1);
        }
    }
}