/**
 * The class related to the administrator of the school in the simulation
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

import java.util.*;
import java.io.*;

public class Administrator {

    /** The school which the administrator controls */
    private School school;

    /**
     * Constructs the administrator object
     * @param school the school object which the admin controls
     * */
    public Administrator(School school) {
        this.school = school;
    }

    /**
     * This method runs the simulation for a day
     * */
    public void run() {

        /** Creates a random number of people, between 0 and 2 */
        int numberOfNewPeople = RandomGenerator.generateNumber(2);

        /** Creates students and adds them to the school */
        for(int i = 0; i < numberOfNewPeople; i++) {
            this.school.add(new Student(RandomGenerator.generateName(), RandomGenerator.generateGender(),
                    RandomGenerator.generateNumber(17, 23)));
        }

        /** Creates instructors and adds them to the school */
        if(RandomGenerator.assessRandom(0.2)) {
            this.school.add(new Teacher(RandomGenerator.generateName(),
                    RandomGenerator.generateGender(), RandomGenerator.generateNumber(26, 65)));
        }

        if(RandomGenerator.assessRandom(0.1)) {
            this.school.add(new Demonstrator(RandomGenerator.generateName(),
                    RandomGenerator.generateGender(), RandomGenerator.generateNumber(26, 65)));
        }

        if(RandomGenerator.assessRandom(0.05)) {
            this.school.add(new OOTrainer(RandomGenerator.generateName(),
                    RandomGenerator.generateGender(), RandomGenerator.generateNumber(26, 65)));
        }

        if(RandomGenerator.assessRandom(0.05)) {
            this.school.add(new GUITrainer(RandomGenerator.generateName(),
                    RandomGenerator.generateGender(), RandomGenerator.generateNumber(26, 65)));
        }

        /** Simulates a day */
        school.aDayAtSchool();

        /** Removes the redundant instructors and students */
        for(int i = 0; i < this.school.getInstructors().length; i++) {
            if (this.school.getInstructors()[i].getAssignedCourse() == null) {
                if (RandomGenerator.assessRandom(0.2)) {
                    this.school.remove(school.getInstructors()[i]);
                }
            }
        }

        for(int i = 0; i < this.school.getStudents().length; i++) {
            if(this.school.getStudents()[i].getCertificates().size() == this.school.getSubjects().length) {
                this.school.remove(this.school.getStudents()[i]);
            }
            else if(this.school.getStudents()[i].checkHasCourse() == false) {
                if(RandomGenerator.assessRandom(0.05)) {
                    this.school.remove(this.school.getStudents()[i]);
                }
            }
        }

        System.out.println(this.school.toString());
    }

    /**
     * Runs the school for number of days
     * @param numberOfDays the number of days to run the school
     * */
    public void run(int numberOfDays) {
        for(int i = 0; i < numberOfDays; i++) {
            System.out.println("Day " + (i+1) + " of the simulation");
            this.run();
        }
    }

    /**
     * The entry point of the application
     * */
    public static void main(String[] args) {

        Administrator admin;
        School school = new School("<No name provided>");
        String fileName;

        try {
            fileName = args[0];
        }
        catch (Exception e) {
            System.out.println("No input file has been submitted, process will be terminated");
            return;
        }
        int duration;
        try {
            duration = (int)Integer.parseInt(args[1]);
        }
        catch (Exception e) {
            duration = 1;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {

                if(line.contains("school") || line.contains("School")) {
                    school.changeName(line.substring(line.indexOf(":") + 1));
                }
                else if(line.contains("Student") || line.contains("student")){
                    String[] leftAndRightSides = line.split(":");
                    String[] studentInfo = leftAndRightSides[1].split(",");
                    school.add(new Student(studentInfo[0], (char)studentInfo[1].charAt(0),
                            (int)Integer.parseInt(studentInfo[2])));
                }
                else if(line.contains("subject") || line.contains("Subject")) {
                    String[] leftAndRightSides = line.split(":");
                    String[] subjectInfo = leftAndRightSides[1].split(",");
                    school.add(new Subject((int)Integer.parseInt(subjectInfo[1]), (int)Integer.parseInt(subjectInfo[2]),
                            (int)Integer.parseInt(subjectInfo[3]), subjectInfo[0]));
                }
                else if(line.contains("Teacher")) {
                    String[] leftAndRightSides = line.split(":");
                    String[] teacherInfo = leftAndRightSides[1].split(",");
                    school.add(new Teacher(teacherInfo[0], (char)teacherInfo[1].charAt(0),
                            (int)Integer.parseInt(teacherInfo[2])));
                }
                else if(line.contains("Demonstrator")) {
                    String[] leftAndRightSides = line.split(":");
                    String[] demonstratorInfo = leftAndRightSides[1].split(",");
                    school.add(new Demonstrator(demonstratorInfo[0], (char)demonstratorInfo[1].charAt(0),
                            (int)Integer.parseInt(demonstratorInfo[2])));
                }
                else if(line.contains("OOTrainer")) {
                    String[] leftAndRightSides = line.split(":");
                    String[] trainerInfo = leftAndRightSides[1].split(",");
                    school.add(new OOTrainer(trainerInfo[0], (char)trainerInfo[1].charAt(0),
                            (int)Integer.parseInt(trainerInfo[2])));
                }
                else if(line.contains("GUITrainer")) {
                    String[] leftAndRightSides = line.split(":");
                    String[] trainerInfo = leftAndRightSides[1].split(",");
                    school.add(new GUITrainer(trainerInfo[0], (char)trainerInfo[1].charAt(0),
                            (int)Integer.parseInt(trainerInfo[2])));
                }
                else {
                    System.out.println("The file format is invalid, the execution is terminated!");
                    return;
                }
            }
            admin = new Administrator(school);

            admin.run(duration);
        }
        catch (IOException e) {
            System.out.println("Cannot read the file provided!");
        }


    }
}