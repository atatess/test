public class BinarySearchTree<T> {
    Node<T> root;
    public Node<T> search(Node<T> node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node;
        } else if (key < node.key) {
            return search(node.left, key);
        } else if (key > node.key) {
            return search(node.right, key);
        } else  {
            return node;
        }
    }

    public Node<T> findMax() {
        Node<T> node = root;
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node<T> findMin() {
        Node<T> node = root;
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int oddCount(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.key % 2 != 0) {
            count = 1;
        }
        count += oddCount(node.left);
        count += oddCount(node.right);
        return count;
    }

    public Node<T> traverseInOrder(Node<T> node) {
        if (node == null) {
            return  null;
        }
        if (node.left != null) {
            traverseInOrder(node.left);
            return node;
        }
        if (node.right != null) {
            traverseInOrder(node.right);
            return node;
        }
    }
}
