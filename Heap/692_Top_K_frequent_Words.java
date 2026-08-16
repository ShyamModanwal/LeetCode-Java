 import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Define a Min-Heap of capacity k
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (w1, w2) -> {
                int freq1 = countMap.get(w1);
                int freq2 = countMap.get(w2);a
                if (freq1 != freq2) {
                    return freq1 - freq2; // Lower frequency comes first
                }
                return w2.compareTo(w1);  // Lexicographically larger word comes first
            }
        );

        // Step 3: Keep only the top k frequent words in the heap
        for (String word : countMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract elements and reverse to get highest frequency first
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }
}