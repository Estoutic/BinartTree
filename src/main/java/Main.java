public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
//        binaryTree.isEmpty();
        binaryTree.add(7);
//        binaryTree.contains(3);
//        binaryTree.contains(10);
        binaryTree.add(3);

        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(10);
        binaryTree.add(4);
        System.out.printf("size of binary tree is %s\n",binaryTree.size());
        binaryTree.clear();
        System.out.printf("size of binary tree is %s\n",binaryTree.size());
//        binaryTree.remove(3);
//        binaryTree.isEmpty();
    }
}
