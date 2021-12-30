import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BinaryTreeTest {

    BinaryTree<Integer> binaryTree = new BinaryTree<>();

    @Test
    void size() {
        binaryTree.size();
    }

    @Test
    void isEmpty() {
        binaryTree.isEmpty();
    }

    @Test
    void contains() {
        int testValue = 7;
        binaryTree.contains(testValue);
    }

    @Test
    void toArray() {
        System.out.println(binaryTree.toArray());
    }

    @Test
    void add() {
        int addingTestValue = 3;
        binaryTree.add(addingTestValue);
    }

    @Test
    void remove() {
        int deletingTestValue = 3;
        binaryTree.remove(deletingTestValue);
    }

    @Test
    void addAll() {
        ArrayList<Integer> testingValues = new ArrayList<>();
        for(int el = 1;el != 10; el++){
            testingValues.add(el);
        }
        binaryTree.addAll(testingValues);

    }

    @Test
    void removeAll() {
        ArrayList<Integer> testingValues = new ArrayList<>();
        for(int el = 1;el != 10; el++){
            testingValues.add(el);
        }
        binaryTree.removeAll(testingValues);
    }

    @Test
    void clear() {
        binaryTree.clear();
    }
}