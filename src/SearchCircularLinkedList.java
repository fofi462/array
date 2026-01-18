public class SearchCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList2 list = new CircularLinkedList2();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        int key = 30;
        int pos = list.search(key);

        if(pos != -1) {
            System.out.println("Element " + key + " found at position: " + pos);
        } else {
            System.out.println("Element " + key + " not found in the list.");
        }
    }
}

// تعريف العقدة
class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

// تعريف القائمة الدائرية
class CircularLinkedList2 {
    Node4 head;

    // إضافة عنصر في النهاية
    void append(int data) {
        Node4 newNode = new Node4(data);
        if(head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node4 current = head;
        while(current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    // البحث عن عنصر وإرجاع موقعه
    int search(int key) {
        if(head == null) return -1;

        Node4 current = head;
        int position = 0;

        do {
            if(current.data == key) return position;
            current = current.next;
            position++;
        } while(current != head);

        return -1; // العنصر غير موجود
    }
}
