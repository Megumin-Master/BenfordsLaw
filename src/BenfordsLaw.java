/*
 * Date: May 5, 2021
 * Name: David Han, Benjamin Kim
 * Teacher: Mr. Ho
 * Description: BenfordsLaw Assignment
 */
import java.util.*;
import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BenfordsLaw extends Application {
    final static String one = "1";
    final static String two = "2";
    final static String three = "3";
    final static String four = "4";
    final static String five = "5";
    final static String six = "6";
    final static String seven = "7";
    final static String eight = "8";
    final static String nine = "9";

    @Override public void start(Stage stage) {

        Scanner user = new Scanner(System.in);
        File file = name(user);
        int[] numbers = firstNum(file);

        int[] amounts = sortArray(numbers);

        double[] percentages = percentage(amounts);

        createFile(percentages);

        user.close();

        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Number Percentages");
        xAxis.setLabel("Number");
        yAxis.setLabel("Percentage");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Set 1");       
        series1.getData().add(new XYChart.Data(one, percentages[0]));
        series1.getData().add(new XYChart.Data(two, percentages[1]));
        series1.getData().add(new XYChart.Data(three, percentages[2]));
        series1.getData().add(new XYChart.Data(four, percentages[3]));
        series1.getData().add(new XYChart.Data(five, percentages[4]));
        series1.getData().add(new XYChart.Data(six, percentages[5]));
        series1.getData().add(new XYChart.Data(seven, percentages[6]));
        series1.getData().add(new XYChart.Data(eight, percentages[7]));
        series1.getData().add(new XYChart.Data(nine, percentages[8]));
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * Author - Benjamin Kim
     * Description - Asks the user to input the file name of the file they want to analyze. In this case, sales.csv
     * 
     * @param - Scanner user
     * @return - The user input as a file
     */
    public static File name(Scanner user) {
        System.out.println("Input file name");
        String fileName = user.nextLine();
        File file = new File(fileName);
        return file;
    }
    /*
     * Author - Benjamin Kim
     * Description - Goes through the csv file and counts the lines that have a data point
     * 
     * @param - file
     * @return - Amount of lines with data points
     */
    public static int dataNum(File file) {
        int lineCount = 0;  // Start line count at 0

        try {   // Try catch
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
    public static int[] firstNum(File file) {
        int lineCount = dataNum(file);  // Storing the return of dataNum method as an integer
        int[] firstNum = new int[lineCount];    // Making an int array with an index the same as the lineCount
        String line = "";   // Blank string so it can be used anywhere in method 
    
        try {   // Try catch
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
                //System.out.println(firstNum[i]);
            }
        } catch (FileNotFoundException e) { // If error occurs
            System.out.println("An error has occured"); // Prints that the error has occured
        }
        return firstNum;    // Returns the int array with all the values stored
    }
    
    /**
     * Author: David Han
     * This method is to sort the array of the first digits in ascending order using the bubble sort method.
     * Because it's only first digits, a lot of the numbers will repeat, but that is what we're looking for.
     * This is mainly to group up the similar digits of the array (1-9)
     * @param array The array of the first digits
     * @return the sorted array
     */
    public static int[] sortArray(int[] array){
        //for each comparison, compare the current item on the array with the next item
        //Ex: item 0 and item 1, then item 1 and item 2
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        for(int i = 0; i < (array.length - 1); i++){
            //Assigns variables to the current item and the next item
            if(array[i] == 1){
                count1 ++;
            }
            else if(array[i] == 2){
                count2 ++;
            }
            else if(array[i] == 3){
                count3 ++;
            }
            else if(array[i] == 4){
                count4 ++;
            }
            else if(array[i] == 5){
                count5 ++;
            }
            else if(array[i] == 6){
                count6 ++;
            }
            else if(array[i] == 7){
                count7 ++;
            }
            else if(array[i] == 8){
                count8 ++;
            }
            else if(array[i] == 9){
                count9 ++;
            }
        }
        int[] amounts = {count1, count2, count3, count4, count5, count6, count7, count8, count9};

        //If there is no need to sort, then return the final array.
        //Goes through all the previous versions of sortArray, returning the final array
        return(amounts);
    }

    /**
     * Author: David Han
     * Using the sorted/grouped array, count how many of each number(1-9) there are.
     * Find the percentage of that number based on the total amount of numbers.(rounded to the tenth).
     * Put that percentage into the array that will be returned.
     * @param array The sorted array
     * @return An array of the percentage of each number
     */
    public static double[] percentage(int[] array){

        //The total number of items in the array. Used for finding the percentage.
        double total = 0;

        for(int i = 0; i < array.length; i++){
            total += array[i];
        }
        //The array where all the percentages will be stored
        double[] percentage = new double[9];

        //For each item in the array, check to see if the item is the same as the comparison(num)
        for(int i = 0; i < array.length; i++){
            percentage[i] = Math.round((array[i] / total)*1000.0)/10.0;
        }

        if(percentage[0] >= 29 && percentage[0] <= 32){
            System.out.println("Fraud likely did not occur.");
        }
        else{
            System.out.println("Fraud possibly occured.");
        }

        //Return the percentage array
        return percentage;
    }

    /**
     * Author: David Han
     * Using the percentage array, create a new csv file where the percentages of the numbers are listed.
     * No return value as the purpose of the method is to create a file, not return a value
     * back into the main code.
     * @param array The percentage array from the previous method
     */
    public static void createFile(double[] array){
        //String for the name of the file that's going to be created.
        String newFileName = "results.csv";

        //Create a file variable using the created file name
        try{
            File newFile = new File(newFileName);

            //If the conditions to create a file are met(no other files of the same name are present)
            if(newFile.createNewFile()){
                //Create new instance of PrintWriter to write into the new file
                PrintWriter csvWriter = new PrintWriter(newFile);
                //For each number, print the percentage into the file
                for(int i = 0; i < 9; i++){
                    csvWriter.append((i+1) + ": " + array[i] + "%\n");
                }
                csvWriter.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }
}
