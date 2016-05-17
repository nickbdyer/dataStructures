package uk.nickbdyer.datastructures;

import java.util.*;
import java.io.*;

public class tree_orders {
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

    public class TreeOrders {
        int n;
        int[] key, left, right;
        List<Node> nodeList;

        void read(InputStreamReader input) throws IOException {
            FastScanner in = new FastScanner(input);
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            Node root = nodeList.get(0);

            if(root == null)
                return result;

            Stack<Node> stack = new Stack<>();
            Node currentNode=root;

            while (!stack.empty() || currentNode != null) {
                if (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                } else {
                    Node n = stack.pop();
                    result.add(n.data);
                    currentNode = n.right;
                }
            }

            return result;
        }

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            Node root = nodeList.get(0);

            if(root == null)
                return result;

            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while(!stack.empty()){
                Node n = stack.pop();
                result.add(n.data);

                if(n.right != null){
                    stack.push(n.right);
                }
                if(n.left != null){
                    stack.push(n.left);
                }
            }

            return result;
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            Node root = nodeList.get(0);

            if(root == null)
                return result;

            Stack<Node> stack = new Stack<>();
            Node current = root;

            while( true ) {

                if( current != null ) {
                    if( current.right != null )
                        stack.push( current.right );
                    stack.push( current );
                    current = current.left;
                    continue;
                }

                if( stack.isEmpty( ) )
                    return result;
                current = stack.pop( );

                if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
                    stack.pop( );
                    stack.push( current );
                    current = current.right;
                } else {
                    result.add(current.data);
                    current = null;
                }
            }
        }

        public void createTree() {
            nodeList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodeList.add(new Node(key[i]));
            }
            for (int i = 0; i < n; i++) {
                if (left[i] != -1) {
                    nodeList.get(i).left = nodeList.get(left[i]);
                }
                if (right[i] != -1) {
                    nodeList.get(i).right = nodeList.get(right[i]);
                }
            }
        }
    }

    class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_orders().run(new InputStreamReader(System.in), new PrintStream(System.out));
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x, PrintStream output) {
        for (Integer a : x) {
            output.print(a + " ");
        }
        output.println();
    }

    public void run(InputStreamReader input, PrintStream output) throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read(input);
        tree.createTree();
        print(tree.inOrder(), output);
        print(tree.preOrder(), output);
        print(tree.postOrder(), output);
    }
}

