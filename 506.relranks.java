/**
 *  Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.

Note:

    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.
*/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> sorted = new TreeMap<>((Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < nums.length ; i++)
            sorted.put(nums[i], i);
        String[] res = new String[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            if (i == 0)
                res[entry.getValue()] = "Gold Medal";
            else if (i == 1)
                res[entry.getValue()] = "Silver Medal";
            else if (i == 2)
                res[entry.getValue()] = "Bronze Medal";
            else
                res[entry.getValue()] = new StringBuilder().append(i+1).toString();
            i++;
        }

        return res;
    }
}
