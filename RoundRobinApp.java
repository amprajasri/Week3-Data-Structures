class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private Process head = null;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcessById(int processId) {
        if (head == null) return;
        if (head.processId == processId && head.next == head) {
            head = null;
            return;
        }
        Process curr = head;
        Process prev = null;
        do {
            if (curr.processId == processId) {
                if (curr == head) {
                    Process last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID=" + temp.processId + ", Burst=" + temp.burstTime + ", Remaining=" + temp.remainingTime + ", Priority=" + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateScheduling(int timeQuantum) {
        if (head == null) return;
        int time = 0;
        boolean done;
        do {
            done = true;
            Process temp = head;
            do {
                if (temp.remainingTime > 0) {
                    done = false;
                    int executed = Math.min(temp.remainingTime, timeQuantum);
                    time += executed;
                    temp.remainingTime -= executed;
                    Process checker = head;
                    do {
                        if (checker != temp && checker.remainingTime > 0)
                            checker.waitingTime += executed;
                        checker = checker.next;
                    } while (checker != head);
                    System.out.println("After executing PID=" + temp.processId + " for " + executed + " units:");
                    displayProcesses();
                }
                temp = temp.next;
            } while (temp != head);
        } while (!done);

        Process temp = head;
        do {
            temp.turnaroundTime = temp.waitingTime + temp.burstTime;
            temp = temp.next;
        } while (temp != head);
    }

    public void calculateAndDisplayAverageTimes() {
        if (head == null) return;
        double totalWT = 0, totalTAT = 0;
        int count = 0;
        Process temp = head;
        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Average Waiting Time: " + (totalWT / count));
        System.out.println("Average Turnaround Time: " + (totalTAT / count));
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        int timeQuantum = 4;
        scheduler.simulateScheduling(timeQuantum);

        System.out.println("Final Process States:");
        scheduler.displayProcesses();

        scheduler.calculateAndDisplayAverageTimes();
    }
}
