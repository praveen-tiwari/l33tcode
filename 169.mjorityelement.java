/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        /** Boyer-Moore
        Pre-condition - Every input array has one majority element
        1. Start with the any element as majority candidate and keep a count
        2. Every time we encounter a different number, decrement the count
        3. If the count has reached 0, choose the next number as majority candidate
        4. The idea is that we can never reset the count more times than the majority element.
        */
        for(int num:nums) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else count--;
        }
        return candidate;
    }
}
