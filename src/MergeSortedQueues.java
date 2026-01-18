public class MergeSortedQueues {
    public static void main(String[] args) {
        MyQueue2 q1 = new MyQueue2(10);
        MyQueue2 q2 = new MyQueue2(10);

        // Queue 1 (مرتبة)
        q1.enqueue(10);
        q1.enqueue(30);
        q1.enqueue(50);

        // Queue 2 (مرتبة)
        q2.enqueue(20);
        q2.enqueue(40);
        q2.enqueue(60);

        MyQueue2 merged = mergeQueues(q1, q2);

        System.out.print("Merged Sorted Queue: ");
        merged.printQueue();
    }

    // دالة الدمج
    static MyQueue2 mergeQueues(MyQueue2 q1, MyQueue2 q2) {
        MyQueue2 merged = new MyQueue2(q1.capacity + q2.capacity);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(q1.peek() <= q2.peek()) {
                merged.enqueue(q1.dequeue());
            } else {
                merged.enqueue(q2.dequeue());
            }
        }

        // إضافة أي عناصر متبقية
        while(!q1.isEmpty()) {
            merged.enqueue(q1.dequeue());
        }

        while(!q2.isEmpty()) {
            merged.enqueue(q2.dequeue());
        }

        return merged;
    }
}

// تعريف Queue باستخدام مصفوفة
class MyQueue2 {
    int[] arr;
    int front, rear, size, capacity;

    MyQueue2(int cap) {
        capacity = cap;
        arr = new int[cap];
        front = 0;
        rear = -1;
        size = 0;
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

    int peek() {
        if(size == 0) return Integer.MAX_VALUE; // لتسهيل المقارنة
        return arr[front];
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
