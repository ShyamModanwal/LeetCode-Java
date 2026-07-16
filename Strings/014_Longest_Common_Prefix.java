 class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();

        char[] start = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < Math.min(start.length , last.length) ; i++)
        {

        if (start[i] != last[i])
        {
            break;
        }
        result.append(start[i]);
        
        }
        return result.toString();
    }

}