package chapter05;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack  = new Stack<Integer>();
    private Stack<Integer> minStack  = new Stack<Integer>();

    public void push(int element) {
        mainStack.push(element);
        if(minStack.isEmpty() ||  element<=minStack.peek()){
            minStack.push(element);
        }
    }


    public Integer pop() {
        if(minStack.peek()==mainStack.peek()){
            minStack.pop();
        }
        return mainStack.pop();
    }


    public int getMin() throws Exception {
            if(mainStack.isEmpty()){
                throw new Exception("stack is empty");
            }
            return  minStack.pop();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);

        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
