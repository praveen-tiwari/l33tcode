/**
 * Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/

class Queue {
    std::stack<int> S1, S2;
public:
    // Push element x to the back of queue.
    void push(int x) {
        S1.push(x);
    }

    // Removes the element from in front of queue.
    void pop(void) {
        if(S2.empty() && S1.empty())
            return;
        if(S2.empty()) {
            while(!S1.empty()) {
                S2.push(S1.top());
                S1.pop();
            }
        }
        S2.pop();
    }

    // Get the front element.
    int peek(void) {
        if(S2.empty() && S1.empty())
            return -1;
        if(S2.empty()) {
            while(!S1.empty()) {
                S2.push(S1.top());
                S1.pop();
            }
        }
        return S2.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return S2.empty() && S1.empty();
    }
};
