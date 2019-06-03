/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:

Input: [1,2,2,3,1,4,2]
Output: 6

Note:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/

class Solution {
    class Attrib {
        int count, start, end;
        Attrib(int c,int s,int e) {
            count = c;
            start = s;
            end = e;
        }
    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Attrib> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Attrib attrib = map.get(nums[i]);
            if (attrib == null)
                map.put(nums[i], new Attrib(1,i,i));
            else {
                attrib.count++;
                attrib.end = i;
                map.put(nums[i], attrib);
            }
        }
        Attrib max = null;
        for(Map.Entry<Integer,Attrib> entry: map.entrySet()) {
            Attrib curr = entry.getValue();
            if(max== null || max.count < curr.count) {
                max = curr;
                continue;
            }
            if(max.count > 1 && max.count == curr.count && (max.end-max.start > curr.end-curr.start))
               max = curr;
        }
        return max.end - max.start + 1;
    }
}
