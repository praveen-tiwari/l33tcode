/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note: The length of the input array will not exceed 20,000.
*/

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int j = i + 1;
            while(j < nums.length && nums[j] - nums[i] == 1)
                j++;
            max = Math.max(max, j-i);
        }
        return max;
    }
}
