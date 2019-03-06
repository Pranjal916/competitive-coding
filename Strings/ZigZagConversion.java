/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int currentRow = 0, direction = 0;
        String[] rows = new String[numRows];
        for(int i=0; i<numRows; i++){
            rows[i] = "";
        }
        for(char c: s.toCharArray()){
            rows[currentRow] += c;
            if(direction==0)
                currentRow++;
            else
                currentRow--;
            if(currentRow == numRows-1){
                direction = 1;
            }
            else if(currentRow == 0){
                direction = 0;
            }
        }
        String result="";
        for(int i = 0; i<numRows; i++){
            result += rows[i];
        }
        return result;
    }
}