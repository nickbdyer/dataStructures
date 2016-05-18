package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class SetRangeSumTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void processes15Inputs() throws IOException {
        String input = "15\n" +
                       "? 1\n" +
                       "+ 1\n" +
                       "? 1\n" +
                       "+ 2\n" +
                       "s 1 2\n" +
                       "+ 1000000000\n" +
                       "? 1000000000\n" +
                       "- 1000000000\n" +
                       "? 1000000000\n" +
                       "s 999999999 1000000000\n" +
                       "- 2\n" +
                       "? 2\n" +
                       "- 0\n" +
                       "+ 9\n" +
                       "s 0 9\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Not found\n" +
                     "Found\n" +
                     "3\n" +
                     "Found\n" +
                     "Not found\n" +
                     "1\n" +
                     "Not found\n" +
                     "10\n", outContent.toString());
    }

    @Test
    public void processes5Inputs() throws IOException {
        String input = "5\n" +
                       "? 0\n" +
                       "+ 0\n" +
                       "? 0\n" +
                       "- 0\n" +
                       "? 0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Not found\n" +
                     "Found\n" +
                     "Not found\n", outContent.toString());
    }

    @Test
    public void processBigNumbers() throws IOException {
        String input = "5\n" +
                "+ 491572259\n" +
                "? 491572259\n" +
                "? 899375874\n" +
                "s 310971296 877523306\n" +
                "+ 352411209\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Found\n" +
                "Not found\n" +
                "491572259\n", outContent.toString());
    }

    @Test
    public void process1s() throws IOException {
        String input = "10\n" +
                "? 1\n" +
                "+ 1\n" +
                "? 1\n" +
                "+ 2\n" +
                "+ 3\n" +
                "- 1\n" +
                "+ 6\n" +
                "+ 7\n" +
                "? 2\n" +
                "? 1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Not found\n" +
                "Found\n" +
                "Found\n" +
                "Not found\n", outContent.toString());
    }

    @Test
    public void processNew() throws IOException {
        String input = "9\n+ 2\n+ 3\n+ 4\n- 3\n- 2\n- 4\n? 3\n+ 3\n? 3\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Not found\n" +
                    "Found\n", outContent.toString());
    }

    @Test
    public void random() throws IOException {
        String input = "10\n" +
                "? 1\n" +
                "+ 1\n" +
                "? 1\n" +
                "+ 2\n" +
                "+ 3\n" +
                "- 1\n" +
                "- 1\n" +
                "- 1\n" +
                "? 2\n" +
                "? 1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Not found\n" +
                "Found\n" +
                "Found\n" +
                "Not found\n", outContent.toString());
    }

    @Test
    public void zero() throws IOException {
        String input = "5\n" +
                "+ 10\n" +
                "+ 20\n" +
                "- 15\n" +
                "? 10\n" +
                "? 20\n";

        inContent = new ByteArrayInputStream(input.getBytes());
        new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Found\nFound\n", outContent.toString());
    }
}
