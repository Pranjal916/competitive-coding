/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<String>();
        if(nums.length == 1){
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int startIndex=0, currentIndex=0;
        while(currentIndex < nums.length){
            if(currentIndex+1 < nums.length && nums[currentIndex+1] == nums[currentIndex]+1){
                currentIndex++;
            }
            else{
                if(startIndex == currentIndex){
                    result.add(Integer.toString(nums[currentIndex]));
                }
                else{
                    result.add(nums[startIndex] +"->"+ nums[currentIndex]);
                }
                startIndex = ++currentIndex;
            }
        }
        return result;
    }
}