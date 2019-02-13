/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
counting from the start of the string. If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int head = 0;
        while(head+k <= s.length()){
            reverseSub(arr, head, head+k);
            head += 2*k;
        }
        if(head < s.length())
            reverseSub(arr, head, s.length());
        return String.valueOf(arr);
    }
    public void reverseSub(char[] arr, int i, int j){
        int l = i;
        int r = j-1;
        while(l<r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}