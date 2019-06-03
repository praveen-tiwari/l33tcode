/**
 * We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

Note:

    A and B will have length at most 100.


    */

// Solution 1
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.isEmpty()) return true;
        int idx = B.indexOf(A.charAt(0));
        if (idx == -1) return false;
        boolean found;
        while(idx != -1) {
            int len = A.length();
            found = true;
            for(int i=0; i< len; i++) {
                if(A.charAt(i) != B.charAt((i+idx)%len)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return true;
            idx = B.indexOf(A.charAt(0), idx+1);
        }
        return false;
    }
}

// Solution 2
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        String C = A+A;
        return C.contains(B);
    }
}
