/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

*/

class Solution {
public:
    bool isValid(string s) {
        std::stack<char> st;
        for(auto it = s.begin(); it != s.end(); it++) {
            switch(*it) {
                case '(':
                case '{':
                case '[':
                    st.push(*it);
                    break;
                case ')':
                case '}':
                case ']':
                    if(st.empty())
                        return false;
                    {
                        char c = st.top();
                        if((c == '(' && *it == ')') ||
                            (c == '{' && *it == '}') ||
                            (c == '[' && *it == ']'))
                            st.pop();
                        else
                            return false;
                        break;
                    }
                default:
                    break;
            }
        }
        if(st.empty())
            return true;
        return false;
    }
};
