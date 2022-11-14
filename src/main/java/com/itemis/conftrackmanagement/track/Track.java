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
            ArrayList<Talk> talks = new ArrayList<Talk>();

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

            sessionBuilder.build(talks).forEach((trackDay) -> {
                System.out.println(trackDay);
            });

            sc.close();
        } catch (NumberFormatException | FileNotFoundException ex) {
        }

    }
}
