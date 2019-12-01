/**
 * The class represents a GUI trainer
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class GUITrainer extends Teacher {

    /**
     * Constructs an GUITrainer object with a given name, gender and age
     * @param name the name of the GUI trainer
     * @param gender the gender of the GUI trainer
     * @param age the age of the GUI trainer
     * */
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Checks if a given subject can be taught by the GUI trainer
     * @return true if the GUI trainer can teach the subject, false otherwise
     * */
    public boolean canTeach(Subject subject) {
        if(subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 4) {
            return true;
        }
        else {
            return false;
        }
    }
}