/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    class Node{
        int data;
        int min;
        Node next;
        
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    Node top;
    
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int x) {
        if(top == null){
            top = new Node(x);
            top.min = x;
            return;
        }
        Node temp =  top;
        top = new Node(x);
        top.next = temp;
        if(top.data < temp.min){
            top.min = x;
        }
        else{
            top.min = temp.min;
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}