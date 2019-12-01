/**
 * The class represents a teacher
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class Teacher extends Instructor {

    /**
     * Constructs a Teacher object with a given name, gender and age
     * @param name the name of the teacher
     * @param gender the gender of the teacher
     * @param age the age of the teacher
     * */
    public Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Checks if a given subject can be taught by the teacher
     * @return true if the teacher can teach the subject, false otherwise
     * */
    public boolean canTeach(Subject subject) {
        if(subject.getSpecialism() == 1 || subject.getSpecialism() == 2) {
            return true;
        }
        else {
            return false;
        }
    }
}