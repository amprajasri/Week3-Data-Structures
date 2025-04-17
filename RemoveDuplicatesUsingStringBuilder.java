import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "programming";
        String result = removeDuplicates(original);
        System.out.println("Original String: " + original);
        System.out.println("String without duplicates: " + result);
    }
}
