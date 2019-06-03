/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0, maxsum = nums[0];
        vector<int>::iterator beg = nums.begin(), end = nums.begin();
        for(auto it=nums.begin(); it != nums.end(); it++){
            if (sum < 0)
                sum = *it;
            else
                sum += *it;
            if (maxsum < sum) {
                maxsum = sum;
                end++;
            } else {
                beg = ++end;
            }
        }
        return maxsum;
    }
};
