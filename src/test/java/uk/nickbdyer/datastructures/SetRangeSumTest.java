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
        SetRangeSum rangeSum = new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        rangeSum.solve();
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
        SetRangeSum rangeSum = new SetRangeSum(new InputStreamReader(inContent), new PrintStream(outContent));
        rangeSum.solve();
        assertEquals("Not found\n" +
                     "Found\n" +
                     "Not found\n", outContent.toString());
    }
}
