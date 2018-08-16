package javaCode.datastructure;

public class ArrayStack {
    private int size;
    private int top;
    private char[] stackArray;

    public ArrayStack(int size) {
        stackArray = new char[size];
        top = -1;
        this.size = size;
    }

    public void push(char c) {
        stackArray[++top] = c;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public static void check(String input) {
        int len = input.length();
        ArrayStack stack = new ArrayStack(len);

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            else if (ch == '}' || ch == ']' || ch == ')') {
                if (!stack.isEmpty()) {
                    char tmp = stack.pop();
                    if ((ch == '}' && tmp != '{') ||
                            (ch == ']' && tmp != '[') ||
                            (ch == ')' && tmp != '('))
                        System.out.println("字符: " + ch + "匹配出错，下标为" + i);
                } else System.out.println("字符: " + ch + "匹配出错，下标为" + i);
            }
        }
        if (!stack.isEmpty())
            System.out.println("存在未关闭括号！");
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push('a');
        stack.pop();
        System.out.println(stack.isEmpty());
        String input = "{}{}}{";
        check(input);
    }
}
