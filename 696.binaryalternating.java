/**
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:

Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101

Example 2:

Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.

Example 3:

Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.

Example 4:

Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
*/

class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n==0) return false;
        while(n!=0) {
            int b1 = n & 0x1;
            n /= 2;
            int b2 = n & 0x1;
            if(b1 == b2)
                return false;
        }
        return true;
    }
}
