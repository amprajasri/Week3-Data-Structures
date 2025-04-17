import java.util.Stack;

class SortStackRecursively {

    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, top);
        }
    }

    private void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
}

public class StackSortTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        SortStackRecursively sorter = new SortStackRecursively();
        sorter.sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
