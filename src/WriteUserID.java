import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class WriteUserID {
    public void addToFile() {
        int userId;
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter myWriter = new FileWriter("accounts.txt",true);

            System.out.println("Enter ur prefered id num");


            userId= scanner.nextInt();

            myWriter.append((Integer.toString(userId)));
            myWriter.append("\n");


            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}