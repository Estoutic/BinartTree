import Interface.SimpleCollection;

import java.util.Collection;
import java.util.Stack;

public class BinaryTree implements SimpleCollection {

    private Node root;

    public  BinaryTree(){
        root = null;
    }

    @Override
    public int size() {
        printTree();
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if (root == null){
            System.out.println("binary tree is empty");
            return true;
        }else {
            System.out.println("binary tree is not empty");
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        Node curNode = root;
        int hash_value = o.hashCode();
        while (curNode.getKey() != hash_value){
            if (hash_value > curNode.getKey()){
                curNode = curNode.getRightChild();
            }
            else {
                curNode = curNode.getLeftChild();
            }
            if (curNode == null){
                System.out.printf("%s not in binary tree\n",o);
                return false;
            }
            }
        System.out.printf("%s is in binary tree\n",o);
        return true;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node curNode = root;
        int hash_code = o.hashCode();
        Node<Object> newNode = new Node<>();
        newNode.setKey(hash_code);
        newNode.setValue(o);
        if (curNode == null){
            root = newNode;
            System.out.printf("%s now is root\n", newNode.getValue());
            return true;
        }else {
            while (true) {
                if (newNode.getKey() < curNode.getKey()) {

                    if (curNode.getLeftChild() == null) {
                        curNode.setLeftChild(newNode);
                        System.out.printf("%s added in %s\n", newNode.getValue(), curNode.getValue());
                        return true;
                    }
                }
                    else if (newNode.getKey() > curNode.getKey()){
                        if(curNode.getRightChild() == null){
                            curNode.setRightChild(newNode);
                            System.out.printf("%s added in %s\n",newNode.getValue(), curNode.getValue());
                            return true;
                    }
                }else if( newNode.getKey() == curNode.getKey()){
                        System.out.printf("%s is already in %s\n",newNode,curNode.getValue());
                        return false;
                }

            }
        }
    }

    @Override
    public boolean remove(Object o) {

        int hashKey = o.hashCode();
        Node curNode = root;
        Node parNode = root;

        if (curNode == null){
            System.out.println("Binary tree is empty\n");
            return false;
        }

        else if(curNode.getKey() == hashKey){
            root = null;
            System.out.printf("element %s is already deleted\n", o);
            return true;
        }

        while(curNode.getKey() != hashKey){
            parNode = curNode;
            if (hashKey > curNode.getKey()){
                curNode = curNode.getRightChild();
            }
            else if (hashKey < curNode.getKey()){
                curNode = curNode.getLeftChild();
            }
            if (curNode == null){
                System.out.printf("%s not in tree\n", o);
                return false;
            }
        }
        if (hashKey == curNode.getKey()){
            if(curNode.getLeftChild() == null & curNode.getRightChild() == null) {

                if (curNode == parNode.getLeftChild()) {
                    parNode.setLeftChild(null);
                    System.out.printf("element %s deleted\n", o);
                    return true;
                } else if (curNode == parNode.getRightChild()) {
                    parNode.setRightChild(null);
                    System.out.printf("element %s deleted\n", o);
                    return true;
                }
            }
             if (curNode.getLeftChild() == null & curNode.getRightChild() != null){
                 parNode.setRightChild(curNode.getRightChild());
                 System.out.printf("element %s deleted\n", o);
                 return true;
            }
             else if (curNode.getRightChild() == null & curNode.getLeftChild() != null){
                 parNode.setLeftChild(curNode.getLeftChild());
                 System.out.printf("element %s deleted\n", o);
                 return true;
             }
             if (curNode.getRightChild() != null & curNode.getLeftChild() != null){
                 if (getCurrentNode(curNode)){
                     System.out.printf("element %s deleted\n", o);
                 }
                 else {

                     System.out.printf("element %s is not deleted\n", o);
                     return false;
                 }
             }
        }
        return false;
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private boolean getCurrentNode(Node node){

        Node curNode = node.getRightChild();
        Node parNode = curNode;

        while(true){
            parNode = curNode;
            curNode = curNode.getLeftChild();
            if (curNode.getRightChild() == null & curNode.getLeftChild() == null & curNode == parNode.getLeftChild() ){
                parNode.setLeftChild(null);
                node.setKey(parNode.getKey());
                return true;
            }
        }
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}
