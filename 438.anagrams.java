/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pmap.put(p.charAt(i), map.getOrDefault(charAt(i), 0) + 1);
        }
        for(int i=0; i <= s.length() - p.length(); i++) {
            for (int j = i ; j < i + p.length(); j++) {
                if (count[s.charAt(j)]++;
            }
            if (j == p.length())
                res.add(i);
        }
        return res;
    }
}
