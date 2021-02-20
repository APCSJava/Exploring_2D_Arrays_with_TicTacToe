import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {

    private final PrintStream originalOut = System.out;
    private final InputStream originalInput = System.in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalInput);
    }

    @Test
    public void outputMatchesForSampleInputs() throws IOException {
        final FileInputStream fips = new FileInputStream(new File("test/input_sample.txt"));
        System.setIn(fips);
        Runner.main(new String[] {});
        String actual = outContent.toString();
        String expected = Files.readString(Paths.get("test/output_sample.txt"));
        assertEquals("Output does not match", expected, actual);

    }

    @Test
    public void outputMatchesForHiddenInputs() throws IOException {
        final FileInputStream fips = new FileInputStream(new File("test/input_hidden.txt"));
        System.setIn(fips);
        Runner.main(new String[] {});
        String actual = outContent.toString();
        String expected = Files.readString(Paths.get("test/output_hidden.txt"));
        assertEquals("Output does not match", expected, actual);

    }
}