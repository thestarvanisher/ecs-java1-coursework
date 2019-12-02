/**
 * This static class contains methods for maniipulating data a method to create a
 * good looking string which will be used for output
 * @author Ivalin Chobanov <ilc1u19@soton.ac.uk>
 * */

import java.util.*;

public class PrettyOutput {

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

    public static String createTitleOutput(String schoolName) {
        String stringToReturn = "";
        stringToReturn += createFilledString(0, schoolName.length(), "*", false) + "\n";
        stringToReturn += schoolName + "\n";
        stringToReturn += createFilledString(0, schoolName.length(), "*", false) + "\n";
        return stringToReturn;
    }
}