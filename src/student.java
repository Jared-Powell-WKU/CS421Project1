
public class student {

    public String toString() {
        return "student [ID: " + id + ", Name: " + name + ", GPA: " + gpa + "]  \n";
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
    // Getters and Setters
    // Get to compare values to one another, Set in case of an update feature
    // (primarily to GPA but I suppose some people change their names)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void print() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("GPA: " + this.gpa);
    }

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
