import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {

    public static void main(String[] args) {
        String fileName = "audition.txt";
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) {

            String input;
            System.out.println("Enter text (type 'exit' to stop):");
            
            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input + "\n");
            }

            System.out.println("Input has been written to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
