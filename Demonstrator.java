/**
 * The class represents a demonstrator
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class Demonstrator extends Instructor {

    /**
     * Constructs a Demonstrator object with a given name, gender and age
     * @param name the name of the demonstrator
     * @param gender the gender of the demonstrator
     * @param age the age of the demonstrator
     * */
    public Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Checks if a given subject can be taught by the demonstrator
     * @return true if the demonstrator can teach the subject, false otherwise
     * */
    public boolean canTeach(Subject subject) {
        if(subject.getSpecialism() == 2) {
            return true;
        }
        else {
            return false;
        }
    }
}