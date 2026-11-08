package L4Q1;
/*
Daniel Lin, Nov. 2/26
dlin243@uwo.ca
Program that makes use a doublylinkedlist to store myStudent class variables, which include student
name and score, and performs a variety of operations on them such as linearly searching for a value,
and printing them out
 */
public class Driver_DoublyLinkedList {

    public static void main(String[] args){
        myHeader(4, 1);

        //instantiate new list with my first name as instructed
        DoublyLinkedList<MyStudent> danielList = new DoublyLinkedList<>();

        //create the five Mystudent reference variables with the provided values,
        //then add them to the danieList
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);
        danielList.addLast(s0);
        danielList.addLast(s1);
        danielList.addLast(s2);
        danielList.addLast(s3);

        //print the list
        System.out.println("The list Content:");
        System.out.println(danielList);

        //find info for node s2 and s3
        DoublyLinkedList.Node<MyStudent> s2Node = danielList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> s3Node = danielList.findNode(s3);

        //add s4 using addBetween()
        System.out.println("Adding Hermoine to the list in between Luna and Vincent. . .");
        danielList.addBetween(s4, s2Node, s3Node);

        //print out ocntent
        System.out.println("The list Content:");
        System.out.println(danielList);

        //call footer
        myFooter(4, 1);

    }





    //method that prints out the header information for the lab exercise
    //int labE_number displays lab number, and q_number displays the question number
    public static void myHeader(int labE_number, int q_number){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d Q%d", labE_number, q_number);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise:  " +
                "making use of doublylinkedlists that stores generic type reference variables" +
                " which in this case is used to store MyStudent reference, that include a student" +
                "\nand their test score. Implements a linearly search method to find a specific value"+
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
