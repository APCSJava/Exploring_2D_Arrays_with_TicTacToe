import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Tests {

    private final PrintStream originalOut = System.out;
    private final InputStream originalInput = System.in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String inputFile; // parameterized inputs for System.in
    private String outputFile; // parameterized expected outputs for each case

    public Tests(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Parameterized.Parameters(name = "using {0}")
    public static Iterable<Object[]> dummyMethodName() {
        return Arrays.asList(new Object[][]{
                {"test/input_sample.txt", "test/output_sample.txt"},
                {"test/input_hidden.txt", "test/output_hidden.txt"}
        });
    }

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
    public void byteArraySameAllowingInternalNewlines() throws IOException {
        final FileInputStream fips = new FileInputStream(inputFile);
        System.setIn(fips);
        Runner.main(new String[]{});
        byte[] actual = outContent.toByteArray();
        if (actual.length == 0) Assert.fail("No incoming bytes available.");
        byte[] expected = Files.readAllBytes(Paths.get(outputFile));
        byte n = (byte) 10;
        int i = 0, j = 0;
        while (i < actual.length && actual[i] == n) i++; // advance over initial empty lines
        while (j < expected.length && expected[j] == n) j++;
        while (true) {
            if (i == actual.length) i--;
            if (j == expected.length) j--;
            if (actual[i] != expected[j]) {
                String e = String.format("Mismatched characters at position [%d]", i);
                int actualFrom = Math.max(0, i - 30);
                int actualTo = Math.min(actual.length, actualFrom + 60);
                int expectedFrom = Math.max(0, j - 30);
                int expectedTo = Math.min(expected.length, expectedFrom + 60);
                String actualString = new String(actual, actualFrom, actualTo - actualFrom);
                String expectedString = new String(expected, expectedFrom, expectedTo - expectedFrom);
                assertEquals(e, expectedString, actualString);
            }
            while (i < actual.length - 1 && actual[i + 1] == n) i++;
            while (j < expected.length - 1 && expected[j + 1] == n) j++;
            i++;
            j++;
            if (i == actual.length && j == expected.length) break;
            if (i == actual.length && j < expected.length) i--;
            if (j == expected.length && i < actual.length) j--;
        }
        fips.close();
    }
}