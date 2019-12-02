/**
 * This class represents the School in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

import java.util.*;

public class School {

    private String name;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<Student>();
        this.subjects = new ArrayList<Subject>();
        this.courses = new ArrayList<Course>();
        this.instructors = new ArrayList<Instructor>();
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public void remove(Student student) {
        this.students.remove(student);
    }

    public void add(Subject subject) {
        this.subjects.add(subject);
    }

    public void remove(Subject subject) {
        this.subjects.remove(subject);
    }

    public void add(Course course) {
        this.courses.add(course);
    }

    public void remove(Course course) {
        this.courses.remove(course);
    }

    public void add(Instructor instructor) {
        this.instructors.add(instructor);
    }

    public void remove(Instructor instructor) {
        this.instructors.remove(instructor);
    }

    public Student[] getStudents() {
        Student[] studentsToReturn = new Student[this.students.size()];
        for(int i = 0; i < this.students.size(); i++) {
            studentsToReturn[i] = this.students.get(i);
        }
        return studentsToReturn;
    }

    public Subject[] getSubjects() {
        Subject[] subjectsToReturn = new Subject[this.subjects.size()];
        for(int i = 0; i < this.subjects.size(); i++) {
            subjectsToReturn[i] = this.subjects.get(i);
        }
        return subjectsToReturn;
    }

    public Course[] getCourses() {
        Course[] coursesToReturn = new Course[this.courses.size()];
        for(int i = 0; i < this.courses.size(); i++) {
            coursesToReturn[i] = this.courses.get(i);
        }
        return coursesToReturn;
    }

    public Instructor[] getInstructors() {
        Instructor[] instructorsToReturn = new Instructor[this.instructors.size()];
        for(int i = 0; i < this.instructors.size(); i++) {
            instructorsToReturn[i] = this.instructors.get(i);
        }
        return instructorsToReturn;
    }

    public String toString() {

        String stringToReturn = "";

        stringToReturn += PrettyOutput.createTitleOutput(this.name);
        stringToReturn += "\n";

        String[] studentHeaders = {"Name", "Gender", "Age"};
        stringToReturn += PrettyOutput.createOutput("Students", studentHeaders, ExtractSchoolData.getNames(this.students),
                ExtractSchoolData.getGenders(students), ExtractSchoolData.getAges(students));


        String[] subjectHeaders = {"ID", "Description", "Duration"};
        stringToReturn += PrettyOutput.createOutput("Subjects", subjectHeaders, ExtractSchoolData.getSubjectID(subjects),
                ExtractSchoolData.getDescriptions(subjects), ExtractSchoolData.getDurations(subjects));

        String[] instructorHeaders = {"Name", "Gender", "Age", "Teaches Subject ID"};
        stringToReturn += PrettyOutput.createOutput("Instructors", instructorHeaders, ExtractSchoolData.getNames(instructors),
                ExtractSchoolData.getGenders(instructors), ExtractSchoolData.getAges(instructors),
                ExtractSchoolData.getInstructorSubjectID(instructors));

        String[] courseHeaders = {"Subject ID", "Instructor's Name", "Status", "Enrolled Students", "Cancelled"};
        stringToReturn += PrettyOutput.createOutput("Courses", courseHeaders, ExtractSchoolData.getCourseSubjectID(courses),
                ExtractSchoolData.getInstructorsNames(courses), ExtractSchoolData.getStatus(courses),
                ExtractSchoolData.getStudents(courses), ExtractSchoolData.getCancellStatus(courses));


        return stringToReturn;
    }
}