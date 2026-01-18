public class ConcatenateLinkedListsGeneric {
    public static void main(String[] args) {
        // إنشاء قائمتين من نوع Integer
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.append(1);
        list1.append(2);
        list1.append(3);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.append(4);
        list2.append(5);
        list2.append(6);

        System.out.print("List 1: ");
        list1.printList();

        System.out.print("List 2: ");
        list2.printList();

        // دمج القائمتين
        list1.concatenate(list2);

        System.out.print("Concatenated List: ");
        list1.printList();
    }
}

// تعريف العقدة Generic
class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

// تعريف قائمة مرتبطة Generic
class LinkedList<E> {
    Node<E> head;

    // إضافة عنصر في نهاية القائمة
    void append(E data) {
        Node<E> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node<E> current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // طباعة القائمة
    void printList() {
        Node<E> current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // دمج قائمتين
    void concatenate(LinkedList<E> list2) {
        if(head == null) {
            head = list2.head;
            return;
        }
        Node<E> current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = list2.head;
    }
}


