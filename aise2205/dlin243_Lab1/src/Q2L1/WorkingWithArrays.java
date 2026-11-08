package Q2L1;
import java.util.Scanner;
/*
Daniel Lin, Sept. 17/26
dlin243@uwo.ca
program that iterates through an array of doubles (with size and values entered by the user), finding the doubles
that are divisible by 5, and outputting an array with the max,min,avg value of the doubles.
 */
public class WorkingWithArrays {
    //assignment says to create a public static method instead of doing it locally
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        myHeader(1); //call header

        //prompt user to input
        System.out.print("input a number for the size of the array: ");
        double[] arr = new double[input.nextInt()]; //assignment says no validation required

        //iterate through the length of the array, prompting the user to assign a double value
        //to each index in the array
        for(int i = 0; i < arr.length; i++){
            System.out.printf("Enter value %d of the array: ", (i+1));
            arr[i] = input.nextInt(); //assign index of array to the inputted value
            //populate with integers as specified
        }
        System.out.println("Here are the results from the array: ");

        //store results from the method call into a double array called results
        double[] results = mma5MethodDaniel(arr);

        //if the array is empty (has no numbers divisible by 5), then directly show the footer
        if(results.length == 0){
            myFooter(1);
        }
        else{ //print all the information from the array as required, call footer
            System.out.printf("The max is %.2f\n", results[0]);
            System.out.printf("The min is %.2f\n", results[1]);
            System.out.printf("The avg of the numbers divisible by 5 is %.2f\n", results[2]);
            System.out.printf("My student number is %.0f", results[3]);
            myFooter(1);
        }

    }


    //method that takes in an array of doubles, and iterates through it to find numbers divisible by 5
    //at the end of the iteration, finds the max,min, and average of the doubles, outputting them as a
    //double array in the format (max,min,avg,studentNo.)
    public static double[] mma5MethodDaniel(double[] arr){
        double max = 0; //set max and min to 0
        double min = 0;
        double sum = 0;//sum up all numbers divisible by 5
        double count = 0; //count how many numbers divisible by 5 there are
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 5 == 0){
                count++; //increment count if a number divisible by 5 is found
                sum += arr[i];
                if(count == 1){
                    //if a divisible number is found, set max and min respectively
                    max = arr[i];
                    min = arr[i];
                }
                max = Math.max(max, arr[i]); //if indexed number is bigger than max, set max to the number
                min = Math.min(min, arr[i]); //if indexed number is smaller than min, set min to the number
            }
        }
        //hard code, when no numbers divisible by 5 are found, provide an empty array and display message
        if(count == 0){
            System.out.println("In the array, no numbers were divisible by 5!! The average stays 0.00");
            return new double[0]; //return empty array if nothing was found
        }
        System.out.printf("Daniel found %.0f numbers that are divisible by 5\n", count);
        double[] values = {max,min,sum/count,251482984};
        return values;
    }

    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q2", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise aims to find the max, min, and average" +
                " of doubles divisible by 5 within an array, with individual values inputted by the user" +
                "\n-----------");
    }

    //method that displays the footer information for lab exercise
    //int n displays the exercise number, which is displayed
    public static void myFooter(int n){
        System.out.printf("\n-----------\n" +
                "Completion of lab exercise %d Q2 was successful!", n);
        System.out.println("\nSigning off - Daniel");
    }
}
