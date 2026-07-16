 class Solution {
    public boolean isPalindrome(String s) {
        int Start = 0;
        int last = s.length() - 1;

        while (Start <= last )
        {
            char curr_ch = s.charAt(Start);
            char last_ch = s.charAt(last);

            if (!Character.isLetterOrDigit(curr_ch))
            {
                Start++;
            } 
            else if (!Character.isLetterOrDigit(last_ch))
            {
                last--;
            }
            else {
                if (Character.toLowerCase(curr_ch) != Character.toLowerCase(last_ch))
                {
                    return false;
                }
                Start++;
                last--;
            }
        }
        return true;
        
    }
}