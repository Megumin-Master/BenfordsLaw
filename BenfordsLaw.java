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

    public static int[] sortArray(int[] array){
        for(int i = 0; i < (array.length - 1); i++){
            int current = array[i];
            int next = array[i+1];

            if(current > next){
                array[i] = next;
                array[i+1] = current;

                return(sortArray(array));
            }
        }

        return(array);
    }

    public static double[] percentage(int[] array){
        int num = 1;
        double numTotal = 0.0;
        double total = array.length;
        double[] percentage = new double[9];

        for(int i = 0; i < total; i++){
            if(num == array[i]){
                numTotal ++;
            }
            else{
                percentage[num-1] = Math.round((numTotal/total)*1000.0)/10.0;

                num++;
                numTotal=1.0;
            }
        }
        percentage[num-1] = Math.round((numTotal/total)*1000.0)/10.0;

        return percentage;
    }

    public static void createFile(float[] array){
        String newFileName = "results.csv";

        try{
            File newFile = new File(newFileName);

            if(newFile.createNewFile()){
                PrintWriter csvWriter = new PrintWriter(newFile);
                for(int i = 0; i < 9; i++){
                    csvWriter.append((i+1) + ": " + array[i] + "\n");
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
