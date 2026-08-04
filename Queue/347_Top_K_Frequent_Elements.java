class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer , Integer> map = new HashMap<>();
        
        for (int num : nums)
        {
            map.put(num , map.getOrDefault(num , 0) + 1);

        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (int num : map.keySet())
        {
            if (heap.size() < k)
            {
                heap.add(num);
            }
            else if (map.get(num) > map.get(heap.peek())){
                heap.poll();
                heap.add(num);
            }
        }

        int[] ans = new int[k];

        for (int i = k -1; i >= 0; i--)
        {
            ans[i] = heap.poll();
        }
        return ans;

        
    }
}