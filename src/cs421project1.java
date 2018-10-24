// Jared Powell, Stephen Green

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cs421project1 {

    public static void main(String[] args) throws FileNotFoundException {

        bst tree = new bst();
        File file = new File("test1.txt");
        int id;
        String name;
        double gpa;

        // Create File reader
        Scanner reader = new Scanner(file);
        // Get line from reader
        String line = reader.nextLine();
        int size = Integer.parseInt(line);
        // Will go through all but the last line to parse data
        while(reader.hasNext()) {
            line = reader.next();
            id = Integer.parseInt(line);
            name = reader.next();
            line = reader.next();
            gpa = Double.parseDouble(line);
            student newStudent = new student(id, name, gpa);
            newStudent.print();
            tree.insert(newStudent);
        }

        //TODO: Create menu and incorporate AVL tree (I believe in you Stephen

    }

}
