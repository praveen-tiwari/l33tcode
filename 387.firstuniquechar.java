/**
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
*/
class Solution {
    class Pair {
        int count, idx;
        Pair(int c, int i){
            count = c; idx = i;
        }
    }
    public int firstUniqChar(String s) {
        Map<Character, Pair> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            Pair val = map.get(c);
            if(val == null)
                map.put(c, new Pair(1,i));
            else {
                val.count++;
                map.put(c, val);
            }
        }
        Pair min = null;
        for(Pair pair : map.values()) {
            if(min == null || (min.count > pair.count) || (pair.count == 1 && min.idx > pair.idx)) {
                min = pair;
            }
        }
        return (min != null && min.count == 1) ? min.idx: -1;
    }
}
