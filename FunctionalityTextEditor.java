class Node {
    String text;
    Node prev, next;

    Node(String text) {
        this.text = text;
    }
}

class TextEditor {
    private Node head, tail, current;
    private int size = 0;
    private final int MAX_SIZE;

    TextEditor(int maxSize) {
        this.MAX_SIZE = maxSize;
    }

    public void addState(String text) {
        Node newNode = new Node(text);
        if (current != null && current.next != null) {
            truncateForward();
        }
        if (head == null) {
            head = tail = current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = tail = newNode;
        }
        size++;
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    private void truncateForward() {
        Node temp = current.next;
        while (temp != null) {
            Node next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = next;
            size--;
        }
        current.next = null;
        tail = current;
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No state available.");
        }
    }
}

public class FunctionalityTextEditor
{
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("New Text");
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }
}