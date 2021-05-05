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

    }
    public static void readFile(String fileName) {
        File file = new File(fileName);
        String line = "";
        int lineCount = 0;

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                System.out.println(line);
                lineCount++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
        }
    }
}