package uk.nickbdyer.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class tree_height {

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run(new InputStreamReader(System.in), System.out);
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run(InputStreamReader input, PrintStream output) throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read(input);
        output.println(tree.computeHeight());
    }

    class Node {
        private int data;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }

        void setParent(Node parent) {
            this.parent = parent;
        }

    }


    class TreeHeight {
        int n;
        int parent[];
        int heights[];
//        Node root;
//
//        Node getRoot() {
//            return root;
//        }

        void read(InputStreamReader input) throws IOException {
            FastScanner in = new FastScanner(input);
            n = in.nextInt();
            parent = new int[n];
            heights = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
//            createTree();
        }

        int computeHeight() {
            // Replace this code with a faster implementation
            int maxHeight = 0;
            int numOperations = 0;
            for (int node = 0; node < n; node++) {
                int height = 0;
                for (int i = node; i != -1; i = parent[i]) {
                    if (heights[i] != 0) {
                        height = height + heights[i];
                        break;
                    }
                    height++;
                    numOperations++;
                }
                heights[node] = height;
                maxHeight = Math.max(maxHeight, height);
            }
            System.out.println(numOperations);
            return maxHeight;
        }

//        void createTree() {
//            List<Node> nodeList = new ArrayList<Node>();
//            for (int i = 0; i < n; i++) {
//                Node node = new Node(i);
//                nodeList.add(node);
//            }
//            for (int i = 0; i < n; i++) {
//                if (parent[i] == -1) {
//                    root = nodeList.get(i);
//                } else {
//                    nodeList.get(i).setParent(nodeList.get(parent[i]));
//                }
//            }
//        }
//
//        int newComputeHeight(Node root) {
//            int maxHeight = 0;
//            for (int node = 0; node < n; node++) {
//                int height = 0;
//                for (int i = node; i != -1; i = parent[i])
//                    height++;
//                maxHeight = Math.max(maxHeight, height);
//            }
//            return maxHeight;
//        }

    }

    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner(InputStreamReader input) {
            in = new BufferedReader(input);
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}
