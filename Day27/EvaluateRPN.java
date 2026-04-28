/*
Problem: Evaluate Reverse Polish Notation
Platform: LeetCode
Topic: Stack / Math

Approach:
Use a Stack. Iterate through the tokens.
If the token is a number, parse it and push it onto the stack.
If the token is an operator (+, -, *, /), pop the top two numbers from the stack, 
evaluate them using the operator (second popped operator first popped), and 
push the result back onto the stack.
The final result will be the only item remaining in the stack.

Time Complexity: O(N) where N is the number of tokens.
Space Complexity: O(N) for the stack.
*/

import java.util.Stack;

class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
