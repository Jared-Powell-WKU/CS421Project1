public class bst {
    node root;

   public bst() {
       this.root = null;
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
           if(current.s.compareTo(s) < 0) {
               current = current.right;
               if(current == null) {
                   parent.right = new node(s);
                   return;
               }
           } else {
               current = current.left;
               if(current == null) {
                   parent.left = new node(s);
                   return;
               }
           }
        }
   }

   public boolean find(int id) {
       node current = root;
       while(current != null) {
           if(current.s.id == id)
               return true;
           else if (current.s.id >= id)
               current = current.left;
           else
               current = current.right;
       }
       return false;
   }
   public student findMinID() {
       node current = root;
       while(current.hasLeft())
        current = current.left;
       return current.s;
   }
    public student findMaxID() {
        node current = root;
        while(current.hasRight())
            current = current.right;
        return current.s;
    }
}
