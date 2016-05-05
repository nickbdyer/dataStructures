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

    @Test
    public void computes100NodeTree() throws IOException {
        String input = "100\n" +
                "98 30 92 96 15 78 40 20 24 44 90 82 61 15 28 53 51 19 57 4 37 70 38 21 79 19 48 65 25 76 21 75 45 15 82 64 72 85 65 21 77 55 45 65 29 50 66 74 10 41 73 25 15 18 84 30 50 7 44 36 48 36 52 16 73 97 80 74 48 22 74 9 88 69 89 7 49 7 12 9 95 1 17 80 34 44 99 79 4 -1 61 57 1 81 5 58 36 37 40 40";
        inContent = new ByteArrayInputStream(input.getBytes());
        tree_height tree = new tree_height();
        tree.run(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("28\n", outContent.toString());
    }

    @Test
    public void computes100000NodeTree() throws IOException {
        tree_height tree = new tree_height();
        tree.run(new FileReader("src/test/java/uk/nickbdyer/datastructures/100000Nodes"), new PrintStream(outContent));
        assertEquals("50001\n", outContent.toString());
    }

    @Test
    public void randomTest() throws IOException {
        inContent = new ByteArrayInputStream("5\n-1 0 4 0 3".getBytes());
        tree_height tree = new tree_height();
        tree.run(new InputStreamReader(inContent), new PrintStream(outContent));
    }


}
