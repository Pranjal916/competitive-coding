/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
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
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        int[] startArr = new int[size];
        int[] endArr = new int[size];
        for(int i = 0; i<size; i++){
            startArr[i] = intervals.get(i).start;
            endArr[i] = intervals.get(i).end;
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int start = 0, end = 0;
        List<Interval> result = new ArrayList<Interval>();
        while(end < size){
            if(end == size-1 || startArr[end+1] > endArr[end]){
                result.add(new Interval(startArr[start], endArr[end]));
                start = end+1;
            }
            end++;
        }
        return result;
    }
}

/*
Runtime: 7 ms, faster than 100.00% of Java online submissions.
Memory Usage: 39 MB, less than 98.95% of Java online submissions.
*/