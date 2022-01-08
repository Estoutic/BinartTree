import tree.BinaryTree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
//        int a = 0;
//        int b = 10000000;
//        int countNums = 10000000;
//        for(int i = 0;i < 1000000;i++){
//            binaryTree.add(i);
//        }
//        while (countNums != 0) {
//            binaryTree.add(a + (int) (Math.random() * b));
//            countNums -= 1;
//        }
//        binaryTree.contains(40000);
//        System.out.println(binaryTree.size());
//        System.out.printf("time of compiling is %s\n", System.currentTimeMillis() - startTime);
//
//        System.out.printf("difficult of algorithm is %s", Math.log(binaryTree.size()));

//        binaryTree.isEmpty();
//        binaryTree.add(5);
//        binaryTree.add(2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(2);
//        arrayList.add(2);
//        arrayList.add(1);
        binaryTree.addAll(arrayList);
        System.out.println(binaryTree.toArray());
        binaryTree.balanceTree(1,3);
        System.out.println(binaryTree.toArray());
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.add(10);
//        arrayList2.add(3);
//        arrayList2.add(7);
//        binaryTree.removeAll(arrayList2);
//        binaryTree.isEmpty();
//        binaryTree.add(7);
//        binaryTree.contains(3);
//        binaryTree.contains(10);
//        binaryTree.add(3);
//

//        binaryTree.add(10);
//        binaryTree.add(4);
//        System.out.println(binaryTree.toArray());
//        System.out.printf("size of binary tree is %s\n",binaryTree.size());
//        binaryTree.clear();
//        System.out.printf("size of binary tree is %s\n",binaryTree.size());
//        binaryTree.remove(3);
//        binaryTree.isEmpty();
//
    }
}
