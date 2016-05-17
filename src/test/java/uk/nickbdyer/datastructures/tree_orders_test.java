package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class tree_orders_test {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void traverses5NodeTree() throws IOException {
        String input = "5\n" +
                       "4 1 2\n" +
                       "2 3 4\n" +
                       "5 -1 -1\n" +
                       "1 -1 -1\n" +
                       "3 -1 -1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        tree_orders orders = new tree_orders();
        orders.run(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("1 2 3 4 5 \n" +
                     "4 2 1 3 5 \n" +
                     "1 3 2 5 4 \n", outContent.toString());

    }
    
    @Test
    public void traverses10NodeTree() throws IOException {
        String input = "10\n" +
                       "0 7 2\n" +
                       "10 -1 -1\n" +
                       "20 -1 6\n" +
                       "30 8 9\n" +
                       "40 3 -1\n" +
                       "50 -1 -1\n" +
                       "60 1 -1\n" +
                       "70 5 4\n" +
                       "80 -1 -1\n" +
                       "90 -1 -1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        tree_orders orders = new tree_orders();
        orders.run(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("50 70 80 30 90 40 0 20 10 60 \n" +
                     "0 70 50 40 30 80 90 20 60 10 \n" +
                     "50 80 90 30 40 70 10 60 20 0 \n", outContent.toString());
    }
}
