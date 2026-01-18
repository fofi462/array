public class ReverseQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);

        // إضافة عناصر للـ Queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.print("Original Queue: ");
        queue.printQueue();

        reverseQueue(queue);

        System.out.print("Reversed Queue: ");
        queue.printQueue();
    }

    // دالة لعكس ترتيب العناصر في الـ Queue باستخدام Stack
    static void reverseQueue(MyQueue q) {
        StackInt stack = new StackInt(q.capacity);

        // إخراج جميع العناصر من الـ Queue إلى Stack
        while(!q.isEmpty()) {
            stack.push(q.dequeue());
        }

        // إعادة العناصر من Stack إلى Queue
        while(!stack.isEmpty()) {
            q.enqueue(stack.pop());
        }
    }
}

// تعريف Queue باستخدام مصفوفة
class MyQueue {
    int[] arr;
    int front, rear, size, capacity;

    MyQueue(int cap) {
        capacity = cap;
        arr = new int[cap];
        front = 0;
        size = 0;
        rear = -1;
    }

    void enqueue(int value) {
        if(size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    int dequeue() {
        if(size == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void printQueue() {
        if(size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        for(int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// تعريف Stack لمساعدة الـ Queue
class StackInt2 {
    int[] arr;
    int topIndex;
    int capacity;

    StackInt2(int size) {
        capacity = size;
        arr = new int[size];
        topIndex = -1;
    }

    void push(int value) {
        if(topIndex == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++topIndex] = value;
    }

    int pop() {
        if(topIndex == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[topIndex--];
    }

    boolean isEmpty() {
        return topIndex == -1;
    }
}
