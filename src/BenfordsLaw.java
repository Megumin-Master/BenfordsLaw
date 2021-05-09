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
        System.out.println("Hello World");
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
     * 
     * @param array
     */
    public static void createFile(float[] array){
        String newFileName = "results.csv";

        try{
            File newFile = new File(newFileName);

            if(newFile.createNewFile()){
                PrintWriter csvWriter = new PrintWriter(newFile);
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
