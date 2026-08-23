class Solution {
    public boolean canJump(int[] nums) {

        int finalstate = nums.length - 1;

        for (int idx = nums.length - 2; idx >= 0 ; idx--)
        {
            if (idx + nums[idx] >= finalstate)
            {
                finalstate = idx;
            }
        }
        return finalstate == 0;
        
    }
}