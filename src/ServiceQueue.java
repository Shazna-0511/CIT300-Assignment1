import java.util.NoSuchElementException;

/**
 * ServiceQueue.java
 * Author: [Your Full Name] - [Your Student ID]
 * Member 2 Responsibility: Queue implementation for student service requests. 
 * Requirement 4: "Use a queue to manage student service requests in order
 * of arrival."
 
 * Implemented as a custom circular array-based queue (FIFO) to clearly
 * demonstrate enqueue/dequeue mechanics rather than relying on java.util.Queue.
 */
public class ServiceQueue {

    /** A single service request made by / for a student. */
    public static class ServiceRequest {
        private final String studentId;
        private final String description;

        public ServiceRequest(String studentId, String description) {
            this.studentId = studentId;
            this.description = description;
        }

        public String getStudentId() { return studentId; }
        public String getDescription() { return description; }

        @Override
        public String toString() {
            return "Student " + studentId + " - " + description;
        }
    }

    private ServiceRequest[] queueArray;
    private int front, rear, count, capacity;

    public ServiceQueue() {
        this(50);
    }

    public ServiceQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new ServiceRequest[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }

    private void resizeIfNeeded() {
        if (count == capacity) {
            ServiceRequest[] newArray = new ServiceRequest[capacity * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = queueArray[(front + i) % capacity];
            }
            queueArray = newArray;
            front = 0;
            rear = count - 1;
            capacity *= 2;
        }
    }

    /** Requirement (menu item 5): Add a service request to the back of the queue. */
    public void enqueue(String studentId, String description) {
        resizeIfNeeded();
        rear = (rear + 1) % capacity;
        queueArray[rear] = new ServiceRequest(studentId, description);
        count++;
    }

    /** Requirement (menu item 6): Process (remove) the request that arrived first. */
    public ServiceRequest dequeue() {
        if (isEmpty()) throw new NoSuchElementException("No pending service requests.");
        ServiceRequest r = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % capacity;
        count--;
        return r;
    }

    /** View the request at the front without removing it. */
    public ServiceRequest peek() {
        if (isEmpty()) return null;
        return queueArray[front];
    }

    /** Optional helper: display everything currently waiting in the queue. */
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("---- Pending Service Requests (Queue, FIFO order) ----");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + queueArray[(front + i) % capacity]);
        }
    }
}
