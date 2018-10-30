public class bst {

    node root;
    int count; // Counts number of nodes traversed in search

    // Constructor
    public bst() {
        this.root = null;
        this.count = 0;
    }
    // Adds new node to BST using iteration
    public void insert(student s) {
        if (root == null) {
            root = new node(s);
            return;
        }
        node parent = null;
        node current = root;
        // searches until it finds a null child for the insertion
        // While true runs until return occurs
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
    // Iteratively searches tree to find specified id
    public student find(int id) {
  
        node current = root;
        // if student can't be found, return null
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
    // Goes as far left as possible to find minimum ID because that's how BSTs store smallest value
    public student findMinID() {
        node current = root;
        while (current.hasLeft()) {
        	count++;
            current = current.left;
        }
        return current.s;
    }
    // Goes as far right as possible to find maximum ID because that's how BSTs store largest value
    public student findMaxID() {
        node current = root;
        while (current.hasRight()) {
        	count++;
            current = current.right;
        }
        return current.s;
    }
// Displays number of nodes traversed and resets counter
     public int displayCount() {
         // return count value and reset it for future use
         int temp = this.count;
         this.count = 0;
         return temp;
     }
}
