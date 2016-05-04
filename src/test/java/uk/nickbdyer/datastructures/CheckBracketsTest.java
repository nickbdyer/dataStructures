package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckBracketsTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }
    @Test
    public void twoSquareBracketsAreBalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("[]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertThat(outContent.toString(), containsString("Success"));
    }

}
