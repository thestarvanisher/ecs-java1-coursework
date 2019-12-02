
public class Main {


    public static void main(String[] args) {


        Subject subject1 = new Subject(1, 2, 3);
        Subject subject2 = new Subject(2, 3, 4);
        Subject subject3 = new Subject(3, 4, 5);
        Subject subject4 = new Subject(4, 1, 6);
        Course course1 = new Course(subject1, 2);
        Course course2 = new Course(subject2, 3);
        Student student1 = new Student("Alice", 'F', 25);
        Student student2 = new Student("Bob", 'M', 30);
        Student student3 = new Student("Charlie Sheen", 'M', 35);
        Student student4 = new Student("Donna", 'F', 40);
        Teacher teacher1 = new Teacher("Teacher1", 'F', 25);
        Demonstrator demonstrator1 = new Demonstrator("Demonstrator1", 'F', 25);
        OOTrainer ootrainer1 = new OOTrainer("OOTrainer1", 'F', 25);
        GUITrainer guitrainer1 = new GUITrainer("GUITrainer1", 'F', 25);

        School school = new School("Bond school of London");



        course1.enrolStudent(student1);
        course1.enrolStudent(student2);
        //course1.aDayPasses();
        //System.out.println(course1.isCancelled());
        //course1.aDayPasses();

        //System.out.println(course1.isCancelled());

        course1.setInstructor(demonstrator1);


        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);
        school.add(subject1);
        school.add(subject2);
        school.add(subject3);
        school.add(subject4);
        school.add(teacher1);
        school.add(demonstrator1);
        school.add(ootrainer1);
        school.add(guitrainer1);
        //course1.enrolStudent(student1);
        school.add(course1);


        System.out.println(school.toString());
    }
}