package com.itemis.conftrackmanagement.track;

import com.itemis.conftrackmanagement.talk.Talk;
import com.itemis.conftrackmanagement.talk.TalkRegexParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mouad Douieb
 */
public class Track {

    private static TalkRegexParser parser;

    private static TrackDayBuilder sessionBuilder;
    
    private ArrayList<Talk> talks = new ArrayList<Talk>();


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

        this.parser = new TalkRegexParser();
        this.sessionBuilder = new TrackDayBuilder();
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
                    System.out.println(line);
                    Talk talk = Track.parser.parse(line);
                    // Check returned talk
                    talks.add(talk);
                }

            }

            

            sc.close();
        } catch (NumberFormatException | FileNotFoundException ex) {
        }

    }
    
    @Override
    public String toString() {
        
        String output = new String();
        
        int i = 0;
        for (TrackDay trackDay : sessionBuilder.build(talks)) {
            
            output += trackDay;

        }
        
        return output;
    }
    
    public void printProg() {
        System.out.println(this);
    }
}
