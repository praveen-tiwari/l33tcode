/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

Note: You may assume that n is not less than 2 and not larger than 58.
*/

class Solution {
public:
    int integerBreak(int n) {
    int prod = 1;
    if (n == 2)
        return 1;
    if (n == 3)
        return 2;
    while(n >= 2){
        if(n%3 == 0){
            prod *=3;
            n -= 3;
        } else {
            prod *= 2;
            n -= 2;
        }
    }
    return prod;
    }
};
