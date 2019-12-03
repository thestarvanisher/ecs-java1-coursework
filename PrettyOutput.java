/**
 * This class contains methods for maniipulating data a method to create a
 * good looking string which will be used for output
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

import java.util.*;

public class PrettyOutput {

    /**
     * The method takes the data and uses it to create a segment for the output. It uses a structure
     * of a title, and a table, containing a header and a body
     * @param title the title of the segment
     * @param headers the headers for the table
     * @param content ArrayLists of strings that contain the data by columns
     * @return a string containing formatted (pretty) output
     * */
    public static String createOutput(String title, String[] headers, ArrayList<String>... content) {

        ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> maxWidths = new ArrayList<Integer>();
        String stringToReturn = "";

        for (int i = 0; i < headers.length; i++) {
            columns.add(new ArrayList<String>());
            columns.get(i).add(headers[i]);
            maxWidths.add(headers[i].length());
            for(int j = 0; j < content[i].size(); j++) {
                columns.get(i).add(content[i].get(j));
                if(content[i].get(j).length() > maxWidths.get(i)) {
                    maxWidths.set(i, content[i].get(j).length());
                }
            }
        }

        stringToReturn = title + "\n" + createFilledString(0, title.length(), "*", true);
        stringToReturn += "\n";

        String firstLine = "";

        for(int j = 0; j < columns.size(); j++) {
            firstLine += columns.get(j).get(0) +
                    createFilledString(columns.get(j).get(0).length(), maxWidths.get(j), " ", true);
        }

        stringToReturn += firstLine;
        stringToReturn += "\n";
        stringToReturn += createFilledString(0, firstLine.length() - 1, "_", false);
        stringToReturn += "\n";

        for(int i = 1; i < columns.get(0).size(); i++) {
            for(int j = 0; j < columns.size(); j++) {
                stringToReturn += columns.get(j).get(i) +
                        createFilledString(columns.get(j).get(i).length(), maxWidths.get(j), " ", true);
            }
            stringToReturn += "\n";
        }

        stringToReturn += "\n";

    return stringToReturn;
    }

    /**
     * The method creates a string with a given length that contains onlu a given character. It is used mainly for
     * creating empty spaces, but also for creating lines of a single element - division lines
     * @param elementWidth the width of the already taken space by an element
     * @param maxWidth the maximum width of the space that a such element takes (the column in a table)
     * @param fillElement a String containing the element which will be used for filling the empty space
     * @param additional a parameter which is used to determine if additionally 2 characters will be used after the
     *                   space is taken. This is used for creating more blank space for more pretty table
     * @return the newly created string
     * */
    private static String createFilledString(int elementWidth, int maxWidth, String fillElement, boolean additional) {

        String stringToReturn = "";
        for(int i = 0; i < maxWidth - elementWidth; i++) {
            stringToReturn += fillElement;
        }

        if(additional == true) {
            stringToReturn += fillElement + fillElement;
        }

        return stringToReturn;
    }

    /**
     * This method creates a title for the whole output that contains the name of the school
     * @param schoolName the name of the school
     * @return a string containing the formatted output
     * */
    public static String createTitleOutput(String schoolName) {

        String stringToReturn = "";
        stringToReturn += createFilledString(0, schoolName.length(), "*", false) + "\n";
        stringToReturn += schoolName + "\n";
        stringToReturn += createFilledString(0, schoolName.length(), "*", false) + "\n";

        return stringToReturn;
    }
}