 /* Class AVLNode */

 class AVLNode

 {    

     AVLNode left, right;

     student data;

     int height;

 

     /* Constructor */

     public AVLNode(student s)

     {

         left = null;

         right = null;

         data = s;

         height = 0;

     }
 }

 

 /* Class AVLTree */

 class AVLTree

 {

     private AVLNode root;     
     int count;

 

     /* Constructor */

     public AVLTree()

     {

         root = null;
         count = 0;

     }

     /* Function to check if tree is empty */

     public boolean isEmpty()

     {

         return root == null;

     }

     /* Make the tree logically empty */

     public void makeEmpty()

     {

         root = null;

     }

     /* Function to insert data */

     public void insert(student data)

     {

         root = insert(data, root);

     }

     /* Function to get height of node */

     private int height(AVLNode t )

     {

         return t == null ? -1 : t.height;

     }

     /* Function to max of left/right node */

     private int max(int lhs, int rhs)

     {

         return lhs > rhs ? lhs : rhs;

     }

     /* Function to insert data recursively */

     private AVLNode insert(student s, AVLNode t)

     {

         if (t == null)

             t = new AVLNode(s);

         else if (s.id < t.data.id)

         {

             t.left = insert( s, t.left );

             if( height( t.left ) - height( t.right ) == 2 )

                 if( s.id < t.left.data.id )

                     t = rotateWithLeftChild( t );

                 else

                     t = doubleWithLeftChild( t );

         }

         else if( s.id > t.data.id )

         {

             t.right = insert( s, t.right );

             if( height( t.right ) - height( t.left ) == 2 )

                 if( s.id > t.right.data.id)

                     t = rotateWithRightChild( t );

                 else

                     t = doubleWithRightChild( t );

         }

         else

           ;  // Duplicate; do nothing

         t.height = max( height( t.left ), height( t.right ) ) + 1;

         return t;

     }

     /* Rotate binary tree node with left child */     

     private AVLNode rotateWithLeftChild(AVLNode k2)

     {

         AVLNode k1 = k2.left;

         k2.left = k1.right;

         k1.right = k2;

         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;

         k1.height = max( height( k1.left ), k2.height ) + 1;

         return k1;

     }

 

     /* Rotate binary tree node with right child */

     private AVLNode rotateWithRightChild(AVLNode k1)

     {

         AVLNode k2 = k1.right;

         k1.right = k2.left;

         k2.left = k1;

         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;

         k2.height = max( height( k2.right ), k1.height ) + 1;

         return k2;

     }

     /**

      * Double rotate binary tree node: first left child

      * with its right child; then node k3 with new left child */

     private AVLNode doubleWithLeftChild(AVLNode k3)

     {

         k3.left = rotateWithRightChild( k3.left );

         return rotateWithLeftChild( k3 );

     }

     /**

      * Double rotate binary tree node: first right child

      * with its left child; then node k1 with new right child */      

     private AVLNode doubleWithRightChild(AVLNode k1)

     {

         k1.right = rotateWithLeftChild( k1.right );

         return rotateWithRightChild( k1 );

     }    

     /* Functions to count number of nodes */

     public int countNodes()

     {

         return countNodes(root);

     }

     private int countNodes(AVLNode r)

     {

         if (r == null)

             return 0;

         else

         {

             int l = 1;

             l += countNodes(r.left);

             l += countNodes(r.right);

             return l;

         }

     }

     /* Functions to search for an element */

     public boolean search(int val)

     {

         return search(root, val);

     }

     private boolean search(AVLNode r, int val)

     {
         this.count++;
         boolean found = false;

         while ((r != null) && !found)

         {

             int rval = r.data.id;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 found = true;

                 break;

             }
            
             found = search(r, val);

         }

         return found;

     }

     /* Function for inorder traversal */

     public void inorder()

     {

         inorder(root);

     }

     private void inorder(AVLNode r)

     {

         if (r != null)

         {

             inorder(r.left);

             System.out.print(r.data +" ");

             inorder(r.right);

         }

     }

     /* Function for preorder traversal */

     public void preorder()

     {

         preorder(root);

     }

     private void preorder(AVLNode r)

     {

         if (r != null)

         {

             System.out.print(r.data +" ");

             preorder(r.left);             

             preorder(r.right);

         }

     }

     /* Function for postorder traversal */

     public void postorder()

     {

         postorder(root);

     }

     private void postorder(AVLNode r)

     {

         if (r != null)

         {

             postorder(r.left);             

             postorder(r.right);

             System.out.print(r.data +" ");

         }

     }

     public int displayCount() {
         // return count value and reset it for future use
         int temp = this.count;
         this.count = 0;
         return temp;
     }

 }