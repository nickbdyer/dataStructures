package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class HashChainsTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void sampleTestOne() {
        String input = "12\n"+
                "add 911 police\n" +
                "add 76213 Mom\n" +
                "add 17239 Bob\n" +
                "find 76213\n" +
                "find 910\n" +
                "find 911\n" +
                "del 910\n" +
                "del 911\n" +
                "find 911\n" +
                "find 76213\n" +
                "add 76213 daddy\n" +
                "find 76213";
        inContent = new ByteArrayInputStream(input.getBytes());
        PhoneBook phoneBook = new PhoneBook(new InputStreamReader(inContent));
        phoneBook.processQueries(new PrintStream(outContent));
        assertEquals("Mom\n" + "not found\n" + "police\n" + "not found\n" +
                "Mom\n" + "daddy\n", outContent.toString());
    }

    @Test
    public void sampleTestTwo() {
        String input = "8\n" +
                "find 3839442\n" +
                "add 123456 me\n" +
                "add 0 granny\n" +
                "find 0\n" +
                "find 123456\n" +
                "del 0\n" +
                "del 0\n" +
                "find 0";
        inContent = new ByteArrayInputStream(input.getBytes());
        PhoneBook phoneBook = new PhoneBook(new InputStreamReader(inContent));
        phoneBook.processQueries(new PrintStream(outContent));
        assertEquals("not found\n" + "granny\n" + "me\n" + "not found\n", outContent.toString());
    }
}
