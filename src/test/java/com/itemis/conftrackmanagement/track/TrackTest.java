package com.itemis.conftrackmanagement.track;

import com.itemis.conftrackmanagement.Utils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mouad Douieb
 */
public class TrackTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    public TrackTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setFilename method, of class Track.
     */
    @Test
    public void testinputOutput() {
        Track track = new Track();
        track.setFilename("./src/test/java/com/itemis/conftrackmanagement/track/input.txt");
        
        track.startConference();
        String expectedOutput = Utils.readOutputFile("./src/test/java/com/itemis/conftrackmanagement/track/output.txt");

        assertEquals(expectedOutput.replaceAll("\\s", ""), track.toString().replaceAll("\\s", ""));
    }

}
