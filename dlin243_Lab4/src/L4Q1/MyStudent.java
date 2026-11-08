package L4Q1;
//MyStudent class that contains a string (first name) and a double (score), used as the reference variable
//type for the doublylinkedlist in the assignment
public class MyStudent {
    private String firstName;
    private Double score;

    //default constructor (my name plus random score)
    public MyStudent(){
        firstName = "Daniel";
        score = 84.9;
    }

    //constructor with parameters
    public MyStudent(String firstName, Double score){
        this.firstName = firstName;
        this.score = score;
    }

    //toString method overriden with format as specified
    @Override
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }
}
