package LA3Q1;
/*
Daniel Lin, Oct. 2/26
dlin243@uwo.ca
Program that makes use of a class with two generic reference variables to store the data of years, and names
of university student council members, with the help of an arraylist in main, storing pair objects. Now makes use
of a try catch loop to validate for integer input
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GenericsAndArrays_Daniel {

    public static void main(String[] args){
        //call my header
        myHeader(3);

        //declare new arraylist for Integers, and populate with years as instructed
        ArrayList<Integer> studentYears = new ArrayList<>();
        studentYears.add(2);
        studentYears.add(3);
        studentYears.add(4);
        studentYears.add(3);
        studentYears.add(2);
        studentYears.add(2);

        //declare new arraylist for Strings, and populate with names as instructed
        ArrayList<String> studentNames = new ArrayList<>();
        studentNames.add("Harry");
        studentNames.add("Lavender");
        studentNames.add("Ron");
        studentNames.add("Hermione");
        studentNames.add("Luna");
        studentNames.add("Vincent");

        //declare new array of pairs to later populate with the
        //previously declared arraylist values
        Pair<Integer, String>[] studentData = new Pair[studentNames.size()];

        //iterate through and populate the pair array
        for (int i = 0; i < studentNames.size(); i++) {
            studentData[i] = new Pair<>(studentYears.get(i), studentNames.get(i));
        }

        //declare a boolean so that the program keeps looping if desired
        boolean cont = true;

        //declare new scanner
        Scanner s = new Scanner(System.in);

        //loop the program until the user exits out after being prompted at the end
        while(cont){

            //prompt user for input, and repeat until input is either 2,3, or 4
            int year = 0;
            System.out.print("Enter Academic Year (2,3 or 4): ");

            //use infinite loop and try catch
            while(true){
                try{
                    year = s.nextInt(); //prompt user
                    if(year == 2 || year == 3 || year == 4){
                        break; //break out of loop if input is valid
                    }
                    System.out.print("Incorrect! Enter Academic Year (2,3 or 4): ");
                }

                catch (InputMismatchException e){
                    System.out.print("Incorrect format, Enter Academic Year (2,3 or 4): ");
                    s.nextLine(); //clear line
                }
            }

            //declare a temporary arraylist of Strings to hold the names of the students
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 0; i < studentData.length; i++){
                //using .equals to check the year, parse year into an integer and use .equals to compare
                if(studentData[i].getKey().equals(year)){
                    //if it equals, add it to the temporary arraylist, cast into String
                    temp.add(studentData[i].getValue());
                }
            }
            //print the number of names found for the year:
            System.out.printf("Found %d leader(s) from year %s", temp.size(), year);
            //print out names that match the year:
            System.out.println("\nhere is the list:\n" + temp);

            //prompt user if they want to continue, and take the value as a string and compare it
            System.out.print("Do you wish to continue? (Press y to continue, or any other key to terminate): " );
            String option = s.next();
            //if option is not y, then terminate
            if(!option.equals("y")) cont = false;
        }

        //call footer
        myFooter(3);
    }


    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q1", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise makes use of a generic\n class with two " +
                "reference variable parameters, as well as an arraylist in main," +
                "in order to keep\n track of the year of study as well as names of students on the student council." +
                "\n Additionally, now also includes a try-catch statement to validate integer input"+
                "\n-----------");
    }

    //method that displays the footer information for lab exercise
    //int n displays the exercise number, which is displayed
    public static void myFooter(int n){
        System.out.printf("-----------\n" +
                "Completion of lab exercise %d Q1 was successful!", n);
        System.out.println("\nSigning off - Daniel");
    }
}
