class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] greaterElement = new int[nums2.length];
        Stack<Integer> helperStack = new Stack<>();

        // Step 1: Find Next Greater for every element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            int element = nums2[i];

            while (!helperStack.isEmpty() && helperStack.peek() <= element) {
                helperStack.pop();
            }

            if (helperStack.isEmpty()) {
                greaterElement[i] = -1;
            } else {
                greaterElement[i] = helperStack.peek();
            }

            helperStack.push(element);
        }

        // Step 2: Store element -> nextGreater in HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greaterElement[i]);
        }

        // Step 3: Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}