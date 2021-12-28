import Interface.SimpleCollection;

import java.util.Collection;
import java.util.Stack;

public class BinaryTree<T> implements SimpleCollection<T> {

    private Node<T> root;

    public  BinaryTree(){
        root = null;
    }

    @Override
    public int size() {

        if(root == null){
            return 0;
        }
        int size = 0;

        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.empty()){

            Node<T> parElement =  nodeStack.pop();

            size++;
            if (parElement.getRightChild() != null){

                nodeStack.push(parElement.getRightChild());

            }
            if (parElement.getLeftChild() != null){

                nodeStack.push(parElement.getLeftChild());

            }
        }
        return size;
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
        Node<T> curNode = root;
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
    public T[] toArray() {

        return null;
    }

    @Override
    public boolean add(T o) {
        Node<T> curNode = root;
        int hash_code = o.hashCode();
        Node<T> newNode = new Node<>();
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
                    }else{
                        curNode = curNode.getLeftChild();
                    }
                }

                    else if (newNode.getKey() > curNode.getKey()){
                        if(curNode.getRightChild() == null){
                            curNode.setRightChild(newNode);
                            System.out.printf("%s added in %s\n",newNode.getValue(), curNode.getValue());
                            return true;
                        }else {
                            curNode = curNode.getRightChild();
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
        Node<T> curNode = root;
        Node<T> parNode = root;

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
        root = null;
    }

    private boolean getCurrentNode(Node<T> node){

        Node<T> curNode = node.getRightChild();
        Node<T> parNode = node;


        while(true){
            parNode = curNode;
            curNode = curNode.getLeftChild();
            if (curNode.getRightChild() == null & curNode.getLeftChild() == null & curNode == parNode.getLeftChild() ){
                node.setKey(curNode.getKey());
                node.setValue(curNode.getValue());
                parNode.setLeftChild(null);

                return true;
            }
        }
    }

}
// TODO: 12/28/21 add methods "removeAll", "addAll", "toArray"