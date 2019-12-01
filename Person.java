/**
 * This class represents a Person
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

public class Person {

    /**
     * The parameters for the person. They correspond to the name,
     * the gender and the age of the person
     * */
    private String name;
    private char gender;
    private int age;

    /**
     * Constructs an object with given name, gender and age of the person
     * @param name the name of the person
     * @param gender the gender of the person
     * @param age the age of the persson
     * */
    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Returns the name of the person
     * @return name of the person
     * */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the gender of the person
     * @return the gender of the person
     * */
    public char getGender() {
        return this.gender;
    }

    /**
     * Sets the age of the person
     * @param age the age of the person
     * */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the age of the person
     * @return the age of the person
     * */
    public int getAge() {
        return this.age;
    }
}