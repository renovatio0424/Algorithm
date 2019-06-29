package basic;

class Tree {
    private Node root;

    void setRoot(Node node) {
        this.root = node;
    }

    Node getRoot(){
        return root;
    }

    <T> Node createNode(Node left, T data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    void preOrder(Node node){
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if(node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }
}

class Node<T> {
    T data;
    Node left;
    Node right;
}
