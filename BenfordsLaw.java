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
        firstNum("sales.csv");
    }
    public static int dataNum(String fileName) {
        File file = new File(fileName);
        String line = "";
        int lineCount = 0;

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                if (Character.isDigit(line.charAt(5))) {
                //System.out.println(line);
                lineCount++;
                }
            }
            scan.close();
            return lineCount;
            //System.out.println(lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
        }
        return 0;
    }
    
    public static int[] firstNum(String fileName) {
        File file = new File(fileName);
        int lineCount = dataNum(fileName);
        int[] firstNum = new int[lineCount];
        String line = "";
        char first = ' ';
    
        try {
            Scanner scan = new Scanner(file);
            for(int i = 0; i <= lineCount; i++) {
                line = scan.nextLine();
                if (Character.isDigit(line.charAt(5)) == false) {
                    line = scan.nextLine();
                }
                first = line.charAt(5);
                int num = Character.getNumericValue(first);
                firstNum[i] = num;
                //System.out.println(firstNum[i]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
        }
        return firstNum;
    }
}