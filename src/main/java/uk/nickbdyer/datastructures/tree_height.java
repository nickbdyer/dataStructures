package uk.nickbdyer.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

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
        output.println(tree.computeHeight(tree.getRoot()));
    }

    class Node {
        private int data;
        private Node parent;
        private List<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<Node>();
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public void setParent(Node parent) {
            this.parent = parent;
       }

        public int countChildren() {
           return children.size();
        }
    }


    class TreeHeight {
        int n;
        int parent[];
        Node root;

        Node getRoot() {
            return root;
        }

        void read(InputStreamReader input) throws IOException {
            FastScanner in = new FastScanner(input);
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
            createTree();
        }

        void createTree() {
            List<Node> nodeList = new ArrayList<Node>();
            for (int i = 0; i < n; i++) {
                Node node = new Node(i);
                nodeList.add(node);
            } for (int i = 0; i < n; i++) {
                if (parent[i] == -1) {
                    root = nodeList.get(i);
                } else {
                    nodeList.get(i).setParent(nodeList.get(parent[i]));
                }
            }
            for (int i = 0; i < n; i++) {
                if (parent[i] == -1) {

                } else {
                    nodeList.get(parent[i]).addChild(nodeList.get(i));
                }
            }
        }

        int computeHeight(Node root) {
            int height = 1;
            List<Node> todo = root.children;

            while(true) {
                int nodeCount = todo.size();

                if (nodeCount == 0) {
                   return height;
                } else {
                    height++;
                }

                while(nodeCount > 0) {
                    Node thisNode = todo.remove(0);

                    todo.addAll(thisNode.children);
                    nodeCount--;
                }
            }
        }

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
