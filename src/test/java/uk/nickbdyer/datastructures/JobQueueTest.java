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
    public void makes5JobQueue() throws IOException {
        inContent = new ByteArrayInputStream("2 5\n1 2 3 4 5".getBytes());
        JobQueue jobQueue = new JobQueue();
        jobQueue.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("0 0\n1 0\n0 1\n1 2\n0 4\n", outContent.toString());
    }

    @Test
    public void makes20JobQueue() throws IOException {
        inContent = new ByteArrayInputStream("4 20\n1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1".getBytes());
        JobQueue jobQueue = new JobQueue();
        jobQueue.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("0 0\n1 0\n2 0\n3 0\n0 1\n1 1\n2 1\n3 1\n0 2\n1 2\n2 2\n3 2\n0 3\n1 3\n2 3\n3 3\n0 4\n1 4\n2 4\n3 4\n", outContent.toString());
    }

}
