public class RemoveAtPosition {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.print("Original List: ");
        list.printList();

        int positionToRemove = 2; // حذف العنصر في الموقع 2
        list.removeAtPosition(positionToRemove);

        System.out.print("After removing position " + positionToRemove + ": ");
        list.printList();
    }
}

// تعريف العقدة
class Node1 {
    int data;
    Node1 next;
    Node1(int data) { this.data = data; this.next = null; }
}

// تعريف القائمة المرتبطة
class LinkedList1 {
    Node1 head;

    // إضافة عنصر في نهاية القائمة
    void append(int data) {
        Node1 newNode = new Node1(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node1 current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // إزالة عنصر عند موقع معين
    void removeAtPosition(int position) {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }

        if(position == 0) {
            head = head.next; // حذف الرأس
            return;
        }

        Node1 current = head;
        for(int i = 0; i < position - 1; i++) {
            if(current.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if(current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next; // إزالة العقدة
    }

    // طباعة القائمة
    void printList() {
        Node1 current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
