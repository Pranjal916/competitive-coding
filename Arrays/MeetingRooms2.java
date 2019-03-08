/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] startArr = new int[intervals.length];
        int[] endArr =  new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            startArr[i] = intervals[i].start;
            endArr[i] = intervals[i].end;
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int rooms=0, startP=0, endP=0;
        while(startP<startArr.length){
            if(startArr[startP] < endArr[endP]){
                rooms++;
            }
            else{
                endP++;
            }
            startP++;
        }
        return rooms;
    }
}