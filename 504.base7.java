/**
 * Given an integer, return its base 7 string representation.

Example 1:

Input: 100
Output: "202"

Example 2:

Input: -7
Output: "-10"

Note: The input will be in range of [-1e7, 1e7].
*/

class Solution {
    public String convertToBase7(int num) {
        int res = 0;
        int sign = 1;
        if (num < 0) {
            sign = -1;
        }
        num = Math.abs(num);
        return new StringBuilder().append(convertToBase7Int(num)*sign).toString();
    }
    private int convertToBase7Int(int num) {
        if (num < 7)
            return num;
        return convertToBase7Int(num/7)*10 + num%7;
    }
}
