public class bst {

    node root;
    int count; // Counts number of nodes traversed in search

    public bst() {
        this.root = null;
        this.count = 0;
    }

    public void insert(student s) {
        if (root == null) {
            root = new node(s);
            return;
        }
        node parent = null;
        node current = root;
        while (true) {
            parent = current;
            if (current.s.compareTo(s) < 0) {
                current = current.right;
                if (current == null) {
                    parent.right = new node(s);
                    return;
                }
            } else {
                current = current.left;
                if (current == null) {
                    parent.left = new node(s);
                    return;
                }
            }
        }
    }

    public student find(int id) {
        node current = root;
        while (current != null) {
            count++;
            if (current.s.id == id) {
                return current.s;
            } else if (current.s.id >= id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public student findMinID() {
        node current = root;
        while (current.hasLeft()) {
            current = current.left;
        }
        return current.s;
    }

    public student findMaxID() {
        node current = root;
        while (current.hasRight()) {
            current = current.right;
        }
        return current.s;
    }
     public int displayCount() {
         // return count value and reset it for future use
         int temp = this.count;
         this.count = 0;
         return temp;
     }
}
