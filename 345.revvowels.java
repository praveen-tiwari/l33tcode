/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".

*/

class Solution {
public:
    string reverseVowels(string s) {
    if(s.empty())
        return "";

    string out(s.size(),' ');
    int i=0;
    int j=s.size()-1;
    while(i<=j){
        while (!(s[i] =='a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] =='u' ||
                s[i] =='A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] =='U') && s[i] !='\0') {
            out[i] = s[i];
            i++;
        }
        while (!(s[j] =='a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u' ||
                s[j] =='A' || s[j] == 'E' || s[j] == 'I' || s[j] == 'O' || s[j] =='U') && j >=0) {
            out[j] = s[j];
            j--;
        }

        if (s[i] == '\0' || j < 0)
            break;

        out[i]=s[j];
        out[j] = s[i];
        i++;
        j--;
    }
    return out;

    }
};
