/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/
class Solution {
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        String res = "";
        boolean beg = true;
        for(String sp : splits) {
            if(beg)
                beg = false;
            else
                res +=" ";
            res += reverse(sp);
        }
        return res;
    }
    public String reverse(String sp) {
        String rev = "";
        for(int i= sp.length() - 1; i >= 0; i--) {
            rev = rev+ sp.charAt(i);
        }
        return rev;
    }
}
