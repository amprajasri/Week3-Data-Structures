import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int n = 1_000_000;
        int target = n - 1;

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        long start1 = System.nanoTime();
        boolean foundInArray = arrayList.contains(target);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long end3 = System.nanoTime();

        System.out.println("ArrayList search: " + (end1 - start1) / 1e6 + " ms");
        System.out.println("HashSet search: " + (end2 - start2) / 1e6 + " ms");
        System.out.println("TreeSet search: " + (end3 - start3) / 1e6 + " ms");
    }
}
