/*
Problem: Two Sum
Difficulty: Easy
Language: Java

Time Complexity: O(n)
Space Complexity: O(n)
*/

class 001_Two_Sum {
    public  int[] twoSum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            int remainder = target - arr[i];
            if(map.containsKey(remainder)){
                return new int[] {map.get(remainder),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {};
    }
    public static void main(String args[]){
        int[] arr = {6,8,3,2,9};
        int target = 11;
        Solution sol = new Solution();
        int[] result = sol.twoSum(arr,target);
        System.out.println(result);
    }
    
}
