// Jared Powell, Stephen Green

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cs421project1 {

    public static void main(String[] args) throws FileNotFoundException {

        bst tree = new bst();
        AVLTree avl = new AVLTree();
        File file = new File("test1.txt");
        int id;
        String name;
        double gpa;

        // Get line from reader
        try ( // Create File reader
                Scanner reader = new Scanner(file)) {
            // Get line from reader
            String line = reader.nextLine();
            int size = Integer.parseInt(line);
            // Will go through all but the last line to parse data
            while (reader.hasNext()) {
                line = reader.next();
                id = Integer.parseInt(line);
                name = reader.next();
                line = reader.next();
                gpa = Double.parseDouble(line);
                student newStudent = new student(id, name, gpa);
                // newStudent.print();
                tree.insert(newStudent);
                avl.insert(newStudent);
            }
        }

        //TODO: AVL tree (I believe in you Stephen
        // System.out.println(tree.find(1));
        String choice = " ";
        Scanner input = new Scanner(System.in);

        //Menu with 3 options
        //Compares strings so we won't have to deal with as many error exceptions
        while (!choice.equals("exit")) {
            System.out.println("1) Search for student by ID");
            System.out.println("2) Find student info with lowest ID");
            System.out.println("3) Find student info with greatest ID");
            System.out.print("Select: ");

            choice = input.nextLine();

            switch (choice) {

                //Find Option
                case "1":
                    System.out.println("What student id do you want to find? ");
                    int idSearch = input.nextInt();
                    if (avl.search(idSearch)) {
                        student foundStudent = tree.find(idSearch);
                        student foundStudent2 = avl.find(idSearch);
                        if (foundStudent != null) {
                            System.out.println("BST Tree: " +foundStudent);
                            System.out.println("Nodes BST tree traversed: " + tree.displayCount());
                            
                            System.out.println("AVL Tree: "+ foundStudent2);
                            System.out.println("Nodes AVL tree traversed: " + avl.displayCount());
                        }
                    } else {
                        System.out.println("Could not find Student with id: " + idSearch);
                    }

                    input.nextLine();
                    break;

                //Min Option
                case "2":
                    student testStudent = tree.findMinID();
                    student testStudent2 = avl.findMinID();
                    System.out.println("BST Min ID Student: " + testStudent);
                    System.out.println("Nodes BST tree traversed: " + tree.displayCount());
                    
                    System.out.println("AVL Min ID Student: " + testStudent2);
                    System.out.println("Nodes AVL tree traversed: " + avl.displayCount() + "\n");
                
                    break;

                //Max Option
                case "3":
                	student maxStudent = tree.findMaxID();
                    student maxStudent2 = avl.findMaxID();
                    System.out.println("BST Max ID Student: " + maxStudent);
                    System.out.println("Nodes BST tree traversed: " + tree.displayCount());
                    
                    System.out.println("AVL Max ID Student: " + maxStudent2);
                    System.out.println("Nodes AVL tree traversed: " + avl.displayCount() + "\n");
                
                    break;
                case "exit":
                    System.out.println("Good-bye");
                    break;

                default:
                    System.out.println("Invalid Choice. Please Try Again \n");
            }

        }

    }

}
