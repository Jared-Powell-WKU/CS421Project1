// Code for AVL Tree found at:
// https://www.sanfoundry.com/java-program-implement-avl-tree/
// Only constructor and balancing methods kept, all else removed

/* Class AVLNode */
class AVLNode {

    AVLNode left, right;

    student data;

    int height;

    /* Constructor */
    public AVLNode(student s) {

        left = null;

        right = null;

        data = s;

        height = 0;

    }

    public boolean hasLeft() {
        if (this.left != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRight() {
        if (this.right != null) {
            return true;
        } else {
            return false;
        }
    }
}

/* Class AVLTree */
class AVLTree {

    private AVLNode root;
    int count;

    /* Constructor */
    public AVLTree() {

        root = null;
        count = 0;

    }

    /* Function to insert data */
    public void insert(student data) {

        root = insert(data, root);

    }

    // Use for AVL balancing logic
    private int height(AVLNode t) {

        return t == null ? -1 : t.height;

    }

    /* Function to max of left/right node */
    // More AVL Tree balancing logic
    private int max(int lhs, int rhs) {

        return lhs > rhs ? lhs : rhs;

    }

    /* Function to insert data recursively */
    private AVLNode insert(student s, AVLNode t) {
        if (t == null) {
            t = new AVLNode(s);
        } else if (s.id < t.data.id) {
            t.left = insert(s, t.left);

            if (height(t.left) - height(t.right) == 2) {
                if (s.id < t.left.data.id) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (s.id > t.data.id) {
            t.right = insert(s, t.right);

            if (height(t.right) - height(t.left) == 2) {
                if (s.id > t.right.data.id) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Do nothing
        }

        t.height = max(height(t.left), height(t.right)) + 1;

        return t;

    }

    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1) {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     *
     * Double rotate binary tree node: first left child
     *
     * with its right child; then node k3 with new left child
     */
    private AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     *
     * Double rotate binary tree node: first right child
     *
     * with its left child; then node k1 with new right child
     */
    private AVLNode doubleWithRightChild(AVLNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(AVLNode r, int val) {
        this.count++;
        boolean found = false;

        while ((r != null) && !found) {
            int rval = r.data.id;

            if (val < rval) {
                r = r.left;
            } else if (val > rval) {
                r = r.right;
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
// Displays number of nodes traversed and resets counter

    public int displayCount() {
        // return count value and reset it for future use
        int temp = this.count;
        this.count = 0;
        return temp;
    }

    public student find(int id) {
        AVLNode current = root;
        while (current != null) {
            count++;
            if (current.data.id == id) {
                return current.data;
            } else if (current.data.id >= id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    // Goes as far left as possible to find minimum ID because that's how BSTs store smallest value
    public student findMinID() {
        AVLNode current = root;
        while (current.hasLeft()) {
            count++;
            current = current.left;
        }
        return current.data;
    }

    // Goes as far right as possible to find maximum ID because that's how BSTs store largest value
    public student findMaxID() {
        AVLNode current = root;
        while (current.hasRight()) {
            count++;
            current = current.right;
        }
        return current.data;
    }
}
