package uk.nickbdyer.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class CheckBrackets {
    public static void main(String[] args) throws IOException {
        check(new InputStreamReader(System.in), new PrintStream(System.out));
    }

    public static void check(InputStreamReader input, PrintStream output) throws IOException {
        BufferedReader reader = new BufferedReader(input);
        String text = reader.readLine();
        Boolean unmatchedClosingBracketFound = false;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (isOpeningBracket(next)) {
                opening_brackets_stack.push(new Bracket(next, position + 1));
            }

            if (isClosingBracket(next)) {
                if (opening_brackets_stack.isEmpty()) {
                    opening_brackets_stack.push(new Bracket(next, position + 1));
                } else if (bracketMatchesTopOfStack(opening_brackets_stack, next)) {
                    opening_brackets_stack.pop();
                } else {
                    output.print(position + 1);
                    unmatchedClosingBracketFound = true;
                }
            }
        }

        if (opening_brackets_stack.isEmpty()) {
            output.print("Success");
        } else if (!unmatchedClosingBracketFound){
            output.print(opening_brackets_stack.peek().position);
        }

   }

    public static boolean bracketMatchesTopOfStack(Stack<Bracket> opening_brackets_stack, char next) {
        return opening_brackets_stack.peek().Match(next);
    }

    public static boolean isClosingBracket(char next) {
        return next == ')' || next == ']' || next == '}';
    }

    public static boolean isOpeningBracket(char next) {
        return next == '(' || next == '[' || next == '{';
    }
}
