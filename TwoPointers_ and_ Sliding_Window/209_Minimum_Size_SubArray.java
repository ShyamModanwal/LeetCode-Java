 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        
        int min_length = Integer.MAX_VALUE; 
        int curr_sum = 0;

        
        while (high < nums.length)
        {
            curr_sum += nums[high];
            high++;

            while (curr_sum >= target)
            {
                int curr_length = high - low ;

                min_length = Math.min(curr_length , min_length);

                curr_sum -= nums[low];
                low++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
        
    }
}