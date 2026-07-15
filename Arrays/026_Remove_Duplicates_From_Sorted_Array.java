 /*
Problem: 26. Remove Duplicates from Sorted Array

Difficulty: Easy

Language: Java

Time Complexity: O(n)

Space Complexity: O(1)

Date Solved: July 2026

*/


 class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;

        for (int i =0 ; i < n ; i++){
            if (nums[i] != nums[k])
            {
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;

        
    }
}