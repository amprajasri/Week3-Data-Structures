class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 1) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeTaskById(int id) {
        if (head == null) return;
        if (head.taskId == id && head.next == head) {
            head = null;
            current = null;
            return;
        }
        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (current == temp) current = current.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (current != null) {
            System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName + ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
        } else {
            System.out.println("No current task.");
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName + ", Priority=" + temp.priority + ", Due Date=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID=" + temp.taskId + ", Name=" + temp.taskName + ", Priority=" + temp.priority + ", Due Date=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Design", 2, "2025-04-20");
        scheduler.addTaskAtBeginning(2, "Code", 1, "2025-04-18");
        scheduler.addTaskAtPosition(3, "Test", 3, "2025-04-22", 2);
        scheduler.addTaskAtEnd(4, "Deploy", 2, "2025-04-25");

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        scheduler.removeTaskById(3);
        scheduler.displayAllTasks();

        scheduler.searchByPriority(2);
        scheduler.searchByPriority(5);
    }
}
