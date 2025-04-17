public class SearchSpecificWordInSentences {

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a programming language.",
            "Linear search is a simple search algorithm."
        };
        String word = "programming";
        String result = findSentenceWithWord(sentences, word);
        System.out.println(result);  // Output: Java is a programming language.
    }

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
