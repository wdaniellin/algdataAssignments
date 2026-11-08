package L4Q2;
import java.util.Comparator;
//class thats made to compare first names in ascending order
public class HelperClassCompareFirstNames implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        return (s1.getFirstName().compareTo(s2.getFirstName()));

        //or write it out manually, but compareTo sorts in ascending order by default anyway
    }
}
