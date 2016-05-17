package uk.nickbdyer.datastructures;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private List<String> elems;
    private List<List<String>> lists;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries(new InputStreamReader(System.in), new PrintStream(System.out));
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                if (!lists.get(hashFunc(query.s)).contains(query.s))
                    lists.get(hashFunc(query.s)).add(0, query.s);
                break;
            case "del":
                if (lists.get(hashFunc(query.s)).contains(query.s))
                    lists.get(hashFunc(query.s)).remove(query.s);
                break;
            case "find":
                writeSearchResult(lists.get(hashFunc(query.s)).contains(query.s));
                break;
            case "check":
                for (String cur : lists.get(query.ind))
                    out.print(cur + " ");
                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries(InputStreamReader input, PrintStream output) throws IOException {
        elems = new ArrayList<String>();
        in = new FastScanner(input);
        out = new PrintWriter(output);
        bucketCount = in.nextInt();
        lists = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            lists.add(new ArrayList<String>());
        }
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStreamReader input) {
            reader = new BufferedReader(input);
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

