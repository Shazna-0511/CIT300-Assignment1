# CIT300 – University Student Record and Campus Route Management System

Graded Practical Assignment 1 (Week 10) — Data Structures and Algorithms

## Group Members

| Name | Student ID | Responsibility | Individual Contribution |
|------|-----------|-----------------|--------------------------|
| _Fill in_ | _Fill in_ | Linked list & student-record management | _Describe what you built, e.g. "Implemented StudentLinkedList.java: add/update/delete/search/display"_ |
| _Fill in (YOU)_ | _Fill in_ | Stack & Queue implementation | Implemented ActionStack.java (recent actions/history) and ServiceQueue.java (service request FIFO handling) |
| _Fill in_ | _Fill in_ | BST/AVL tree & hashing | Implemented StudentBST.java and StudentHashTable.java |
| _Fill in_ | _Fill in_ | Graph, campus locations, BFS/DFS | Implemented CampusGraph.java |
| All members | — | Integration, validation, testing, GitHub collaboration | Jointly built Main.java, tested all menu paths, wrote README |

> ⚠️ The assignment brief says this table is graded — do not leave any field blank or vague.

## How to Compile & Run

```bash
cd src
javac *.java -d ../bin
cd ../bin
java Main
```

## Project Structure

```
CIT300_Project/
├── README.md
└── src/
    ├── Student.java            (shared model)
    ├── StudentLinkedList.java  (Member 1 – linked list)
    ├── ActionStack.java        (Member 2 – stack / recent actions)
    ├── ServiceQueue.java       (Member 2 – queue / service requests)
    ├── StudentBST.java         (Member 3 – BST)
    ├── StudentHashTable.java   (Member 3 – hashing)
    ├── CampusGraph.java        (Member 4 – graph / BFS / DFS)
    └── Main.java                (All members – menu & integration)
```

## Requirement Coverage Checklist

- [x] Store Student ID, Name, Programme, Marks
- [x] Linked list for student records
- [x] Stack for recent actions / history
- [x] Queue for service requests (FIFO)
- [x] BST for organizing/searching by Student ID
- [x] Hashing for O(1) average ID search
- [x] Graph (adjacency list) for campus locations
- [x] Add/remove locations and connections
- [x] Display campus network
- [x] BFS and DFS traversal
- [x] Add/update/delete/search/display for students
- [x] Menu-driven console with input validation
- [x] Handles invalid input, duplicate IDs/locations, missing records
