public class node {
    student s;
    node left;
    node right;
    public node(student s) {
        this.s = s;
        left = null;
        right = null;
    }

    public boolean hasLeft() {
        if(this.left != null)
            return true;
        else
            return false;
    }
    public boolean hasRight() {
        if(this.right != null)
            return true;
        else
            return false;
    }
}

