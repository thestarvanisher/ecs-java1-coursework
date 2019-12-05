/**
 * This class represents the Student in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

/** Imports ArrayList */
import java.util.*;

public class Student extends Person {

    /**
     * The parameter for the student is an ArrayList, containing the certificates of the student
     * */
    private ArrayList<Integer> certificates;
    private boolean hasCourse = false;
    private Course course;
    /**
     * Constructs a Student object with given name, gender and age. Creates the certificates list
     * and sets the hasCourse flag
     * @param name the name of the student
     * @param gender the gender of the student
     * @param age the age of the student
     * */
    public Student(String name, char gender, int age) {
        super(name, gender, age);
        this.certificates = new ArrayList<Integer>();
        this.hasCourse = false;
    }

    /**
     * Adds a certificate of a provided subject to the collection of certificates of the student
     * @param subject the subject which the student graduates from
     * */
    public void graduate(Subject subject) {
        this.certificates.add(subject.getID());
    }

    /**
     * Returns the certificates of the student of the subjects he has graduated from
     * @return the certificates of the student
     * */
    public ArrayList<Integer> getCertificates() {
        return this.certificates;
    }

    /**
     * Checks if the student has has a certain certificate for a certain subject
     * @param a subject to check
     * @return true if the student has a certificate for this subject, false otherwise
     * */
    public boolean hasCertificate(Subject subject) {
        if(this.certificates.contains(subject.getID())) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Toggles the stuent hasCourse flag. Used to change the status whether the student is
     * on course or not
     * */
    public void toggleCourse(Course course) {
        this.hasCourse = !this.hasCourse;
        if(this.checkHasCourse()) {
            this.course = course;
        }
        else {
            this.course = null;
        }
    }

    /**
     * Checks if the students has course assigned to him
     * @return true if he does, false otherwise
     * */
    public boolean checkHasCourse() {
        return this.hasCourse;
    }
}