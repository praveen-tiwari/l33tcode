/**
 *
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sub = new String();
        int length = 0;
        int max = 0;

        for (int i=0; i < s.length(); i++) {
            int j = sub.indexOf(s.charAt(i));
            if (j != -1) {
                sub = sub.substring(j+1);
                length = length - j - 1;
            }
            sub += s.charAt(i);
            length++;
            if (max < length) {
                max = length;
            }
        }
        return max;
    }
}
