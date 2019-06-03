/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"

Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"



Note:

    S.length <= 100
    33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "

*/
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int[] index = new int[128];
        for(int x=0;x<128;x++) {
            if((x>=65 && x<=90) || (x>=97 && x<=122))
                index[x] = 1;
        }
        int i=0, j=cs.length -1;
        while(i<j) {
            while (i<cs.length && index[cs[i]] != 1) i++;
            while (j>0 && index[cs[j]] != 1) j--;
            if (i<j) {
                char c = cs[i];
                cs[i] = cs[j];
                cs[j] = c;
                i++;
                j--;
            }
        }
        return new String(cs);
    }
}
