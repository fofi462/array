public class SearchLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
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

// Node خاص بهذا الكلاس فقط
class NodeSL {
    int data;
    NodeSL next;
    NodeSL(int data) { this.data = data; this.next = null; }
}

class MyLinkedList {
    NodeSL head;

    void append(int data) {
        NodeSL newNode = new NodeSL(data);
        if(head == null) { head = newNode; return; }
        NodeSL current = head;
        while(current.next != null) current = current.next;
        current.next = newNode;
    }

    int search(int key) {
        NodeSL current = head;
        int position = 0;
        while(current != null) {
            if(current.data == key) return position;
            current = current.next;
            position++;
        }
        return -1;
    }
}
