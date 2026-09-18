# CIT300 – University Student Record and Campus Route Management System

Graded Practical Assignment 1 (Week 10) — Data Structures and Algorithms

## Group Members

| Name | Student ID | Responsibility | Individual Contribution |
|------|-----------|-----------------|--------------------------|
| M. R. F. Ramla | 23DA2-0925 | Linked list & student-record management | Implemented StudentLinkedList.java: add/update/delete/search/display |
| M. F. F. Zainab | 23DA2-0874 | Stack & Queue implementation | Implemented ActionStack.java (recent actions/history) and ServiceQueue.java (service request FIFO handling) |
| M. M. F. Shazna | 23DA2-0639 | BST/AVL tree & hashing | Implemented StudentBST.java and StudentHashTable.java |
| J. F. Rifna | 23DA2-0842 | Graph, campus locations, BFS/DFS | Implemented CampusGraph.java |
| All members | — | Integration, validation, testing, GitHub collaboration | Jointly built Main.java, tested all menu paths, wrote README |

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