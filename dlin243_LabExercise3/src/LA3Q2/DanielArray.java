package LA3Q2;
//Daniel Array class that contains an array of pairs, as well as methods that mimic the methods
//used for queues and stacks (ie. pop, push etc.)
public class DanielArray {
    //private pair array
    private Pair[] testArray;

    //parameterless constructor creates size 0 array
    public DanielArray(){
        testArray = new Pair[0];
    }

    //return the size of the array (length)
    public int getSize(){
        return testArray.length;
    }

    //takes the array, removes the last element and returns it, then reformats the array
    //to a new array without the last element and one size shorter
    public Pair removeFromLastIndex(){
        if (testArray.length == 0) return null; //edge case, although hardcoded in main to never be 0
        //create new array with one length less
        Pair[] newArray = new Pair[testArray.length-1];

        //store the last pair in the array to be returned
        Pair x = testArray[newArray.length];

        //use array copy to copy all elements of the test array to the new one
        System.arraycopy(testArray, 0, newArray, 0, newArray.length);
        testArray = newArray; //change pointer of test array to the newArray

        //return the last pair at the end
        return x;
    }

    //takes the array, removes the first element and returns it, then reformat the array
    //to a new array without the first element and one size shorter
    public Pair removeFromFirstIndex(){
        if (testArray.length == 0) return null; //edge case, although hardcoded in main to never be 0
        //create new array with one length less
        Pair[] newArray = new Pair[testArray.length-1];

        //store the first pair in the array to be returned
        Pair x = testArray[0];

        //use array copy to copy all elements of the test array to the new one, except the first
        System.arraycopy(testArray, 1, newArray, 0, newArray.length);
        testArray = newArray; //change pointer of test array to the newArray

        //return the last pair at the end
        return x;
    }

    //override string method, make it print out as formatted in the slides
    @Override
    public String toString() {
        String output = "[";

        //loop through each pair, and append it to the output string
        for(int i = 0; i < testArray.length; i++){
            output += (testArray[i].toString());
        }
        return String.format(output + ']');
    }

    //takes the array, removes the first element and returns it, then reformat the array
    //to a new array without the first element and one size shorter
    public void addAtLastIndex(Pair p){
        //make a new array with one size larger
        Pair[] newArray = new Pair[testArray.length +1];

        //use array copy to copy all elements of the test array to the new one
        System.arraycopy(testArray, 0, newArray, 0, testArray.length);
        newArray[newArray.length-1] = p; //add the new element to the last index of the array

        testArray = newArray; //change pointer of test array to the newArray
    }

}
