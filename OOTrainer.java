/**
 * The class represents an object-oriented trainer
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class OOTrainer extends Teacher {

    /**
     * Constructs an OOTrainer object with a given name, gender and age
     * @param name the name of the object-oriented trainer
     * @param gender the gender of the object-oriented trainer
     * @param age the age of the object-oriented trainer
     * */
    public OOTrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Checks if a given subject can be taught by the object-oriented trainer
     * @return true if the object-oriented trainer can teach the subject, false otherwise
     * */
    public boolean canTeach(Subject subject) {
        if(subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 3) {
            return true;
        }
        else {
            return false;
        }
    }
}