package data.structure.binarysearchtree;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;

        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        this.root = add(this.root, e);

    }

    // 返回插入节点的node节点
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }


    public void printBinarySearchTree() {

        print(this.root);


    }

    public boolean contains(E e) {
        return contains(this.root, e);
    }

    // 返回以Node node为根节点的字树是否包含E
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }
    private void print(Node node) {

        if (node != null) {
            System.out.println(node.e);
            print(node.left);
            print(node.right);
        }


    }


    public E minimum() {
        if (size == 0) {
            throw new IllegalStateException("empty tree");
        }
        return minimum(this.root).e;
    }
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    public E maxmum() {
        if (size == 0) {
            throw new IllegalStateException("empty tree");
        }
        return maxmum(this.root).e;
    }
    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maxmum(node.right);
        }
    }


    public E removeMini() {
        E minimum = minimum();
//        if (this.root.left == null) {  // 主要是为了处理根节点就是最小节点的情况
//            this.root = this.root.right;
//        } else {
//            removeMini(this.root);
//        }

        this.root = removeMini(this.root);
        return minimum;
    }
    private Node removeMini(Node node) {
        if (node.left == null) {
            Node rightTmp = node.right;
            node = null;
            size--;
            return rightTmp;
        }
        node.left = removeMini(node.left);
        return node;
    }

    public E removeMax() {
        E e = maxmum();

        this.root = removeMax(this.root);
        return e;
    }
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftTmp = node.left;
            node = null;
            size--;
            return leftTmp;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void removeAnyValue(E e) {
        removeAnyValue(this.root, e);
    }
    private Node removeAnyValue(Node node, E e) {

        if (e.compareTo(node.e) < 0) {
            node.left = removeAnyValue(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = removeAnyValue(node.right, e);
        } else {
            Node minimum = minimum(node.right);
            Node node1 = removeMini(node.right);
            size++;
            minimum.left = node.left;
            minimum.right = node1;
            node = null;
            size--;
            return minimum;
        }


        return node;

    }
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(10);

        bst.add(3);
        bst.add(12);
        bst.add(4);
        bst.add(15);


        bst.printBinarySearchTree();

        System.out.println(bst.contains(4));

        System.out.println(bst.minimum());
        System.out.println(bst.maxmum());
        System.out.println("--------");
        bst.removeMini();

        bst.printBinarySearchTree();

    }
}
