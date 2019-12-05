/**
 * This class contains method which extract data from objects. Used to extract data from
 * the school and return arrays of strings containing the desired data
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */
import java.util.*;

public class ExtractSchoolData {

    /**
     * The method returns an ArrayList of strings of the names of given objects. The objects allowed are
     * all, the class of which extends the Person class.
     * @param object an ArrayList of objects - the name of which must be found
     * @return an ArrayList of type String - the desired names
     * */
    public static ArrayList<String> getNames(ArrayList<? extends Person> object) {
        ArrayList<String> names = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getName());
            }
            catch (Exception e) {
                storeString = "";
            }
            names.add(storeString);
        }
        return names;
    }

    /**
     * The method returns an ArrayList of strings of the genders of given objects. The objects allowed are
     * all, the class of which extends the Person class.
     * @param object an ArrayList of objects - the gemders of which must be found
     * @return an ArrayList of type String - the desired genders
     * */
    public static ArrayList<String> getGenders(ArrayList<? extends Person> object) {
        ArrayList<String> genders = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getGender());
            }
            catch (Exception e) {
                storeString = "";
            }
            genders.add(storeString);
        }
        return genders;
    }

    /**
     * The method returns an ArrayList of string of the ages of given objects. The objects allowed are
     * all, the class of which extends the Person class.
     * @param object an ArrayList of objects - the ages of which must be found
     * @return an ArrayList of type String - the desired ages
     * */
    public static ArrayList<String> getAges(ArrayList<? extends Person> object) {
        ArrayList<String> ages = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getAge());
            }
            catch (Exception e) {
                storeString = "";
            }
            ages.add(storeString);
        }
        return ages;
    }

    /**
     * The method returns an ArrayList of strings of the IDs of subjects provided.
     * @param object an ArrayList of subjects - the IDs of which must be found
     * @return an ArrayList of type String - the desired IDs
     * */
    public static ArrayList<String> getSubjectID(ArrayList<Subject> object) {
        ArrayList<String> ids = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getID());
            }
            catch (Exception e) {
                storeString = "";
            }
            ids.add(storeString);
        }
        return ids;
    }

    /**
     * The method returns an ArrayList of strings of the IDs of subjects which are related
     * to a course provided
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired IDs
     * */
    public static ArrayList<String> getCourseSubjectID(ArrayList<Course> object) {
        ArrayList<String> ids = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getSubject().getID());
            }
            catch (Exception e) {
                storeString = "";
            }
            ids.add(storeString);
        }
        return ids;
    }

    /**
     * The method returns an ArrayList of strings of the IDs of subjects which are related
     * to an instructor provided
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired IDs
     * */
    public static ArrayList<String> getInstructorSubjectID(ArrayList<Instructor> object) {
        ArrayList<String> ids = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getAssignedCourse().getSubject().getID());
            }
            catch (Exception e) {
                storeString = "";
            }
            ids.add(storeString);
        }
        return ids;
    }

    /**
     * The method returns an ArrayList of descriptions of subjects provided
     * @param object an ArrayList of subjects
     * @return an ArrayList of type String - the desired descriptions
     * */
    public static ArrayList<String> getDescriptions(ArrayList<Subject> object) {
        ArrayList<String> descriptions = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getDescription());
            }
            catch (Exception e) {
                storeString = "";
            }
            descriptions.add(storeString);
        }
        return descriptions;
    }

    /**
     * The method returns an ArrayList of durations of subjects provided
     * @param object an ArrayList of subjects
     * @return an ArrayList of type String - the desired durations
     * */
    public static ArrayList<String> getDurations(ArrayList<Subject> object) {
        ArrayList<String> durations = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getDuration());
            }
            catch (Exception e) {
                storeString = "";
            }
            durations.add(storeString);
        }
        return durations;
    }

    /**
     * The method returns an ArrayList of strings, containing the names of students (separated by commas) who are
     * enrolled to a course provided
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired names of students
     * */
    public static ArrayList<String> getStudents(ArrayList<Course> object) {
        ArrayList<String> students = new ArrayList<String>();
        String storeString = "";
        for(int i = 0; i < object.size(); i++) {
            storeString = "";
            try {
                for(int j = 0; j < object.get(i).getStudents().length; j++) {
                    storeString += object.get(i).getStudents()[j].getName();
                    if(j!= object.get(i).getStudents().length - 1) {
                        storeString += ", ";
                    }
                }
            }
            catch (Exception e) {

                storeString = "";
            }
            students.add(storeString);
        }
        return students;
    }

    /**
     * The method returns an ArrayList of the names of instructors who are
     * teachong a course provided
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired names of insructors
     * */
    public static ArrayList<String> getInstructorsNames(ArrayList<Course> object) {
        ArrayList<String> names = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                storeString = String.valueOf(object.get(i).getInstructor().getName());
            }
            catch (Exception e) {
                storeString = "";
            }
            names.add(storeString);
        }
        return names;
    }

    /**
     * The method returns an ArrayList of the status of courses provided. The status gives information about
     * number of days remaining till the beginning, number of days till the end of the course or whether the course
     * has finished
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired status
     * */
    public static ArrayList<String> getStatus(ArrayList<Course> object) {
        ArrayList<String> days = new ArrayList<String>();
        String storeString;
        for(int i = 0; i < object.size(); i++) {
            try {
                int status = object.get(i).getStatus();
                if(status < 0) {
                    status = 0 - status;
                    storeString = String.valueOf(status) + " days till start";
                }
                else if(status > 0) {
                    storeString = String.valueOf(status) + " days till the end";
                }
                else {
                    storeString = "Course has finished";
                }
            }
            catch (Exception e) {
                storeString = "";
            }
            days.add(storeString);
        }
        return days;
    }

    /**
     * The method returns an ArrayList of the cancell status of courses provided. The string is
     * 'Yes' if the course has been cancelled, 'No' otherwise
     * @param object an ArrayList of courses
     * @return an ArrayList of type String - the desired cancellation status
     * */
    public static ArrayList<String> getCancellStatus(ArrayList<Course> object) {
        ArrayList<String> cancelledStatus = new ArrayList<String>();
        String storeString;
        for (int i = 0; i < object.size(); i++) {
            try {
                if (object.get(i).isCancelled()) {
                    storeString = "Yes";
                } else {
                    storeString = "No";
                }
            } catch (Exception e) {
                storeString = "";
            }
            cancelledStatus.add(storeString);
        }
        return cancelledStatus;
    }

    /**
     * The method returns an ArrayList of strings, containing the certificates of students (separated by commas)
     * which the students have
     * @param object an ArrayList of students
     * @return an ArrayList of type String - the desired certificates of students
     * */
    public static ArrayList<String> getStudentsCertificates(ArrayList<Student> object) {
        ArrayList<String> studentsCertificates = new ArrayList<String>();
        String storeString = "";
        for(int i = 0; i < object.size(); i++) {
            storeString = "";
            try {
                for(int j = 0; j < object.get(i).getCertificates().size(); j++) {
                    storeString += object.get(i).getCertificates().get(j);
                    if(j!= object.get(i).getCertificates().size() - 1) {
                        storeString += ", ";
                    }
                }
            }
            catch (Exception e) {

                storeString = "";
            }
            studentsCertificates.add(storeString);
        }
        return studentsCertificates;
    }
}