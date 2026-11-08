package LA3Q2;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
Daniel Lin, Oct. 2/26
dlin243@uwo.ca
Program that makes use of a generic class with two reference variable parameters,
as well as a DanielArray class that manually performs operations such as pop, push,
and dequeue for operations on an array, treating them respectively as stacks
and queues, with a menu prompt in main allowing the user to access these operations
 */

public class DemoStackAndQueue_Daniel {
    public static Scanner input = new Scanner(System.in); //static scanner
    public DemoStackAndQueue_Daniel(){} //optional parameter constructor

    public static void main (String[] args){
        myHeader(3);

        DanielArray x; //instantiate daniel array x
        System.out.println("This code performs a demo for Stack and Queue:\n");

        //print out menu
        System.out.println("Main Demo-Menu:");
        System.out.println("\t1: Stack\n\t2: Queue\n\t3: Exit");
        System.out.println("Enter your choice: ");

        int option = 0;
        //use infinite loop and try catch to validate menu input
        while(true){
            try{
                option = input.nextInt(); //prompt user
                if(option == 1 || option == 2 || option == 3){
                    if(option == 1){
                        x = new DanielArray();
                        stackDemo(x);
                    }
                    if(option == 2){
                        x = new DanielArray();
                        queueDemo(x);
                    }
                    if(option == 3) break; //break out of loop if input is valid
                }
                System.out.println("\t1: Stack\n\t2: Queue\n\t3: Exit");
                System.out.println("Enter your choice: ");
            }

            catch (InputMismatchException e){
                System.out.print("Incorrect format\n");
                System.out.println("\t1: Stack\n\t2: Queue\n\t3: Exit");
                System.out.println("Enter your choice: ");
                input.nextLine(); //clear line
            }
        }


        myFooter(3);
    }


    //method that takes in a DanielArray arr, and prompts the user to manually perform stack operations on the array
    //such as pop, and push, calling on its respective methods within the DanielArray class
    //User enters in individual values for pair, which are added into the DanielArray
    public static void stackDemo(DanielArray arr){
        System.out.println("You have an empty stack: " + arr);

        //validate input with a switch case inside a while true loop
        while(true){
            //prompt user
            System.out.println("Stack Operation Menu: \na: Push\nb: Pop\nc: Exit\nEnter your choice: ");
            String option = input.next();
            switch (option) {
                case "a":
                    //outputted messages kinda copied from the demo code
                    System.out.println("Pushing a data-item into the stack.");
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();

                    //add the values as a pair into the last index of the array
                    arr.addAtLastIndex(new Pair<>(year, name));
                    System.out.println("The current stack: " + arr);
                    break;

                case "b":
                    System.out.println("Popping a data-item.");
                    //check if size is empty
                    if (arr.getSize() == 0) {
                        System.out.println("FYI: The stack is empty!!");
                    }
                    else {
                        //store the removed pair so it can be printed
                        Pair removed = arr.removeFromLastIndex();
                        System.out.println(removed + " is removed! The current stack: " + arr);
                    }
                    break;

                case "c":
                    System.out.println("Ending Stack-demo! Goodbye!");
                    return; //return to main

                default:
                    System.out.println("Invalid choice!"); //default for invalid choice
                    break;
            }
        }
    }

    //method that takes in a DanielArray arr, and prompts the user to manually perform queue operations on the array
    //such as queue and dequeue, calling on its respective methods within the DanielArray class
    //User enters in individual values for pair, which are added into the DanielArray
    //Pretty much identical to the stack, except FIFO instead of LIFO
    public static void queueDemo(DanielArray arr){
        System.out.println("You have an empty queue: " + arr);

        //validate input with a switch case inside a while true loop
        while(true){
            //prompt user
            System.out.println("Queue Operation Menu: \na: Enqueue\nb: Dequeue\nc: Exit\nEnter your choice: ");
            String option = input.next();
            switch (option) {
                case "a":
                    //outputted messages kinda copied from the demo code
                    System.out.println("Enqueuing a data-item into the queue.");
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();

                    //add the values as a pair into the last index of the array
                    arr.addAtLastIndex(new Pair<>(year, name));
                    System.out.println("The current queue: " + arr);
                    break;

                case "b":
                    System.out.println("Dequeuing a data-item.");
                    //check if size is empty
                    if (arr.getSize() == 0) {
                        System.out.println("FYI: The queue is empty!!");
                    }
                    else {
                        //store the removed pair so it can be printed
                        Pair removed = arr.removeFromFirstIndex();
                        System.out.println(removed + " is dequeued! The current queue   : " + arr);
                    }
                    break;

                case "c":
                    System.out.println("Ending Queue-demo! Goodbye!");
                    return; //return to main

                default:
                    System.out.println("Invalid choice!"); //default for invalid choice
                    break;
            }
        }
    }

    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q2", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise makes use of a generic\n class with two " +
                "reference variable parameters, as well as a DanielArray class that manually performs operations" +
                "such as pop, push, and dequeue\n for operations on an array, treating them respectively as stacks" +
                "\n and queues, with a menu prompt in main allowing the user to access these operations"+
                "\n-----------");
    }

    //method that displays the footer information for lab exercise
    //int n displays the exercise number, which is displayed
    public static void myFooter(int n){
        System.out.printf("-----------\n" +
                "Completion of lab exercise %d Q2 was successful!", n);
        System.out.println("\nSigning off - Daniel");
    }
}
