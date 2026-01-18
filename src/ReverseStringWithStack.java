public class ReverseStringWithStack {
    public static void main(String[] args) {
        String str = "HelloWorld";

        String reversed = reverseString(str);

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }

    // دالة لعكس السلسلة باستخدام Stack
    static String reverseString(String str) {
        int n = str.length();
        Stack stack = new Stack(n);

        for(int i = 0; i < n; i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";
        while(!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return reversed;
    }
}

// تعريف Stack باستخدام مصفوفة
class Stack {
    char[] arr;
    int top;
    int capacity;

    Stack(int size) {
        capacity = size;
        arr = new char[size];
        top = -1;
    }

    void push(char c) {
        if(top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = c;
    }

    char pop() {
        if(top == -1) {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
