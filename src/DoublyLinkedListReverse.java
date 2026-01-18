public class DoublyLinkedListReverse {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.print("Original List: ");
        list.printForward();

        list.printReverse(); // طباعة القائمة عكسياً
    }
}

// تعريف العقدة
class Node2 {
    int data;
    Node2 next;
    Node2 prev;

    Node2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// تعريف القائمة المزدوجة
class DoublyLinkedList {
    Node2 head;
    Node2 tail;

    // إضافة عنصر في نهاية القائمة
    void append(int data) {
        Node2 newNode = new Node2(data);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // طباعة القائمة للأمام
    void printForward() {
        Node2 current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // الطباعة بالعكس
    void printReverse() {
        Node2 current = tail;
        System.out.print("Reverse List: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
