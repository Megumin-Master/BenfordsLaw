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

        //System.out.println("Hello World");

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
        series1.getData().add(new XYChart.Data(one, 35.0));
        series1.getData().add(new XYChart.Data(two, 33.4));
        series1.getData().add(new XYChart.Data(three, 31.8));
        series1.getData().add(new XYChart.Data(four, 30.9));
        series1.getData().add(new XYChart.Data(five, 30.8));
        series1.getData().add(new XYChart.Data(six, 29.7));
        series1.getData().add(new XYChart.Data(seven, 15.6));
        series1.getData().add(new XYChart.Data(eight, 14.5));
        series1.getData().add(new XYChart.Data(nine, 8.7));
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * This method is to sort the array of the first digits in ascending order using the bubble sort method.
     * Because it's only first digits, a lot of the numbers will repeat, but that is what we're looking for.
     * This is mainly to group up the similar digits of the array (1-9)
     * @param array The array of the first digits
     * @return the sorted array
     */
    public static int[] sortArray(int[] array){
        //for each comparison, compare the current item on the array with the next item
        //Ex: item 0 and item 1, then item 1 and item 2
        for(int i = 0; i < (array.length - 1); i++){
            //Assigns variables to the current item and the next item
            int current = array[i];
            int next = array[i+1];

            //If the current value is greater than the next value, replace values and sort through
            //the entire array again
            if(current > next){
                array[i] = next;
                array[i+1] = current;

                //Return the array that's fully sorted
                return(sortArray(array));
            }
        }

        //If there are no need to sort, then return the final array.
        //Goes through all the previous versions of sortArray, returning the final array
        return(array);
    }

    /**
     * Using the sorted/grouped array, count how many of each number(1-9) there are.
     * Find the percentage of that number based on the total amount of numbers.(rounded to the tenth).
     * Put that percentage into the array that will be returned.
     * @param array The sorted array
     * @return An array of the percentage of each number
     */
    public static double[] percentage(int[] array){
        //The number that is being compared to the array. 
        //Will increase as the array's number increases.(1-9)
        int comparison = 1;
        //The total number of times that the number has been shown/repeated
        double numTotal = 0.0;
        //The total number of items in the array. Used for finding the percentage.
        double total = array.length;
        //The array where all the percentages will be stored
        double[] percentage = new double[9];

        //For each item in the array, check to see if the item is the same as the comparison(num)
        for(int i = 0; i < total; i++){
            //If they're the same, increase the numTotal(Number of times it showed up/repeated)
            if(comparison == array[i]){
                numTotal ++;
            }
            //Else, calculate the percentage of the number, rounded to the nearest tenth.
            //Add the percentage into the percentage array.
            //Increase the comparison number by 1 and reset the numTotal.
            else{
                percentage[comparison-1] = Math.round((numTotal/total)*1000.0)/10.0;

                comparison++;
                numTotal=1.0;
            }
        }
        //At the end, it should be comparing the number 9 and never reached 
        //the else statement since 9 is the last number.
        //Repeating the statement since it never got called.
        percentage[comparison-1] = Math.round((numTotal/total)*1000.0)/10.0;

        //Return the percentage array
        return percentage;
    }

    /**
     * Using the percentage array, create a new csv file where the percentages of the numbers are listed.
     * No return value as the purpose of the method is to create a file, not return a value
     * back into the main code.
     * @param array The percentage array from the previous method
     */
    public static void createFile(float[] array){
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
