/**
 * A collection of random functions, returning random numbers, assessing whether an event happens
 * based on a given probability and generating random data for people
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

/** Imports Math library */
import java.util.*;

public class RandomGenerator {

    /**
     * Arrays containing static data (names) which will be used in the generation of names for students
     * */
    private static String[] firstNames = {"Boris", "Donald", "Vladimir", "Xi", "Angela", "Emanuel", "Boyko", "Shinzo"};
    private static String[] lastNames = {"Johnson", "Trump", "Putin", "Jingpin", "Merkel", "Macron", "Borisov", "Abe"};

    /**
     * Generates a random name for a student. It randomly selects a first name, a surname and whether the 'Mc'
     * prefix will be used. Returns the generated name
     * @return randomly generated name
     * */
    public static String generateName() {
        String name = "";
        String first = firstNames[generateNumber(firstNames.length - 1)];
        name += first;
        if(assessRandom(0.1)) {
            name += " Mc";
        }
        else {
            name += " ";
        }
        String last = lastNames[generateNumber(lastNames.length - 1)];
        name += last;
        return name;
    }

    /**
     * Randomly selects a gender and returns it.
     * @return a letter for the gender - 'M' for male, 'F' for female
     * */
    public static char generateGender() {
        if(assessRandom(0.5)) {
            return 'M';
        }
        else {
            return 'F';
        }
    }

    /**
     * Generates a random number between minNum and maxNum, and returns it
     * @param minNum the lower bound of the range
     * @param maxNum the upper bound of the range
     * @return the randomly generated number
     * */
    public static int generateNumber(int minNum, int maxNum) {
        int numberToReturn = (int)(Math.random()*(maxNum - minNum +1) + minNum);
        return numberToReturn;
    }

    /**
     * Generates a random number between 0 and maxNum, and returns it
     * @param maxNum the upper bound of the range
     * @return the randomly generated number
     * */
    public static int generateNumber(int maxNum) {
        int numberToReturn = (int)(Math.random()*(maxNum +1));
        return numberToReturn;
    }

    /**
     * The method is used to return whether an event should happen given the probability of
     * it happening. Used mainly for deciding whether an instructor should be hired in the
     * beginning of the day
     * @param probability the probability of an event happening
     * @return true if the event should happen, false otherwise
     * */
    public static boolean assessRandom(double probability) {
        double numberToReturn = Math.random();
        if(numberToReturn <= probability) {
            return true;
        }
        else {
            return false;
        }
    }
}