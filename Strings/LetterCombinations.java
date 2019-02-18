/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        if(digits.length() == 0) return result;
        
        result.add("");
        for(int i=0; i<digits.length(); i++){
            result = makePermuts(map.get(digits.charAt(i)-'0'), result);
        }
        
        return result;
    }
    public List<String> makePermuts(String buttons, List<String> list){
        System.out.println(buttons+" "+list);
        List<String> result = new ArrayList<String>();
        for(int i=0; i<buttons.length(); i++){
            for(String x:list){
                result.add(x + buttons.charAt(i));
            }
        }
        return result;
    }
}