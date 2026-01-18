public class CircularLinkedListInsert {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);

        System.out.print("Original List: ");
        list.printList();

        int position = 1;
        int data = 15;
        list.insertAtPosition(data, position);

        System.out.print("After inserting " + data + " at position " + position + ": ");
        list.printList();
    }
}

// تعريف العقدة
class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

// تعريف القائمة الدائرية
class CircularLinkedList {
    Node3 head;

    // إضافة عنصر في نهاية القائمة
    void append(int data) {
        Node3 newNode = new Node3(data);
        if(head == null) {
            head = newNode;
            newNode.next = head; // دائري
        } else {
            Node3 current = head;
            while(current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // إدخال عنصر في موقع معين
    void insertAtPosition(int data, int position) {
        Node3 newNode = new Node3(data);

        if(head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        if(position == 0) {
            Node3 current = head;
            while(current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
            head = newNode;
            return;
        }

        Node3 current = head;
        int count = 0;
        while(count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        if(count != position - 1) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // طباعة القائمة
    void printList() {
        if(head == null) return;

        Node3 current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while(current != head);
        System.out.println();
    }
}
