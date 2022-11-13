package com.itemis.conftrackmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mouad Douieb
 */
public class Track {
    
    /**
     * To read the order form file
     */
    private String filename = "";
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Track() {

    }

    public void startConference() {
        Scanner sc;

        try {
            // Scan user inputs
            if (this.filename.length() > 0) {
                File file = new File(filename);
                sc = new Scanner(file);
            } else {
                sc = new Scanner(System.in);
                System.out.println("### INPUT:");

            }

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                // Break the loop if the user entered an empty line
                if (line.isEmpty()) {
                    break;
                } else {
                    
                }

            }

            sc.close();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
        }
    }
}
