/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer buf = new StringBuffer();
        int carry = 0;
        int i, j;
        for(i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >=0; i--,j--){
            int sum = num1.charAt(i) - '0' + num2.charAt(j) -'0' + carry;
            if (sum > 9) carry = 1;
            else carry = 0;
            buf.append(sum % 10);
        }
        if (i >= 0)
            while(i >= 0) {
                int num = num1.charAt(i) - '0' + carry;
                if (num > 9) carry = 1;
                else carry = 0;
                buf.append(num % 10);
                i--;
            }
        else if (j >= 0) {
            while(j >= 0) {
                int num = num2.charAt(j) - '0' + carry;
                if (num > 9) carry = 1;
                else carry = 0;
                buf.append(num % 10);
                j--;
            }
        }
        if (carry == 1)
            buf.append(carry);

        return buf.reverse().toString();
    }
}
