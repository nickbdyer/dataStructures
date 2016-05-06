package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class JobQueueTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void makesJobQueue() throws IOException {
        inContent = new ByteArrayInputStream("2 5\n1 2 3 4 5".getBytes());
        JobQueue jobQueue = new JobQueue();
        jobQueue.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("0 0\n1 0\n0 1\n1 2\n0 4\n", outContent.toString());
    }
}
