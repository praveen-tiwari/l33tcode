/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.





Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
*/

class Solution {
    public String[] findWords(String[] words) {
        String[] row = {"qwertyuiop", "asdfghjkl","zxcvbnm"};
        List<String> samerow = new ArrayList<>();
        for(String word:words) {
            boolean found = true;
            for(int j=0; j<3; j++){
                found = true;
                for(int i=0; i<word.length(); i++) {
                    if(row[j].indexOf(word.toLowerCase().charAt(i)) == -1)
                        found = false;
                }
                if(found) {
                    samerow.add(word);
                    break;
                }
            }
        }
        return samerow.toArray(new String[0]);
    }
}
