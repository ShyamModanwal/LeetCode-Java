 class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        int[] result = new int[n];

        for (int p = n-1 ; p >= 0 ; p--)
        {
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
            {
                result[p] = nums[l] * nums[l];
                l++;
            }
            else {
                result[p] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
        
    }
}