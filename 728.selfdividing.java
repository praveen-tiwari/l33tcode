/**
 *  A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:

Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.
*/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        while(left <= right) {
            if (left < 10) {
                list.add(left++);
                continue;
            }
            if (left % 10 == 0) {
                left++;
                continue;
            }
            int n = left;
            boolean isDivisible = true;
            while (n > 1) {
                if (n%10 == 0 || (left % (n % 10)) != 0) {
                    isDivisible = false;
                    break;
                }
                n /= 10;
            }
            if (isDivisible)
                list.add(left);
            left++;
        }
        return list;
    }
}
