public class SortStackUsingStack {
    public static void main(String[] args) {
        StackInt myStack = new StackInt(10);

        // إضافة عناصر غير مرتبة
        myStack.push(34);
        myStack.push(3);
        myStack.push(31);
        myStack.push(98);
        myStack.push(92);
        myStack.push(23);

        System.out.print("Original Stack: ");
        myStack.printStack();

        StackInt sorted = sortStack(myStack);

        System.out.print("Sorted Stack: ");
        sorted.printStack();
    }

    // دالة ترتيب Stack باستخدام Stack آخر
    static StackInt sortStack(StackInt inputStack) {
        StackInt helperStack = new StackInt(inputStack.capacity);

        while(!inputStack.isEmpty()) {
            int tempVal = inputStack.pop();

            // ضع العناصر الأكبر مؤقتاً مرة أخرى في inputStack
            while(!helperStack.isEmpty() && helperStack.peek() > tempVal) {
                inputStack.push(helperStack.pop());
            }

            helperStack.push(tempVal);
        }

        return helperStack;
    }
}

// تعريف Stack باستخدام مصفوفة
class StackInt {
    int[] items;
    int topIndex;
    int capacity;

    StackInt(int size) {
        capacity = size;
        items = new int[size];
        topIndex = -1;
    }

    void push(int value) {
        if(topIndex == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        items[++topIndex] = value;
    }

    int pop() {
        if(topIndex == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return items[topIndex--];
    }

    int peek() {
        if(topIndex == -1) return -1;
        return items[topIndex];
    }

    boolean isEmpty() {
        return topIndex == -1;
    }

    void printStack() {
        for(int i = 0; i <= topIndex; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
