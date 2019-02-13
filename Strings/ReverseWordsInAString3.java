/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        for(int i = 0; i <= str.length - 1; i++){
            if(str[i] == ' '){  //meet a word, reverse ops
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, start, str.length - 1);   //reverse the last word
        return new String(str);
    }
    private void reverse(char[] str, int left, int right){
        while(left < right){
            char c = str[left];
            str[left] = str[right];
            str[right] = c;
            left++; 
            right--;
        }
    }
}