//generic class that is used by main, contains two generic type reference data types
public class Pair<K> {
    //the two private data types
    private K first, second;

    //constructor without parameters
    public Pair() {
    }

    //method that sets the pair, takes in two values for first and second
    public void setPair(K first, K second){
        this.first = first;
        this.second = second;
    }

    //method reverse the print order of the pair
    public void reversePair(){
        //declare temporary variables to store first and second while they are swapped
        K temporary = this.first;
        this.first = this.second;
        this.second = temporary;
    }

    //override to string method
    @Override
    public String toString() {
        //return the string as a printed format
        return ("[" + first + ", " + second + "]");
    }
}
