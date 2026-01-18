public class PriorityQueueUsingBST {
    public static void main(String[] args) {
        BSTPriorityQueue pq = new BSTPriorityQueue();

        pq.enqueue(30);
        pq.enqueue(10);
        pq.enqueue(50);
        pq.enqueue(20);
        pq.enqueue(40);

        System.out.print("Inorder of BST (Priority Queue): ");
        pq.inorder(pq.root);
        System.out.println();

        System.out.println("Dequeue: " + pq.dequeue());
        System.out.println("Dequeue: " + pq.dequeue());

        System.out.print("Inorder after dequeue operations: ");
        pq.inorder(pq.root);
        System.out.println();
    }
}

// تعريف Node
class NodeBST {
    int data;
    NodeBST left, right;

    NodeBST(int data) {
        this.data = data;
        left = right = null;
    }
}

// Priority Queue باستخدام BST
class BSTPriorityQueue {
    NodeBST root;

    // إدخال عنصر
    void enqueue(int data) {
        root = insert(root, data);
    }

    private NodeBST insert(NodeBST node, int data) {
        if(node == null) return new NodeBST(data);
        if(data < node.data) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);
        return node;
    }

    // إزالة أصغر عنصر
    int dequeue() {
        if(root == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        NodeBST parent = null;
        NodeBST current = root;

        // الذهاب إلى العقدة اليسرى الأقصى
        while(current.left != null) {
            parent = current;
            current = current.left;
        }

        int minValue = current.data;

        // حذف العقدة اليسرى الأقصى
        if(parent == null) {
            // أصغر عنصر هو الجذر
            root = root.right;
        } else {
            parent.left = current.right;
        }

        return minValue;
    }

    // طباعة BST inorder (تصاعدي)
    void inorder(NodeBST node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}
