/**
 * This class contains method which extract data from objects. Used to extract data from
 * the school object and to return arrays of strings
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */
import java.util.*;

public class ExtractSchoolData {

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

    public static ArrayList<String> getStudents(ArrayList<Course> object) {
        ArrayList<String> students = new ArrayList<String>();
        String storeString = "";
        for(int i = 0; i < object.size(); i++) {
            try {
                System.out.println(object.get(i).getStudents().length);
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
}