package Q1L1;
import java.util.Scanner;
/*
Daniel Lin, Sept. 17/26
dlin243@uwo.ca
program that performs a factorial operation based off an inputted integer, both iteratively and recursively,
comparing the results of the time taken to execute both
 */
public class TestingExecutionTime {
    //assignment says to declare a public static scanner instead of doing it within main:
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        myHeader(1); //call header
        //prompt user
        System.out.print("input a number and find its factorial: ");

        //Assignment says to assume input is an integer,
        //so no checking if incorrect data type is inputted
        //ask user to input an integer "num", repeatedly ask until input is valid (>= 0)
        int num = input.nextInt();
        while(num < 0){
            System.out.println("Please input zero or a positive number!! ");
            num = input.nextInt();
        }

        long startTime = System.nanoTime(); //start nanotime, store as startTime

        //iterative solution INSIDE driver, store final factorial sum as int
        double factorial = 1;
        for(int i = num; i > 0; i--){
            factorial*=i;
        }
        long endTime = System.nanoTime(); //end nanotime, store as endTime

        //factorial from iterative solution INSIDE main
        System.out.printf("Factorial of (%d) is %.2e", num, factorial);
        System.out.printf("\nTime taken by iterative solution inside main: %.2e sec",(endTime-startTime)/1000000000.0);
        //divide by 1*10^9 to convert nanoseconds to seconds

        //factorial from iterative solution METHOD call
        startTime = System.nanoTime();
        factorial = iterativeMethodForFactorial(num);
        endTime = System.nanoTime();
        System.out.printf("\nFactorial of (%d) with iterative method is %.2e", num, factorial);
        System.out.printf("\nTime taken by iterative method call: %.2e sec", (endTime-startTime)/1000000000.0);

        //factorial from recursive method call
        startTime = System.nanoTime();
        factorial = recursiveMethodFactorial(num);
        endTime = System.nanoTime();
        System.out.printf("\nFactorial of (%d) with recursive method is %.2e", num, factorial);
        System.out.printf("\nTime taken by recursive method call: %.2e sec", (endTime-startTime)/1000000000.0);

        myFooter(1); //call footer
    }

    //naming conventions for methods used from picture provided on lab pdf (they're rlly long for some reason)

    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q1", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise aims to compare the execution time" +
                " of finding factorial in two ways: iteratively (via a for loop), and recursively." +
                "\nAdditionally, we will compare the execution time of the iterative method through a" +
                " method call and directly from main\n-----------");
    }

    //method that displays the footer information for lab exercise
    //int n displays the exercise number, which is displayed
    public static void myFooter(int n){
        System.out.printf("\n-----------\n" +
                "Completion of lab exercise %d Q1 was successful!", n);
        System.out.println("\nSigning off - Daniel");
    }

    //method that iteratively calculates factorial, using a for loop to take the input n
    //and multiplying it with the sum while de-incrementing itself by one until it reaches one
    public static double iterativeMethodForFactorial(int n){
        //set sum to one to avoid multiplication by 0 and also for edge case fac(0) - which returns one
        double sum = 1;
        //count down inputted number n down by one and multiply to the sum
        for(int i = n; i > 0; i--){
            sum *= i;
        }
        return sum;
    }

    //method that recursively calculates factorial, by returning itself -1 until
    //n is equal to zero, returning one
    public static double recursiveMethodFactorial(int n){
        //base case
        if(n == 0) return 1;
        //return itself minus one, to achieve factorial
        return(n*recursiveMethodFactorial(n-1));
    }
}
