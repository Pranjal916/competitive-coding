/*Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
*/

class Solution {
    public double myPow(double x, int n) {
        long absN = Math.abs((long)n);
        double ans = 1;
        if(n == 0)
            return 1;
        
        while(absN > 0){
            if((absN&1) == 1){
                ans = ans*x;
            }
            absN>>=1;
            x=x*x;
        }
        return n<0? 1/ans : ans;
    }
}