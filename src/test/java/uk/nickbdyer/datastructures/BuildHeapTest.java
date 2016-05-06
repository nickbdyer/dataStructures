package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BuildHeapTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void canConvertMaxHeapToMin() throws IOException {
        inContent = new ByteArrayInputStream("5\n5 4 3 2 1".getBytes());
        BuildHeap buildHeap = new BuildHeap();
        buildHeap.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("3\n1 4\n0 1\n1 3", outContent.toString());
    }

    @Test
    public void doesNotConvertMinHeap() throws IOException {
        inContent = new ByteArrayInputStream("5\n1 2 3 4 5".getBytes());
        BuildHeap buildHeap = new BuildHeap();
        buildHeap.solve(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("0\n", outContent.toString());
    }
}
