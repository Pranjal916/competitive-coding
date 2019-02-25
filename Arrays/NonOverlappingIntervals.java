/*Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.*/

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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;
        int size = intervals.length;
        int[] endArr = new int[size];
        Arrays.sort(intervals, new comparison());
        int count=1;
        int end = intervals[0].end;
        for(int i=1; i<size; i++){
            if(intervals[i].start >= end){
                count++;
                end = intervals[i].end;
            }
        }
        return size-count;
    }
}
class comparison implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.end - b.end;
    }
}

/*
Runtime: 4 ms, faster than 84.47% of Java online submissions.
Memory Usage: 38.9 MB, less than 28.33% of Java online submissions.
*/