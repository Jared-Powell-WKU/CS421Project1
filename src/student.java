
public class student {

    @Override // Because the IDE wants it here
    public String toString() {
        return "student [ID: " + id + ", Name: " + name + ", GPA: " + gpa + "]";
    }

    int id; // Student ID number
    String name; // Student's Name
    double gpa; // Student's GPA

    //Constructor
    public student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    // If we need to compare to another student
    public int compareTo(student s) {
        if(this.id == s.id)
            return 0;
        else if(this.id > s.id)
            return 1;
        else
            return -1;
    }
    // Any other class methods go here, I've only added the basics for starting out
}
