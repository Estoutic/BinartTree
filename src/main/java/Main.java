import tree.BinaryTree;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.isEmpty();
        binaryTree.add(5);
        binaryTree.add(2);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(7);
//        arrayList.add(3);
//        arrayList.add(10);
//        binaryTree.addAll(arrayList);
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.add(10);
//        arrayList2.add(3);
//        arrayList2.add(7);
//        binaryTree.removeAll(arrayList2);
        binaryTree.isEmpty();
        binaryTree.add(7);
        binaryTree.contains(3);
        binaryTree.contains(10);
        binaryTree.add(3);
//

//        binaryTree.add(10);
//        binaryTree.add(4);
//        System.out.println(binaryTree.toArray());
//        System.out.printf("size of binary tree is %s\n",binaryTree.size());
//        binaryTree.clear();
//        System.out.printf("size of binary tree is %s\n",binaryTree.size());
//        binaryTree.remove(3);
//        binaryTree.isEmpty();
//        System.out.printf("time of compiling is %s\n", System.currentTimeMillis() - startTime);
//        System.out.printf("difficult of algorithm is %s", Math.log(binaryTree.size()));

    }
}
