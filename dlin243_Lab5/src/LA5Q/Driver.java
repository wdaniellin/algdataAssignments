package LA5Q;
import java.util.*;
/*
Daniel Lin, Nov. 08/26
dlin243@uwo.ca
Program that allows the user to add, and embark/disembark passengers on and off a plane.
Makes use of data structures that follow the logical format passengers are processed in real life to
perform operations.
 */
public class Driver {
    public static void main(String[] args){
        myHeader(5);

        //declare new scanner for input
        Scanner in = new Scanner(System.in);

        //Queue is used (via Linkedlist) to store the passengers that want to board. Alternatively,
        //could make the queue via Deque, but I'm not sure if that was learnt. Because passengers line
        //up at gate and the ones at the front of the line board the plane first, boarding follows a
        //FiFo structure, so it makes sense to use a queue.
        Queue<Passenger> boardingLine = new LinkedList<>();

        //Stack is used to represent the passengers currently in the plane that would like to disembark
        //The disembarking process of a plane typically has passengers that are closer to the exit (at the front)
        //leave the plane first, therefore we use a LiFo model (Stack) to represent the passengers loaded in the end
        //leaving first, as they are the closest to the exit. (this assumes of course that passengers boarding the plane
        //go toward the rear of the plane first, and don't just immediately sit down from the front)
        Stack<Passenger> airplane = new Stack<>();

        //pre-adding 5 passengers to make testing easier, (yes they are footballers)
        boardingLine.add(new Passenger("Cristiano", "Ronaldo"));
        boardingLine.add(new Passenger("Antoine", "Griezmann"));
        boardingLine.add(new Passenger("Alphonso", "Davies"));
        boardingLine.add(new Passenger("Son", "Heung-Min"));
        boardingLine.add(new Passenger("Lionel", "Messi"));

        //UI for the system
        System.out.println("=--=Welcome to the SuperCool™ airline management system=--=");


        //loop terminal until exited
        boolean running = true;
        while(running){
            System.out.println("\t==---== MAIN TERMINAL ==---==");
            System.out.printf("Current Status: %d in line, %d in plane%n", boardingLine.size(), airplane.size());
            //how many passengers, embarked/disembarked
            System.out.println("(1)Add Passenger\t\t (2)Embark Passenger");
            System.out.println("(3)Disembark Passenger\t (4)Show Status ");
            System.out.println("(5)Exit");

            System.out.print("Choice (1-5): ");
            String input = in.nextLine();

            switch (input){
                case "1": //(adding another passenger)
                    //prompt user to make another passenger
                    System.out.print("Enter passenger first name: ");
                    String firstName = in.nextLine();

                    System.out.print("Enter passenger last name: ");
                    String lastName = in.nextLine();

                    boardingLine.add(new Passenger(firstName, lastName));
                    System.out.printf("New passenger %s %s added!%n", firstName, lastName);
                    break;

                case "2":
                    //embark one passenger from the queue onto the plane
                    if(boardingLine.isEmpty()){
                        System.out.println("\nline is empty, no one to embark!!");
                    }
                    else {
                        //temporarily store the passenger that is boarding
                        //use the stored passenger to poll/push from and to the boarding line/airplane
                        Passenger temp = boardingLine.poll();
                        airplane.push(temp);

                        System.out.printf("%npassenger %s has embarked onto the plane.%n", temp);
                    }
                    break;

                case "3":
                    //disembark one passenger from the plane
                    //same code as in case 2 essentially
                    if(airplane.isEmpty()){
                        System.out.println("\nplane is empty, no one to disembark!!");
                    }
                    else {
                        //again, store the passenger that is being removed from the airplane
                        Passenger temp = airplane.pop();
                        System.out.printf("%npassenger %s has disembarked from the plane%n", temp);
                    }
                    break;

                case "4": //display the lists
                    //display boarding line and current airplane seats,
                    //check if empty in either case
                    System.out.println("\ncurrent boarding line:");
                    if(boardingLine.isEmpty()){
                        System.out.println("[line is empty]");
                    } else {
                        //use for each to print out passengers
                        for(Passenger p : boardingLine){
                            System.out.println("  " + p);
                        }
                    }

                    //print out plane seats
                    System.out.println("\nairplane Seats: (front of plane = top of display)");
                    if(airplane.isEmpty()){
                        System.out.println("[Cabin is empty]\n");
                    } else {
                        //iterate through from the back, so display follows a stack structure more logically
                        for(int i = airplane.size()-1; i >= 0; i--){
                            System.out.println("  " + airplane.get(i));
                        }
                    }
                    break;

                case "5": //(Exiting)
                    running = false;
                    System.out.println("Exiting...");
                    break;

                //if input is invalid
                default:
                    System.out.println("Invalid. (1-5): ");
                    break;
            }
        }
        myFooter(5);
    }

    //method that prints out the header information for the lab exercise
    //int n as an input displays the exercise number
    public static void myHeader(int n){
        //lab exercise, prepared by, student no., then goal
        System.out.printf("Lab Exercise %d question", n);
        System.out.println("\nPrepared by: Daniel Lin");
        System.out.println("Student Number: 251482984");
        System.out.println("Goal of this Exercise: This exercise provides a boarding terminal\nfor airline agents " +
                "that allows the user to embark and disembark passengers on a plane manually. Once a passenger disembarks" +
                "they are removed. User has the option to add\nnew passengers to a boarding list, which functions as a queue" +
                "\nand embark onto the plane (stack), with a menu prompt in main allowing the user to access these operations"+
                "\n---------------------------\n");
    }

    //method that displays the footer information for lab exercise
    //int n displays the exercise number, which is displayed
    public static void myFooter(int n){
        System.out.printf("-----------\n" +
                "Completion of lab exercise %d question was successful!", n);
        System.out.println("\nSigning off - Daniel");
    }
}
