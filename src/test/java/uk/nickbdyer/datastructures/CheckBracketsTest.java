package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoSquareBracketsAndTwoCurlyBracketsAreBalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("{}[]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoSquareBracketsWithNestedTwoBracketsAreBalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("[()]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoBracketsWithNestedTwoBracketsAreBalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("(())".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoNestedBracketsAndExtraBracketsAreBalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("{[]}()".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void noClosingBracketIsUnbalanced() throws Exception {
        CheckBrackets checker = new CheckBrackets();
        inContent = new ByteArrayInputStream("{".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("1", outContent.toString());
    }

}
