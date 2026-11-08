package L4Q2;
import java.util.ArrayList;
import java.util.Collections;
/*
Daniel Lin, Nov. 2/26
dlin243@uwo.ca
Program that makes an arraylist of students and uses comparator methods to sort them by last/first name
as well as score
 */

public class DriverForStudentClass {
    public static void main(String[] args){
        //make new student (me by default)
        Student myInfo = new Student();
        //call header using created stduent
        myHeader(myInfo, 4, 2);


        //declare new array list, add previously created student to the list
        ArrayList<Student> students = new ArrayList<>();
        students.add(myInfo);

        //add all the students as specified in the instructions
        students.add(new Student("Harry", "Potter", 75.50));
        students.add(new Student("Ronald", "Weasley", 86.00));
        students.add(new Student("Hermione", "Granger", 91.70));
        students.add(new Student("Parvati", "Patil", 93.75));

        //print out the scorecard
        System.out.println("The Score Card:");
        System.out.println(students);

        //use collections.sort to sort the scores
        System.out.println("\nThe sorted list in terms of score in descending order....");
        Collections.sort(students);
        System.out.println(students);

        //sort lastnames with created lastname comparator class
        System.out.println("\nThe sorted list in terms of Last Names....");
        Collections.sort(students, new HelperClassCompareLastNames());
        System.out.println(students);

        //sort firstnames with created lastname comparator class
        System.out.println("\nThe sorted list in terms of First Names....");
        Collections.sort(students, new HelperClassCompareFirstNames());
        System.out.println(students);

        //call footer
        myFooter(4, 2);

    }




    //method that prints out the header information for the lab exercise
    //int labE_number displays lab number, and q_number displays the question number
    //name of student (me) stored in new myInfo reference variable of student type
    public static void myHeader(Student myInfo, int labE_number, int q_number){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q%d", labE_number, q_number);
        System.out.printf("\n\nPrepared by: %s %s", myInfo.getFirstName(), myInfo.getLastName());
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise:  " +
                "making use of comparators to sort an arraylist of students by lastname/firstname" +
                "as well as their test score with the built in collections.sort method" +
                "\n-----------");
    }

    //method that displays the footer information for lab exercise
    //int labE_number displays lab number, and q_number displays the question number
    public static void myFooter(int labE_number, int q_number){
        System.out.printf("-----------\n" +
                "Completion of lab exercise %d Q%d was successful!", labE_number, q_number);
        System.out.println("\nSigning off - Daniel");
    }
}
