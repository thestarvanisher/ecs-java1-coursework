/**
 * This class represents the School in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

import java.util.*;

public class School {

    /**
     * Properties of the school - the name, list of enrolled students, list of subjects, list of courses and
     * a list of instructors
     * */
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;

    /**
     * Constructs a school object and creates the ArrayLists of the parameters
     * @param name the name of the school
     * */
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<Student>();
        this.subjects = new ArrayList<Subject>();
        this.courses = new ArrayList<Course>();
        this.instructors = new ArrayList<Instructor>();
    }

    /**
     * Adds a student to the school
     * @param student the student to add
     * */
    public void add(Student student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the school
     * @param student the student to remove
     * */
    public void remove(Student student) {
        this.students.remove(student);
    }

    /**
     * Adds a subject to the school
     * @param subject the subject to add
     * */
    public void add(Subject subject) {
        this.subjects.add(subject);
    }

    /**
     * Removes a subject from the school
     * @param subject the subject to remove
     * */
    public void remove(Subject subject) {
        this.subjects.remove(subject);
    }

    /**
     * Adds a course to the school
     * @param course the course to add
     * */
    public void add(Course course) {
        this.courses.add(course);
    }

    /**
     * Remove a course from the school
     * @param course the course to remove
     * */
    public void remove(Course course) {
        this.courses.remove(course);
    }

    /**
     * Adds an instructor to the school
     * @param instructor the instructor to add
     * */
    public void add(Instructor instructor) {
        this.instructors.add(instructor);
    }

    /**
     * Removes an instructor from the school
     * @param instructor the instructor to remove
     * */
    public void remove(Instructor instructor) {
        this.instructors.remove(instructor);
    }

    /**
     * Changes the name of the school
     * @param name the new name of the school
     * */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Returns an array of the students in the shcool
     * @return array of the students in the school
     * */
    public Student[] getStudents() {
        Student[] studentsToReturn = new Student[this.students.size()];
        for(int i = 0; i < this.students.size(); i++) {
            studentsToReturn[i] = this.students.get(i);
        }
        return studentsToReturn;
    }

    /**
     * Returns an array of the subjects in the shcool
     * @return array of the subjects in the school
     * */
    public Subject[] getSubjects() {
        Subject[] subjectsToReturn = new Subject[this.subjects.size()];
        for(int i = 0; i < this.subjects.size(); i++) {
            subjectsToReturn[i] = this.subjects.get(i);
        }
        return subjectsToReturn;
    }

    /**
     * Returns an array of the courses in the shcool
     * @return array of the courses in the school
     * */
    public Course[] getCourses() {
        Course[] coursesToReturn = new Course[this.courses.size()];
        for(int i = 0; i < this.courses.size(); i++) {
            coursesToReturn[i] = this.courses.get(i);
        }
        return coursesToReturn;
    }

    /**
     * Returns an array of the instructors in the shcool
     * @return array of the instructors in the school
     * */
    public Instructor[] getInstructors() {
        Instructor[] instructorsToReturn = new Instructor[this.instructors.size()];
        for(int i = 0; i < this.instructors.size(); i++) {
            instructorsToReturn[i] = this.instructors.get(i);
        }
        return instructorsToReturn;
    }

    /**
     * The method returns a 'pretty' string, containig information about the students, the instructors, the courses
     * and the subjects in the school. To do that, methods from the {@link ExtractSchoolData ExtractSchoolData}
     * and {@link PrettyOutput PrettyOutput} classes are used
     * @return the desired 'pretty' string
     * */
    public String toString() {

        String stringToReturn = "";

        stringToReturn += PrettyOutput.createTitleOutput(this.name);
        stringToReturn += "\n";

        String[] studentHeaders = {"Name", "Gender", "Age", "Certificates"};
        stringToReturn += PrettyOutput.createOutput("Students", studentHeaders, ExtractSchoolData.getNames(this.students),
                ExtractSchoolData.getGenders(students), ExtractSchoolData.getAges(students),
                ExtractSchoolData.getStudentsCertificates(students));

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

    /**
     *Runs a day at school. Creates new courses and assigns people and instructors to it. Removes cancelled and finished
     * courses.
     * */
    public void aDayAtSchool() {

        /** Creates object for subjects open for registry */
        for(int i = 0; i < this.subjects.size(); i++) {
            if(subjects.get(i).isOpenForRegistry() == true) {
                this.add(new Course(subjects.get(i), 2));
            }
        }

        /**
         * Assigns students and instructors to the courses. The methods doesn't use any algorithm
         * it simply assigns the first available student and instructor to the first course in the list
         * */
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getStatus() < 0) {
                while(courses.get(i).getSize() < 3) {
                    int currentSize = courses.get(i).getSize();
                    for(int j = 0; j < students.size(); j++) {
                        if(students.get(j).checkHasCourse() == false && students.get(j).hasCertificate(courses.get(i).getSubject()) == false) {
                            //System.out.println("Enrolling " + students.get(j).getName() + " to course " + courses.get(i).getSubject().getID());
                            courses.get(i).enrolStudent(students.get(j));
                            break;
                        }
                    }
                    if(currentSize == courses.get(i).getSize()) {
                        break;
                    }
                }
                if(courses.get(i).hasInstructor() == false) {
                    for(int j = 0; j < instructors.size(); j++) {
                        if(instructors.get(j).getAssignedCourse() == null && instructors.get(j).canTeach(courses.get(i).getSubject())) {
                            courses.get(i).setInstructor(instructors.get(j));
                            break;
                        }
                    }
                }
            }
            courses.get(i).aDayPasses();
        }

        /** Removes cancelled and finished courses */
        ArrayList<Course> coursesToRemove = new ArrayList<Course>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getStatus() == 0 || courses.get(i).isCancelled() == true) {
                coursesToRemove.add(courses.get(i));
            }
        }
        courses.removeAll(coursesToRemove);
    }
}