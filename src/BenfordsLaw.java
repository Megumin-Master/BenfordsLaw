package src;
/*
 * Date: May 5, 2021
 * Name: David Han, Benjamin Kim
 * Teacher: Mr. Ho
 * Description: BenfordsLaw Assignment
 */
import java.util.*;
import java.io.*;

class BenfordsLaw {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        firstNum(user);
        user.close();
    }
    public static String name(Scanner user) {
        System.out.println("Input file name");
        String fileName = user.nextLine();
        return fileName;
    }
    /*
     * Author - Benjamin Kim
     * Description - Goes through the csv file and counts the lines that have a data point
     * 
     * @param - file
     * @return - Amount of lines with data points
     */
    public static int dataNum(Scanner user) {
        int lineCount = 0;  // Start line count at 0
        String fileName = name(user);

        try {   // Try catch
            File file = new File(fileName);
            Scanner scan = new Scanner(file);   // Scans file that was specified
            while(scan.hasNextLine()) { // While loop runs until there are no more lines to read
                String line = scan.nextLine();  // Line read is stored as a string
                if (Character.isDigit(line.charAt(4))) {    // Sees if the 4th character in the line is a integer
                lineCount++;    // If it is an integer, it counts that line
                }
            }
            return lineCount;   // Returns the line count
        } catch (FileNotFoundException e) { // If error occurs
            System.out.println("An error has occured"); // Print that error has occured
        }
        return 0;   // In case there is no lineCount return and to get rid of errors
    }
    
    /*
     * Author - Benjamin Kim
     * Description - Goes through the csv file and stores the 4th character of each line in an integer array, 
     * since the 4th character is the first digit of the number in each line. 
     * 
     * @param - file
     * @return - int array
     */
    public static int[] firstNum(Scanner user) {
        int lineCount = dataNum(user);  // Storing the return of dataNum method as an integer
        int[] firstNum = new int[lineCount];    // Making an int array with an index the same as the lineCount
        String line = "";   // Blank string so it can be used anywhere in method 
        String fileName = name(user);
    
        try {   // Try catch
            File file = new File(fileName);
            Scanner scan = new Scanner(file);   // Scans file that was specified
            for(int i = 0; i < lineCount; i++) {    // For loop that runs as many times as line count
                if (scan.hasNextLine()) {   // When there is a next line
                    line = scan.nextLine(); // The line is stored in the string "line"
                }
                if (Character.isDigit(line.charAt(4)) == false) {   // If the 4th character in the line is not an integer
                    if (scan.hasNextLine()) {   // And there is a line after
                        line = scan.nextLine(); // The program skips the line with no integer and scans the next line instead
                    }
                }
                char first = line.charAt(4);    // The 4th character is stored in a char variable
                int num = Character.getNumericValue(first); // The character is then converted to an integer
                firstNum[i] = num;  // That integer is stored in the int array at the index number equal to the times the for loop ran
                System.out.println(firstNum[i]);
            }
        } catch (FileNotFoundException e) { // If error occurs
            System.out.println("An error has occured"); // Prints that the error has occured
        }
        return firstNum;    // Returns the int array with all the values stored
    }
}