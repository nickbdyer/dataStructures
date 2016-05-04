package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class treeHeightTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void creates3HeightTree() throws IOException {
        inContent = new ByteArrayInputStream("5\n4 -1 4 1 1".getBytes());
        tree_height tree = new tree_height();
        tree.run(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("3\n", outContent.toString());
    }

    @Test
    public void creates4HeightTree() throws IOException {
        inContent = new ByteArrayInputStream("5\n-1 0 4 0 3".getBytes());
        tree_height tree = new tree_height();
        tree.run(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("4\n", outContent.toString());
    }

}
