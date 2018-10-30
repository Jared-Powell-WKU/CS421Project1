// Jared Powell, Stephen Green

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cs421project1 {

    public static void main(String[] args) throws FileNotFoundException {

        bst tree = new bst();
        AVLTree avl = new AVLTree();
        File file = new File("test2.txt");
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

        String choice = " ";
        Scanner input = new Scanner(System.in);

        //Menu with 3 options
        //Compares strings so we won't have to deal with as many error exceptions
        while (!choice.equals("exit")) {
            System.out.println("1) Search for student by ID");
            System.out.println("2) Find student info with lowest ID");
            System.out.println("3) Find student info with greatest ID");
            System.out.println("Type \"exit\" to end program");
            System.out.print("Select: ");

            choice = input.nextLine();

            switch (choice) {

                //Find Option
                case "1":
                    System.out.println("What student id do you want to find? ");
                    int idSearch = input.nextInt();

                    // Run both find functions to compare the two
                    student foundStudent = tree.find(idSearch);
                    student foundStudent2 = avl.find(idSearch);
                    // Even if somehow one is null, we're still comparing how many nodes were visited
                    // Since they are trees with identical values, one of these will never be null without
                    // the other
                    if (foundStudent != null || foundStudent2 != null) {
                        System.out.println("BST Tree: " + foundStudent);
                        System.out.println("Nodes BST tree traversed: " + tree.displayCount());

                        System.out.println("AVL Tree: " + foundStudent2);
                        System.out.println("Nodes AVL tree traversed: " + avl.displayCount());
                    } else {
                        // We still want to show how many nodes were checked before finding it to be a bad ID
                        System.out.println("Could not find Student with id: " + idSearch);
                        System.out.println("Nodes BST tree traversed: " + tree.displayCount());
                        System.out.println("Nodes AVL tree traversed: " + avl.displayCount());
                    }
                    // Catch input as to not mess up future user inputs
                    input.nextLine();
                    break;

                //Min Option
                case "2":
                    // Run both functions to compare the two and display both results
                    student testStudent = tree.findMinID();
                    student testStudent2 = avl.findMinID();
                    System.out.println("BST Min ID Student: " + testStudent);
                    System.out.println("Nodes BST tree traversed: " + tree.displayCount());

                    System.out.println("AVL Min ID Student: " + testStudent2);
                    System.out.println("Nodes AVL tree traversed: " + avl.displayCount() + "\n");

                    break;

                //Max Option
                case "3":
                    // Run both functions to compare the two and display both results
                    student maxStudent = tree.findMaxID();
                    student maxStudent2 = avl.findMaxID();
                    System.out.println("BST Max ID Student: " + maxStudent);
                    System.out.println("Nodes BST tree traversed: " + tree.displayCount());

                    System.out.println("AVL Max ID Student: " + maxStudent2);
                    System.out.println("Nodes AVL tree traversed: " + avl.displayCount() + "\n");

                    break;
                // Different checks for exit
                case "exit":
                    System.out.println("Good-bye");
                    break;

                default:
                    // Tell user to try again
                    System.out.println("Invalid Choice. Please Try Again \n");
            }

        }

    }

}
