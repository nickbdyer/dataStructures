package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class HashChainsTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void sampleTestOne() throws IOException {
        String input = "5\n" +
                        "12\n" +
                        "add world\n" +
                        "add HellO\n" +
                        "check 4\n" +
                        "find World\n" +
                        "find world\n" +
                        "del world\n" +
                        "check 4\n" +
                        "del HellO\n" +
                        "add luck\n" +
                        "add GooD\n" +
                        "check 2\n" +
                        "del good\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        HashChains hashChains = new HashChains();
        hashChains.processQueries(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("HellO world \n" +
                    "no\n" +
                    "yes\n" +
                    "HellO \n" +
                    "GooD luck \n", outContent.toString());
    }

    @Test
    public void sampleTestTwo() throws IOException {
        String input = "4\n" +
                "8\n" +
                "add test\n" +
                "add test\n" +
                "find test\n" +
                "del test\n" +
                "find test\n" +
                "find Test\n" +
                "add Test\n" +
                "find Test\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        HashChains hashChains = new HashChains();
        hashChains.processQueries(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("yes\n" + "no\n" + "no\n" + "yes\n", outContent.toString());
    }
}
