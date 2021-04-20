package programmers.tree;

class TreeSolution {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.createNode(null, 4, null);
        Node n5 = t.createNode(null, 5, null);
        Node n2 = t.createNode(n4, 2, n5);
        Node n3 = t.createNode(null, 3, null);
        Node n1 = t.createNode(n2, 1, n3);

        t.setRoot(n1);
        System.out.println("sum:" + t.getRootSum(t.getRoot()));
    }
}

class Tree {
    public Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node createNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    //중위 순회 Inorder = Left -> Root -> Right
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    //전위순회 Preorder = Root -> Left -> Right
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //후위순회 Postorder = Left -> Right -> Root
    public void postOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }

    public void leafOrder(Node node) {
        if (node != null) {
            leafOrder(node.left);
            leafOrder(node.right);
            System.out.println(node.data);
        }
    }

    public int getRootSum(Node node) {
        if (node != null) {
            int leftSum = getRootSum(node.left);
            int rightSum = getRootSum(node.right);

            return leftSum + rightSum + node.data;
        }

        return 0;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}

