package atguigu.dataStructures.java1;

import java.util.Scanner;

public class MidExpToLaterExp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.next().toCharArray();

        Stack stack = new Stack(10);

        for (int i = 0; i < input.length; i++) {
            int inputPriority = getPriority(input[i]);

            if (inputPriority == 0) {
                System.out.print(input[i]);

                continue;

            }

            while (true) {
                if (stack.isEmpty()) {
                    stack.push(input[i]);

                    break;

                }

                char output = stack.peek();

                int outputPriority = getPriority(output);

                if (outputPriority < inputPriority) {
                    stack.push(input[i]);

                    break;

                } else {
                    if (output != '(') {
                        stack.pop();

                        System.out.print(output);

                        continue;

                    } else {
                        if (input[i] != ')') {
                            stack.push(input[i]);

                            break;

                        } else {
                            stack.pop();

                            break;

                        }

                    }

                }

            }

        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());

        }

    }

    public static int getPriority(char ch) {
        int priority = 0;

        switch (ch) {
            case '(':
                priority = 4;
                break;

            case '*':

            case '/':
                priority = 3;
                break;

            case '+':

            case '-':
                priority = 2;
                break;

            case ')':
                priority = 1;
                break;

        }

        return priority;

    }

}

class Stack {
    private char[] array;

    private int top;

    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;

        array = new char[maxSize];

        top = 0;

    }

    public void push(char ch) {
        array[top++] = ch;

    }

    public char pop() {
        return array[--top];

    }

    public char peek() {
        return array[top - 1];

    }

    public boolean isEmpty() {
        return top == 0;

    }

    public boolean isFull() {
        return top == maxSize;

    }

}
