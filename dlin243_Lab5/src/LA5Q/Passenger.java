package LA5Q;
//passenger class that stores passengers, with each passenger having a name and boarding number
public class Passenger {
    private String firstName, lastName;
    private int boardingNumber;
    //boarding number is for identifying that the embarking/disembarking is working properly

    private static int boardingNumberCounter = 1;
    //auto increments the boarding number anytime a new passenger is added

    //constructors. . .
    public Passenger(){boardingNumberCounter++;}

    //constructor, set boarding number to the current counter
    public Passenger(String firstName, String lastName){
        this.boardingNumber = boardingNumberCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters and setters
    public int getBoardingNumber() {
        return boardingNumber;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    //to string method
    @Override
    public String toString() {
        return String.format("[#%d] %s %s", boardingNumber, firstName, lastName);
    }
}
