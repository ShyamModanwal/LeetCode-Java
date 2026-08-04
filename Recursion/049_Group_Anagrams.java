 import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Key = Frequency String
        // Value = List of Anagrams
        Map<String, List<String>> frequencyStringMap = new HashMap<>();

        for (String str : strs) {

            // Generate frequency string for current word
            String frequencyString = getFrequencyString(str);

            if (frequencyStringMap.containsKey(frequencyString)) {
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringMap.values());
    }

    // Generates a unique frequency string
    private String getFrequencyString(String str) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Build a unique string from frequencies
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(freq[i]);
        }

        return sb.toString();
    }
}