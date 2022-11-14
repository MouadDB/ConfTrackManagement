package com.itemis.conftrackmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mouad Douieb
 */
public class Utils {

    public static String readOutputFile(String fileName) {
        String output = "";
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                output += scanner.nextLine();
                output += "\n";
            }
        } catch (FileNotFoundException e) {
        }
        return output;
    }
}
