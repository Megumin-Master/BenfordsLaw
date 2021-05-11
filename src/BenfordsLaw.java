/*
 * Date: May 5, 2021
 * Name: David Han, Benjamin Kim
 * Teacher: Mr. Ho
 * Description: BenfordsLaw Assignment
 */

 //Importing necessary packages for reading and printing into files
import java.util.*;
import java.io.*;

//Importing necessary packages for javafx, the graph
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BenfordsLaw extends Application {

    //An override in order to use specific methods from the packages installed. 
    //Look at settings.json and launch.json for the selection of modules/packages used.
    @Override public void start(Stage stage) {

        Scanner user = new Scanner(System.in);  // Call the scanner class to use
        File file = name(user); // Calling the name method and storing it as a File variable
        int[] numbers = firstNum(file); // Calling the firstNum method and storing the return value in an integer array

        //Using the amounts, count how many of each number there are
        int[] amounts = count(numbers);

        //Find the percentages of each number
        double[] percentages = percentage(amounts);

        //Create the file using the data from percentages
        createFile(percentages);

        user.close();

        //The following below in the Override is used with the help of the official documentation
        //and various videos online. Without the help we received, we wouldn't be able to learn how to
        //set up the graph and modules required to create the graph.
        //Creating the variables and data for the data of the graph
        //Ex: Title, axis, etc
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Number Percentages");
        xAxis.setLabel("Number");
        yAxis.setLabel("Percentage");
 
        //Creates the data for the first and only set of data, the percentages.
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Set 1");       
        series1.getData().add(new XYChart.Data("1", percentages[0]));
        series1.getData().add(new XYChart.Data("2", percentages[1]));
        series1.getData().add(new XYChart.Data("3", percentages[2]));
        series1.getData().add(new XYChart.Data("4", percentages[3]));
        series1.getData().add(new XYChart.Data("5", percentages[4]));
        series1.getData().add(new XYChart.Data("6", percentages[5]));
        series1.getData().add(new XYChart.Data("7", percentages[6]));
        series1.getData().add(new XYChart.Data("8", percentages[7]));
        series1.getData().add(new XYChart.Data("9", percentages[8]));
        
        //Creates a window to display the graph on.
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    //The main class that will run. It will launch the Override
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
     * This method is to count the total number of the first digits.
     * Ex: There are 200 ones, 90 twos, etc
     * @param array The array of the first digits
     * @return the total amount of each digit in an integer array
     */
    public static int[] count(int[] array){
        //Initialize variables for each digit.
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        //For each item in the array, check which number it is.(1-9)
        //Increase that number count by 1.
        for(int i = 0; i < (array.length); i++){
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

        //Assign the counter amount into the array
        int[] amounts = {count1, count2, count3, count4, count5, count6, count7, count8, count9};

        //return the array
        return(amounts);
    }

    /**
     * Author: David Han
     * Using the counted array, find the percentage of that number based on the total amount of numbers.
     * (rounded to the tenth)
     * Put that percentage into the array that will be returned.
     * @param array The counted array
     * @return An array of the percentage of each number
     */
    public static double[] percentage(int[] array){

        //The total sum of all the items in the array. Used for finding the percentage.
        double total = 0;
        for(int i = 0; i < array.length; i++){
            total += array[i];
        }

        //The array where all the percentages will be stored
        double[] percentage = new double[9];

        //For each item in the array, find the percentage and insert into the percentage array
        for(int i = 0; i < array.length; i++){
            percentage[i] = Math.round((array[i] / total)*1000.0)/10.0;
        }
        
        //Checking the first percentage to see the likelihood of fraud.
        //If the percentage is between 29 and 32, then fraud most likely didn't occured.
        //If not, there is a possibility of fraud.
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

            //Create new instance of PrintWriter to write into the new file
            FileWriter csvWriter = new FileWriter(newFile, false);
            //For each number, print the percentage into the file
            for(int i = 0; i < 9; i++){
                csvWriter.write((i+1) + ": " + array[i] + "%\n");
            }
            //Close the PrintWriter since we don't need it anymore.
            csvWriter.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }
}
