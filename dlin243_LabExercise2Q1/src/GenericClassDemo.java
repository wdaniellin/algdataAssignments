/*
Daniel Lin, Sept. 25/26
dlin243@uwo.ca

 */
public class GenericClassDemo{
    public static void main(String[] args){
        //call header
        myHeader(2);

        //declare two Doubles, assigned the same values as in the sample output
        Double n1 = 3.5;
        Double n2 = 5.0;

        //create a pair using the constructor, then print the empty pair
        Pair<Double> pair = new Pair<>();
        System.out.println("Current Order: " + pair);

        //set the pair using method in pair.java, then print it
        pair.setPair(n1, n2);
        System.out.println("Regular Order: " + pair);

        //reverse pair using method in pair.java, then print the result
        pair.reversePair();
        System.out.println("Reversed Pair: " + pair);

        System.out.println(); //add a space for formatting

        //string array with first/last name
        String[] names = {"Daniel", "Lin"};

        //integer with current date, (d/m/y) (using date of assignment completion)
        Integer[] dates = {25, 9, 2026};

        //print both arrays using print()
        print(names);
        print(dates);

        //instructions say to use footer again, although not in sample output
        //used the footer anyway
        myFooter(2);
    }

    //takes an array input of non-specified data type, and iterates through each index
    //of the array and prints it out
    public static <T> void print(T[] t){
        for(int i = 0; i < t.length; i++){
            //iterate through, and print (add space for formatting)
            System.out.print(t[i] + " ");
        }
        //add space for formatting
        System.out.println();
    }


    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q1", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise makes use of a generic class" +
                "to perform operations such as storing data values (doubles in this case),\nreversing them,and printing them" +
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
