/**
 * This class represents the Course in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

/** Imports ArrayList */
import java.util.*;

public class Course {

    /**
     * A constant equal to the maximum number of students in the course
     * */
    private final int MAX_STUDENTS = 3;

    /**
     * The parameters for the course. They correspond to the subject associated with the course,
     * the number of days until the course starts, the number of days the course still has to run,
     * an ArrayList of the endrolled students in this course, the instructor of the course,
     * a flag which is true if the course is cancelled and false otherwise
     * */
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;
    private ArrayList<Student> enrolledStudents;
    private Instructor instructor;
    private boolean isCancelled;

    /**
     * Constructs a Course object with given subject and number of days until the course starts
     * and creates an array for the enroled students. Sets the isCancelled flag
     * @param subject the Subject which the course is associated with
     * @param daysUntilStarts number of days until the course starts
     * */
    public Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.subject.setNumberOfCourses(false);
        this.daysUntilStarts = daysUntilStarts;
        this.daysToRun = this.getSubject().getDuration();
        this.enrolledStudents = new ArrayList<Student>();
        this.isCancelled = false;
    }

    public Subject getSubject() {
        return this.subject;
    }

    /**
     * Returns the status of the course
     * @return  a negative number of days until the course starts (if the course has not started yet),
     *          a positive number of days to run (if the course is running),
     *          0 if the course has finished
     * */
    public int getStatus() {
        if(this.daysUntilStarts > 0) {
            return (0 - this.daysUntilStarts);
        }
        else if(this.daysToRun > 0) {
            return this.daysToRun;
        }
        else {
            return 0;
        }
    }

    /**
     * Simulates a day passing. Decrements the daysUntilStarts variable if it is positive,
     * otherwise decrements the daysToRun variable. That is done since a if the number the days
     * until the course starts is positive, then the course has not started. Once the course
     * starts the variable of number of days to run gets decremented since the course is running.
     * If the course has finished, the method {@link #issueCertificates() issueCertificates} is called to
     * issue certificates to the enrolled students.
     * If the course begins with no students or no instructor, it is cancelled and the students are
     * released (if any) and the instructor is unassigned (if any)
     * */
    public void aDayPasses() {
        if(this.daysUntilStarts > 0) {
            this.daysUntilStarts--;
            if(this.daysUntilStarts == 0) {
                if(this.getSize() == 0 || this.hasInstructor() == false) {
                    cancellCourse();
                    this.subject.setNumberOfCourses(true);
                }
            }
        }
        else {
            if(this.daysToRun == this.getSubject().getDuration() && this.isCancelled() == false) {
                this.subject.setNumberOfCourses(true);
            }
            this.daysToRun--;
            if(this.daysToRun == 0) {
                this.issueCertificates();
            }
        }
    }

    /**
     * Enrols a student to the course. If the number of students has reached the maximum or
     * the course has started the method doesn't enrol the student. also changes the students enrollment
     * status if he has been enrolled
     * @return true if enrolling the student was successful, false if it was not
     * */
    public boolean enrolStudent(Student student) {
        if(this.getSize() == MAX_STUDENTS || this.getStatus() > 0) {
            return false;
        }
        else {
            this.enrolledStudents.add(student);
            student.toggleCourse(this);
            if(this.getSize() == MAX_STUDENTS) {
                this.getSubject().setNumberOfCourses(true);
            }
            return true;
        }
    }

    /**
     * Returns the number of enrolled students in the course
     * @return the number of enrolled students
     * */
    public int getSize() {
        return this.enrolledStudents.size();
    }

    /**
     * Returns an array of the enrolled students. The method converts the ArrayList of
     * enrolled students to an array of format Student[]
     * @return an array of the enrolled students in format Student[]
     * */
    public Student[] getStudents() {
        Student[] studentsToReturn = new Student[this.getSize()];
        for(int i = 0; i < this.getSize(); i++) {
            studentsToReturn[i] = this.enrolledStudents.get(i);
        }
        return studentsToReturn;
    }

    /**
     * The method issues certificates to the enrolled students in the course
     * */
    private void issueCertificates() {
        unsetInstructor();

        for(int i=0; i < this.getSize(); i++) {
            this.enrolledStudents.get(i).graduate(this.subject);
        }
        releaseStudents();
    }

    /**
     * Sets the instructor for the course. Simultaneously sets the course for the instructor and returns whether this
     * operation was successful or not based on whether the instructor can teach this course
     * @param instructor the instructor to set
     * @return true if the operation was successful, false otherwise
     * */
    public boolean setInstructor(Instructor instructor) {
        if(instructor.canTeach(this.getSubject())) {
            this.instructor = instructor;
            instructor.assignCourse(this);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if the course has an instructor
     * @return true if the course has an instructor, false otherwise
     * */
    public boolean hasInstructor() {
        if(this.instructor == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Unsets the instructor of the course (if there was any)
     * */
    private void unsetInstructor() {
        if(this.hasInstructor()) {
            this.instructor.unassignCourse();
            this.instructor = null;
        }
    }

    /**
     * Releases the enrolled students from the course (if there were any)
     * */
    private void releaseStudents() {
        if(this.getSize() > 0) {
            for(int i = 0; i < this.enrolledStudents.size(); i++) {
                this.enrolledStudents.get(i).toggleCourse(this);
            }
            this.enrolledStudents = new ArrayList<Student>();
        }
    }

    /**
     * Cancells the course
     * */
    private void cancellCourse() {
        this.isCancelled = true;
        unsetInstructor();
        releaseStudents();
    }

    /**
     * Chechs if the course is cancelled
     * @return true if the course is cancelled, false otherwise
     * */
    public boolean isCancelled() {
        return this.isCancelled;
    }

    /**
     * Returns the instructor of the course
     * @return an object of the instructor
     * */
    public Instructor getInstructor() {
        return this.instructor;
    }
}