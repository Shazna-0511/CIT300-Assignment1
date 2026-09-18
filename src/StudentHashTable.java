/**
 * StudentHashTable.java
 * MEMBER 3 RESPONSIBILITY (Part B): Hashing implementation.
 *
 * Requirement 6: "Use hashing to support efficient student ID searching."
 *
 * A simple hash table using separate chaining (array of linked lists / buckets)
 * to resolve collisions. Average-case O(1) search by Student ID.
 */
public class StudentHashTable {

    private static class HashNode {
        String key;       // studentId
        Student value;
        HashNode next;
        HashNode(String key, Student value) { this.key = key; this.value = value; }
    }

    private HashNode[] buckets;
    private int capacity;
    private int size;

    public StudentHashTable() {
        this(16);
    }

    public StudentHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }

    /** Simple hash function based on the string's hashCode(). */
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /** Insert or update a student in the hash table. */
    public void put(String studentId, Student s) {
        int idx = hash(studentId);
        HashNode node = buckets[idx];
        while (node != null) {
            if (node.key.equals(studentId)) {
                node.value = s; // update
                return;
            }
            node = node.next;
        }
        HashNode newNode = new HashNode(studentId, s);
        newNode.next = buckets[idx];
        buckets[idx] = newNode;
        size++;
    }

    /** Requirement (menu item 9): Search student using hashing - O(1) average. */
    public Student get(String studentId) {
        int idx = hash(studentId);
        HashNode node = buckets[idx];
        while (node != null) {
            if (node.key.equals(studentId)) return node.value;
            node = node.next;
        }
        return null;
    }

    /** Remove a student from the hash table (keeps it in sync with the linked list). */
    public void remove(String studentId) {
        int idx = hash(studentId);
        HashNode node = buckets[idx], prev = null;
        while (node != null) {
            if (node.key.equals(studentId)) {
                if (prev == null) buckets[idx] = node.next;
                else prev.next = node.next;
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    public int size() { return size; }

    /** Rebuild the whole table from scratch (kept in sync with the linked list). */
    public void rebuildFrom(java.util.List<Student> students) {
        buckets = new HashNode[capacity];
        size = 0;
        for (Student s : students) put(s.getStudentId(), s);
    }
}
