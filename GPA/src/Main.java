import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Double gpa = -1.0;
        //Take in text path and save it
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Format grade information text file like this - " +
                "\nClass Name w/out spaces, grade, and number of credits all separated by spaces." +
                "\nEx. CS101 A- 4.00" +
                "\nEnter path of grade information text file...");
        String path = myObj.nextLine();  // Read user input
        System.out.println("\nProcessing...");
        gpa = fileProcessor(path);

        System.out.println("GPA Calculated : " + gpa);
    }

    private static double fileProcessor(String path) {
        BufferedReader reader;
        double gradeCreditProduct = 0;
        double totalCredits = 0;

        try{
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null){
                //System.out.println("inside while" + line);
                String[] details = line.split(" ");
                double grade = gradeToDouble(details[1]);
                double credits = Double.parseDouble(details[2]);

                gradeCreditProduct += grade * credits;
                totalCredits += credits;
                line = reader.readLine();
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return gradeCreditProduct / totalCredits;
    }

    private static double gradeToDouble(String grade){
        double weight = -1.0;

        switch (grade){
            case "A+" :
                weight = 4.0;
                break;
            case "A":
                weight = 4.0;
                break;
            case "A-" :
                weight = 3.7;
                break;
            case "B+" :
                weight = 3.3;
                break;
            case "B" :
                weight = 3.0;
                break;
            case "B-" :
                weight = 2.7;
                break;
            case "C+" :
                weight = 2.3;
                break;
            case "C" :
                weight = 2.0;
                break;
            case "C-" :
                weight = 1.7;
                break;
            case "D+" :
                weight = 1.3;
                break;
            case "D" :
                weight = 1.0;
                break;
            case "D-" :
                weight = 0.7;
                break;
            case "F" :
                weight = 0.0;
                break;
        }
        return weight;

    }
}
