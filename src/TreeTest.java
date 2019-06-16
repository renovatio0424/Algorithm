public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Node n4 = tree.createNode(null, "four", null);
        Node n5 = tree.createNode(null, "five", null);
        Node n2 = tree.createNode(n4, "two", n5);
        Node n3 = tree.createNode(null, "three", null);
        Node n1 = tree.createNode(n2, "one", n3);

        tree.setRoot(n1);

        tree.inOrder(tree.getRoot());
        System.out.println("===================================");
        tree.preOrder(tree.getRoot());
        System.out.println("===================================");
        tree.postOrder(tree.getRoot());
    }
}
