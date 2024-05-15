package stacks.stack_using_arrayList;

import java.util.ArrayList;

public class Stack {
    ArrayList<String> stackArray;

    public Stack() {
        this.stackArray = new ArrayList<>();
    }

    public String peek() {
        if (this.stackArray.size() > 0) {
            return stackArray.get(stackArray.size() - 1);
        } else {
            return null;
        }
    }

    public void push(String value) {
        this.stackArray.add(value);
    }

    public void pop() {
        if(stackArray.size()>0)
        this.stackArray.remove(stackArray.size() - 1);

    }

    public boolean isEmpty() {
        return stackArray.size() == 0;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.pop();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println("peek  "+myStack.peek());
        System.out.println(myStack.isEmpty());
    }
}
