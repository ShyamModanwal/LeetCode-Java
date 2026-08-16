class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : frequency) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {

            List<Integer> remainingTasks = new ArrayList<>();

            for (int i = 0; i <= n; i++) {

                if (!maxHeap.isEmpty()) {

                    int freq = maxHeap.poll();

                    freq--;

                    if (freq > 0) {
                        remainingTasks.add(freq);
                    }

                    time++;
                }
                else {
                    if (remainingTasks.isEmpty()) {
                        break;
                    }

                    time++;
                }
            }

            for (int freq : remainingTasks) {
                maxHeap.offer(freq);
            }
        }

        return time;
    }
}