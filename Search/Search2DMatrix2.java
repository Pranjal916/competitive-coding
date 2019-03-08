/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;
        int colp = matrix[0].length-1;
        int rowp = 0;
        while(rowp<matrix.length && colp >= 0){
            int current = matrix[rowp][colp];
            //System.out.println(current);
            if(current == target)
                return true;
            else if(current > target)
                colp--;
            else if(current < target)
                rowp++;
        }
        return false;
    }
}