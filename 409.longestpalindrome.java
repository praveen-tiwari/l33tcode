/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        int[] table = new int[52];
        for(char c : s.toCharArray()){
            if(c>='a' && c <= 'z')
                table[c-'a']++;
            else
                table[c- 'A' + 26]++;
        }
        int countDup = 0;
        int countSingle = 0;
        for (int i : table) {
            if (i > 0) {
                if (i % 2 == 0)
                    countDup +=i;
                else {
                    countDup += i -1;
                    countSingle++;
                }
            }
        }
        return (countSingle > 0 ? countDup + 1 : countDup);
    }
}
