/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result, "", 0, 0, n);
        return result;
    }
    public void generate(List<String> result, String current, int open, int close, int size){
        if(current.length() == 2*size){
            result.add(current);
            return;
        }
        if(open < size){
            generate(result, current+"(", open+1, close, size);
        }
        if(close < open){
            generate(result, current+")", open, close+1, size);
        }
    }
}