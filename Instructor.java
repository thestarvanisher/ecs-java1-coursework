/**
 * The abstract class models the various types if instructors
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public abstract class Instructor extends Person {

    /** The assigned course to this instructor */
    private Course assignedCourse;

    /**
     * Constructs the object with a given, gender and age
     * @param name the name of the instructor
     * @param gender the gender of the instructor
     * @param age the age of the instructor
     * */
    public Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Assigns a course to the instructor
     * @param course the course to assign
     * */
    public void assignCourse(Course course) {
        this.assignedCourse = course;
    }

    /**
     * Unassigns the assigned course of the instructor
     * */
    public void unassignCourse() {
        this.assignedCourse = null;
    }

    /**
     * Returns the assigned course to the instructor
     * @return the assigned course
     * */
    public Course getAssignedCourse() {
        return this.assignedCourse;
    }

    /**
     * A method blueprint for the different type of instructors. They all
     * must implement it
     * @param subject to check if the instructor can teach it
     * @return true if the instructor can teach the subject, false otherwise
     * */
    public abstract boolean canTeach(Subject subject);
}