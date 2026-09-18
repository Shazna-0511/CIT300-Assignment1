import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;
/**
 * ActionStack.java
 * Author: M.F.F Zainab - 23DA2-0874
 * Member 2 Responsibility: Stack implementation for recent actions/history.
 * Requirement 3: "Use a stack to maintain recent actions, deleted records,
 * or an undo/history feature."
 *
 * Implemented as a custom array-based stack (LIFO) so we clearly demonstrate
 * push/pop mechanics rather than relying on java.util.Stack.
 * Every add/update/delete performed on student records is logged here,
 * and it can be displayed (menu option 7) as a recent-actions history.
 */
public class ActionStack {

    /** Represents a single logged action, e.g. "DELETE", "ADD", "UPDATE". */
    public static class Action {
        private final String type;
        private final String description;
        private final String timestamp;

        public Action(String type, String description) {
            this.type = type;
            this.description = description;
            this.timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        @Override
        public String toString() {
            return "[" + timestamp + "] " + type + " -> " + description;
        }
    }

    private Action[] stackArray;
    private int top;      // index of the top element, -1 when empty
    private int capacity;

    public ActionStack() {
        this(50); // default capacity, auto-grows if exceeded
    }

    public ActionStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new Action[capacity];
        this.top = -1;
    }

    public boolean isEmpty() { return top == -1; }

    private void resizeIfNeeded() {
        if (top + 1 == capacity) {
            capacity *= 2;
            Action[] newArray = new Action[capacity];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            stackArray = newArray;
        }
    }

    /** Push a new action onto the stack. Called automatically by Main after every operation. */
    public void push(String type, String description) {
        resizeIfNeeded();
        stackArray[++top] = new Action(type, description);
    }

    /** Pop (remove and return) the most recent action - basis of an "undo" feature. */
    public Action pop() {
        if (isEmpty()) throw new EmptyStackException();
        Action a = stackArray[top];
        stackArray[top--] = null;
        return a;
    }

    /** Peek at the most recent action without removing it. */
    public Action peek() {
        if (isEmpty()) return null;
        return stackArray[top];
    }

    /** Requirement (menu item 7): Display recent actions, most recent first. */
    public void displayRecentActions() {
        if (isEmpty()) {
            System.out.println("No recent actions recorded yet.");
            return;
        }
        System.out.println("---- Recent Actions (Stack, most recent first) ----");
        for (int i = top; i >= 0; i--) {
            System.out.println((top - i + 1) + ". " + stackArray[i]);
        }
    }
}
