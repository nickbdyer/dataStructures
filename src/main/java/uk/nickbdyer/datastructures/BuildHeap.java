package uk.nickbdyer.datastructures;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve(new InputStreamReader(System.in), System.out);
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        int size = data.length;
        for (int i = size - 1; i > Math.floor(size/2); --i) {
            int j = i;
            int parent = (int) Math.ceil((j - 1)/ 2);
            while ((data[parent] > data[j])) {
                swaps.add(new Swap(parent, j));
                int tmp = data[j];
                data[j] = data[parent];
                data[parent] = tmp;
                j = parent;
                parent = (int) Math.ceil((j - 1)/ 2);
            }
        }
    }

    public void solve(InputStreamReader input, PrintStream output) throws IOException {
        in = new FastScanner(input);
        out = new PrintWriter(new BufferedOutputStream(output));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
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

