 class Solution {
    public boolean validString(String s){
        int count = 0;
        for (char ch : s.toCharArray()){
            if (ch == '(')
            count += 1;
            else
            count -= 1;

            if(count < 0)
            return false;
        }
        return count == 0;
    }
    public void generateParanthesishelper(String curr, int n , List<String> res){
        if (curr.length() == 2*n){
            if(validString(curr)){
                res.add(curr);
            }
            return;
        }
        generateParanthesishelper(curr + '(' , n , res);
        generateParanthesishelper(curr + ')' , n , res);
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParanthesishelper("", n , res);
        return res;
        
    }
}