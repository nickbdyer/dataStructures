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
        inContent = new ByteArrayInputStream("5\n5 4 3 2 1".getBytes());
        JobQueue jobQueue = new JobQueue();
        jobQueue.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("3\n1 4\n0 1\n1 3\n", outContent.toString());
    }
}
