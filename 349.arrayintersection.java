/**
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

    Each element in the result must be unique.
    The result can be in any order.

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> intersect = new HashSet<>();
        for (int i=0; i<nums2.length; i++) {
            if (binSearch(nums1, nums2[i]))
                intersect.add(nums2[i]);
        }
        int[] inter = new int[intersect.size()];
        int i = 0;
        for(int num: intersect) {
            inter[i++] = num;
        }
        return inter;
    }
    boolean binSearch(int nums[], int e) {
        int beg = 0;
        int end = nums.length -1;
        while(beg <= end) {
            int mid = beg + (end - beg)/2;
            if (nums[mid] == e)
                return true;
            if (nums[mid] < e)
                beg=mid+1;
            else end = mid -1;
        }
        return false;
    }
}
