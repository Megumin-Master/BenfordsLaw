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
        fileName = "sales.csv";
        File file = new File(fileName);

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }
            scan.close();
        } catch (FileNotFoundException e) {
        }
    }
}