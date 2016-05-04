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
        Boolean unMatchedBracketFound = false;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position + 1));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.peek().Match(next)) {
                    opening_brackets_stack.pop();
                } else {
                    output.print(position + 1);
                    unMatchedBracketFound = true;
                }
            }
        }

        if (opening_brackets_stack.isEmpty()) {
            output.print("Success");
        } else if (!unMatchedBracketFound){
            output.print(opening_brackets_stack.peek().position);
        }

   }
}
