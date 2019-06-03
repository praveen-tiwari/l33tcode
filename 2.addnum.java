/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = null;
        ListNode ptr = null;
        while(l1 != null && l2 != null) {
            int s = l1.val + l2.val + carry;
            ListNode n = new ListNode((s>9)?s-10:s);
            if (s > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            if(sum == null) {
                sum = ptr = n;
            } else {
                ptr.next = n;
                ptr = ptr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null) {
            ptr.next = l1;
            ptr = ptr.next;
        } else if (l2 != null) {
            ptr.next = l2;
            ptr = ptr.next;
        } else if (carry == 1) {
            ListNode last = new ListNode(1);
            ptr.next = last;
            carry = 0;
        }
        while (carry == 1 && ptr != null) {
          ptr.val += carry;
          if (ptr.val > 9) {
                ptr.val -= 10;
                carry = 1;
          } else {
                carry = 0;
          }
            if (carry == 1 && ptr.next == null) {
                ListNode last = new ListNode(1);
                ptr.next = last;
                carry = 0;
            }
            ptr = ptr.next;
        }

        return sum;
    }
}
