package L4Q2;
//student class that contains first/last name and a score to be used for comparisons
public class Student implements Comparable <Student>{
    private String firstName, lastName;
    private Double score;

    //default parameterless constructor with my own name, random score
    public Student(){
        this.firstName = "Daniel";
        this.lastName = "Lin";
        this.score = 84.9;
    }
    //parameter constructor with first/last name and score
    public Student(String firstName, String lastName, Double score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    //getters and setters. . . (self explanatory)
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Double getScore() {return score;}

    //setters. . .
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setScore(Double score) {this.score = score;}

    //overridden to-string method with specified format
    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, score);
    }

    //overridden compareTo method (inherited from implementing comparator)
    //sorts in DESCENDING ORDER
    @Override
    public int compareTo(Student s) {
        //sort in descending order
        if(this.score < s.score){
            return 1;
        }
        else if(this.score > s.score){
            return -1;
        }
        return 0;
        //or use default doubleCompareTo method lol (will sort in this format automatically)
    }
}
