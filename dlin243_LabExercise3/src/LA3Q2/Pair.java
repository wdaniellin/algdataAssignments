package LA3Q2;
//class for pair containing two fields for generic reference variables
public class Pair<Y, N>{
    //the two private generic reference variable data types
    private Y key;
    private N value;

    //pair constructor method, with inputs key, and value
    public Pair(Y key, N value){
        this.key = key;
        this.value = value;
    }

    public Pair(){} //empty constructor

    //setter for key
    public void setKey(Y key){
        this.key = key;
    }

    //setter for value
    public void setValue(N value) { this.value = value;}

    //getter for key
    public Y getKey(){
        return key;
    }

    //getter for value
    public N getValue(){
        return value;
    }

    //override tostring method with requested format
    @Override
    public String toString() {
        return String.format("[YR: " + key + ", NM: " + value + "]");
    }
}
