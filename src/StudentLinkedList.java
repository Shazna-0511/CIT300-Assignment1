/**
 * StudentLinkedList.java
 * Author: RamlaRishad - 23DA2-0925
 * MEMBER 1 RESPONSIBILITY: Linked list implementation and student-record management.
 *
 * Implements a custom singly linked list (no java.util.LinkedList used, since the
 * assignment wants us to DEMONSTRATE the data structure) to store, add, update,
 * delete, search and display Student records.
 */
public class StudentLinkedList {

    // Internal node class
    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;
    private int size;

    public int size() { return size; }

    /** Requirement 12: Add student record. Rejects duplicate IDs (Requirement 14). */
    public boolean addStudent(Student s) {
        if (search(s.getStudentId()) != null) {
            System.out.println("ERROR: A student with ID " + s.getStudentId() + " already exists.");
            return false;
        }
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
        return true;
    }

    /** Requirement 12: Search student record by ID. */
    public Student search(String studentId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getStudentId().equalsIgnoreCase(studentId)) return temp.data;
            temp = temp.next;
        }
        return null; // not found
    }

    /** Requirement 12: Update student record. */
    public boolean updateStudent(String studentId, String name, String programme, double marks) {
        Student s = search(studentId);
        if (s == null) return false;
        if (name != null && !name.isEmpty()) s.setName(name);
        if (programme != null && !programme.isEmpty()) s.setProgramme(programme);
        if (marks >= 0) s.setMarks(marks);
        return true;
    }

    /** Requirement 12: Delete student record. Returns the removed Student (or null). */
    public Student deleteStudent(String studentId) {
        Node prev = null, temp = head;
        while (temp != null) {
            if (temp.data.getStudentId().equalsIgnoreCase(studentId)) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;
                size--;
                return temp.data;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    /** Requirement 4 (menu item): Display all records using the linked list. */
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("---- All Student Records (Linked List) ----");
        Node temp = head;
        int count = 1;
        while (temp != null) {
            System.out.println(count++ + ". " + temp.data);
            temp = temp.next;
        }
    }

    /** Helper used by Member 3 to build the BST / hash table from current data. */
    public java.util.List<Student> toList() {
        java.util.List<Student> list = new java.util.ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        return list;
    }
}
