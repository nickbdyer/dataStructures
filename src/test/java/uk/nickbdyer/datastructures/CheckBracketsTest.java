package uk.nickbdyer.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class checkbracketsTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void twoSquareBracketsAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("[]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoSquareBracketsAndTwoCurlyBracketsAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("{}[]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoSquareBracketsWithNestedTwoBracketsAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("[()]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoBracketsWithNestedTwoBracketsAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("(())".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void twoNestedBracketsAndExtraBracketsAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("{[]}()".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void noClosingBracketIsUnbalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("{".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("1", outContent.toString());
    }

    @Test
    public void noClosingBracketNestedIsUnbalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("{[}".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("3", outContent.toString());
    }

    @Test
    public void twoBracketsInOtherTextAreBalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("foo(bar)".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("Success", outContent.toString());
    }

    @Test
    public void unmatchedBracketInTextIsUnbalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("foo(bar[i)".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("10", outContent.toString());
    }

    @Test
    public void onlyClosingBracketIsUnbalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("}".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("1", outContent.toString());
    }

    @Test
    public void centrallyLocatedUnmatchedClosingBracketIsUnbalanced() throws Exception {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("[[]}]{}".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("4", outContent.toString());
    }

    @Test
    public void multipleWrongBracketsIsUnbalanced() throws IOException {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("[]](".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("3", outContent.toString());
    }

    @Test
    public void closingBracketNestedIsUnbalanced() throws IOException {
        check_brackets checker = new check_brackets();
        inContent = new ByteArrayInputStream("[}]]".getBytes());
        checker.check(new InputStreamReader(inContent), new PrintStream(outContent));
        assertEquals("2", outContent.toString());
    }
}
