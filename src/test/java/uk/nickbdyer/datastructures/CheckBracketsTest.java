package uk.nickbdyer.datastructures;

import org.junit.Test;

import java.io.IOException;

public class CheckBracketsTest {
    
    @Test
    public void twoSquareBracketsAreBalanced() throws IOException {
        CheckBrackets checker = new CheckBrackets();
        checker.main(new String[]{"[]"});
    }

}
