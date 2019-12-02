/**
 * This class represents the Subject in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class Subject {

    /**
     * The properties of the Subject. They correspond to the ID,
     * the Specialism ID, the duration and the description of the subject
     * */
    private int id;
    private int specialism;
    private int duration;
    private String description;

    /**
     * Constructs an object with the following 4 parameters when provided:
     * @param id The unique ID of the Subject
     * @param specialism The specialism ID of the subject
     * @param duration The duration (number of days) needed for a course to cover this subject
     * @param description The description of the subject
     * */
    public Subject(int id, int specialism, int duration, String description) {
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
        this.description = description;
    }

    /**
     * Constructs an object with the following 3 parameters when provided:
     * @param id The unique ID of the Subject
     * @param specialism The specialism ID of the subject
     * @param duration The duration (number of days) required for a course to cover the subject
     * */
    public Subject(int id, int specialism, int duration) {
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
        this.description = "";
    }

    /**
     * Returns the ID of the subject
     * @return the ID of the subject
     * */
    public int getID() {
        return this.id;
    }

    /**
     * Returns the specialism ID of the subject
     * @return the specialism ID
     * */
    public int getSpecialism() {
        return this.specialism;
    }

    /**
     * Returns the duration (number of days) required for a course to cover the subject
     * @return the duration (number of days)
     * */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Returns the description of the subject
     * @return the description
     * */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the subject
     * @param description Description of the subject
     * */
    public void setDescription(String description) {
        this.description = description;
    }
}