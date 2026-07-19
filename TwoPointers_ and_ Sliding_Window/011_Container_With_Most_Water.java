 class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int MaxCap = 0;

        while (start < end){
            int H = Math.min(height[start],height[end]);
            int width = end - start;
            int currCap = H * width;

             MaxCap = Math.max(currCap , MaxCap);

             if (height[start] < height[end]){
                start++;
             }
             else{
                end--;
             }
        }
        return MaxCap;

        
    }
}