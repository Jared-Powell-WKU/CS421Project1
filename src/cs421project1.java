// Jared Powell, Stephen Green

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cs421project1 {
    
    private static int[] getImportantSpaces(String line) {
        int spaces[] = {999, 0}; // Space after ID and before GPA
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ') {
                if(i < spaces[0])
                    spaces[0] = i;
                if(i > spaces[0])
                    spaces[1] = i;
            }
                
        }
        return spaces;
    }
    
    private static void readFile() throws FileNotFoundException {
                File file = new File("student_info.txt");
        int id;
        String name;
        double gpa;
            // Create File reader
            Scanner reader = new Scanner(file);
            // Get line from reader
            String line = reader.nextLine();
            // Will go through all but the last line to parse data
            while(reader.hasNext()) {
                // Since we're allowed to assume all data will be in the file correctly,
                // I wrote a method that grabs the space that separates the id from the
                // student name (spaces[0]) and the space that separates the name from the
                // gpa (spaces[1]) from here, we break into substrings and parse as needed
                int spaces[] = getImportantSpaces(line);
                id = Integer.parseInt(line.substring(0, spaces[0]));
                gpa = Double.parseDouble(line.substring(spaces[1]));
                name = line.substring(spaces[0]+1, spaces[1]);
                System.out.println(id + ", " + name + ", " + gpa);
                line = reader.nextLine();
            }
            // hasNext requires us past this logic one time afterwards to get last one
            int spaces[] = getImportantSpaces(line);
                id = Integer.parseInt(line.substring(0, spaces[0]));
                gpa = Double.parseDouble(line.substring(spaces[1]));
                name = line.substring(spaces[0]+1, spaces[1]);
                System.out.println(id + ", " + name + ", " + gpa);
    }


    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }

}
