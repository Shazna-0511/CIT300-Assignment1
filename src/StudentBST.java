/**
 * StudentBST.java
 * MEMBER 3 RESPONSIBILITY (Part A): BST/AVL tree implementation.
 *
 * Requirement 5: "Use a BST or AVL tree to organize/search student records
 * by Student ID or another suitable key."
 *
 * This is a standard (unbalanced) Binary Search Tree keyed on Student ID.
 * (If your lecturer specifically requires AVL self-balancing, tell me and
 * I will extend this class with left/right rotations and height balancing -
 * the menu-facing behaviour stays identical either way.)
 */
public class StudentBST {

    private static class TreeNode {
        Student data;
        TreeNode left, right;
        TreeNode(Student data) { this.data = data; }
    }

    private TreeNode root;

    /** Insert a student, ordered by Student ID (String comparison). */
    public void insert(Student s) {
        root = insertRec(root, s);
    }

    private TreeNode insertRec(TreeNode node, Student s) {
        if (node == null) return new TreeNode(s);
        int cmp = s.getStudentId().compareTo(node.data.getStudentId());
        if (cmp < 0) node.left = insertRec(node.left, s);
        else if (cmp > 0) node.right = insertRec(node.right, s);
        else node.data = s; // same ID -> update in place
        return node;
    }

    /** Search by Student ID - O(log n) average case. */
    public Student search(String studentId) {
        TreeNode node = root;
        while (node != null) {
            int cmp = studentId.compareTo(node.data.getStudentId());
            if (cmp == 0) return node.data;
            node = (cmp < 0) ? node.left : node.right;
        }
        return null;
    }

    /** Remove a node (used to keep the tree in sync after a delete in Main). */
    public void delete(String studentId) {
        root = deleteRec(root, studentId);
    }

    private TreeNode deleteRec(TreeNode node, String studentId) {
        if (node == null) return null;
        int cmp = studentId.compareTo(node.data.getStudentId());
        if (cmp < 0) node.left = deleteRec(node.left, studentId);
        else if (cmp > 0) node.right = deleteRec(node.right, studentId);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.data = successor.data;
            node.right = deleteRec(node.right, successor.data.getStudentId());
        }
        return node;
    }

    /** Requirement (menu item 8): Display students in sorted (in-order) sequence. */
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No student records found in the tree.");
            return;
        }
        System.out.println("---- Students in ID order (BST In-Order Traversal) ----");
        int[] count = {1};
        inOrderRec(root, count);
    }

    private void inOrderRec(TreeNode node, int[] count) {
        if (node == null) return;
        inOrderRec(node.left, count);
        System.out.println(count[0]++ + ". " + node.data);
        inOrderRec(node.right, count);
    }

    /** Rebuild the tree from scratch (kept in sync with the linked list). */
    public void rebuildFrom(java.util.List<Student> students) {
        root = null;
        for (Student s : students) insert(s);
    }
}
