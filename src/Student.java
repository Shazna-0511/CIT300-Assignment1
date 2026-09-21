/**
* Author: RamlaRishad - 23DA2-0925
* Member 1 Responsibility: Linked list implementation and studentrecord management.
*/
public class Student {
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    // ----- Getters -----
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getProgramme() { return programme; }
    public double getMarks() { return marks; }

    // ----- Setters (used for "Update Student Record") -----
    public void setName(String name) { this.name = name; }
    public void setProgramme(String programme) { this.programme = programme; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-15s | Programme: %-12s | Marks: %.2f",
                studentId, name, programme, marks);
    }
}
