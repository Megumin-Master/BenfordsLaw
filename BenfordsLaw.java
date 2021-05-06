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
        String fileName = "sales.csv";
        File file = new File(fileName);
        firstNum(file);
    }
    public static int dataNum(File file) {
        String line = "";
        int lineCount = 0;
       
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                if (Character.isDigit(line.charAt(4))) {
                //System.out.println(line);
                lineCount++;
                }
            }
            return lineCount;
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
        }
        return 0;
        //System.out.println(lineCount);
    }
    
    public static int[] firstNum(File file) {
        int lineCount = dataNum(file);
        int[] firstNum = new int[lineCount];
        String line = "";
        char first = ' ';
    
        try {
            Scanner scan = new Scanner(file);
            for(int i = 0; i < lineCount; i++) {
                if (scan.hasNextLine()) {
                    line = scan.nextLine();
                }
                if (Character.isDigit(line.charAt(4)) == false) {
                    if (scan.hasNextLine()) {
                        line = scan.nextLine();
                    }
                }
                first = line.charAt(4);
                int num = Character.getNumericValue(first);
                firstNum[i] = num;
                System.out.println(firstNum[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
        }
        return firstNum;
    }
}