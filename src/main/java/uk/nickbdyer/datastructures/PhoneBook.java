package uk.nickbdyer.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneBook {

    private FastScanner in;
    // Keep list of all existing (i.e. not deleted yet) contacts.
    private List<Contact> contacts = new ArrayList<Contact>();
    private String[] contactsArray = new String[10000000];

    public static void main(String[] args) {
        new PhoneBook(new InputStreamReader(System.in)).processQueries(new PrintStream(System.out));
    }

    public PhoneBook(InputStreamReader input) {
        in = new FastScanner(input);
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void writeResponse(String response, PrintStream output) {
        output.println(response);
    }


    private void processQuery(Query query, PrintStream output) {
        if (query.type.equals("add")) {
            contactsArray[query.number] = query.name;
        } else if (query.type.equals("del")) {
            contactsArray[query.number] = null;
        } else {
            String response = "not found";
            if ((contactsArray[query.number]) != null) {
                writeResponse(contactsArray[query.number], output);
            } else {
                writeResponse(response, output);
            }
        }
    }

    public void processQueries(PrintStream output) {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery(), output);
    }

    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
