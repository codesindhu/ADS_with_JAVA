class Node {
    int key;
    Node left, right, parent;

    Node(int d) {
        key = d;
        left = right = parent = null;
    }
}

class SplayTree {
    Node root;

    // Zig rotation
    void zig(Node x) {
        Node p = x.parent;
        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = x;
            else
                p.parent.right = x;
        }
        if (x == p.left) {
            p.left = x.right;
            if (x.right != null)
                x.right.parent = p;
            x.right = p;
        } else {
            p.right = x.left;
            if (x.left != null)
                x.left.parent = p;
            x.left = p;
        }
        x.parent = p.parent;
        p.parent = x;
        root = x;
    }

    // Zig-Zig rotation
    void zigZig(Node x) {
        zig(x.parent);
        zig(x);
    }

    // Zig-Zag rotation
    void zigZag(Node x) {
        zig(x);
        zig(x);
    }

    // Splay operation
    void splay(Node x) {
        while (x.parent != null) {
            Node p = x.parent;
            if (p.parent == null)
                zig(x);
            else if ((x == p.left && p == p.parent.left) || (x == p.right && p == p.parent.right))
                zigZig(x);
            else
                zigZag(x);
        }
    }

    // Search node with key k
    Node search(int k) {
        Node x = root;
        while (x != null && x.key != k) {
            if (k < x.key)
                x = x.left;
            else
                x = x.right;
        }
        if (x != null)
            splay(x);
        return x;
    }

    // Insertion operation
    void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node x = root;
        Node parent = null;
        while (x != null) {
            parent = x;
            if (key < x.key)
                x = x.left;
            else if (key > x.key)
                x = x.right;
            else // Duplicate key not allowed
                return;
        }
        newNode.parent = parent;
        if (key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;
        splay(newNode);
    }

    // Deletion operation
    void delete(int key) {
        Node node = search(key);
        if (node == null)
            return; // Key not found
        if (node.left == null)
            transplant(node, node.right);
        else if (node.right == null)
            transplant(node, node.left);
        else {
            Node minRight = minimum(node.right);
            if (minRight.parent != node) {
                transplant(minRight, minRight.right);
                minRight.right = node.right;
                minRight.right.parent = minRight;
            }
            transplant(node, minRight);
            minRight.left = node.left;
            minRight.left.parent = minRight;
        }
    }

    // Helper method to transplant subtrees
    void transplant(Node u, Node v) {
        if (u.parent == null)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        if (v != null)
            v.parent = u.parent;
    }

    // Helper method to find minimum node
    Node minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Display elements
    void display() {
        System.out.print("Splay Tree elements: ");
        inorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.display();

        tree.search(60);
        tree.display();

        tree.insert(52);
        tree.display();

        tree.delete(30);
        tree.display();
    }
}
