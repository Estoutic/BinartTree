package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class BinaryTree<T> implements SimpleCollection<T> {

    private Node<T> root;
    private final Logger log = LoggerFactory.getLogger(BinaryTree.class);

    @Override
    public int size() {
        log.info(String.format("last el is %s",lastElementInTree()));
        return toArray().size();
    }

    @Override

    public boolean isEmpty() {
        if (root == null) {
            log.debug("binary tree is empty");
            return true;
        } else {
            log.debug("binary tree is not empty");
            return false;
        }
    }

    @Override
    public boolean contains(T value) {
        Node<T> curNode = root;
        int hash = (int) value;
        int count = 0;
        while (curNode.getKey() != hash) {
            if (hash > curNode.getKey()) {
                curNode = curNode.getRightChild();
            } else {
                curNode = curNode.getLeftChild();
            }
            if (curNode == null) {
                log.debug(String.format("%s not in binary tree", value));
                return false;
            }
            count ++;
        }
        log.info(String.format("count is %s",count));
        log.info(String.format("%s is in binary tree", value));
        return true;
    }


    @Override
    public ArrayList<T> toArray() {

        ArrayList<T> valueList = new ArrayList<>();
        if (root == null) {
            return valueList;
        }
        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.empty()) {
            Node<T> parElement = nodeStack.pop();

            valueList.add(parElement.getValue());
            if (parElement.getRightChild() != null) {
                nodeStack.push(parElement.getRightChild());
            }
            if (parElement.getLeftChild() != null) {
                nodeStack.push(parElement.getLeftChild());
            }
        }
        return valueList;
    }

    @Override
    public boolean add(T value) {

        Node<T> curNode = root;
        int hash_code = (int) value;
        Node<T> newNode = new Node<>();
        newNode.setKey(hash_code);
        newNode.setValue(value);

        if (curNode == null) {
            root = newNode;
            log.debug(String.format("%s now is root", newNode.getValue()));
            return true;
        } else {
            while (true) {
                if (newNode.getKey() < curNode.getKey()) {
                    if (curNode.getLeftChild() == null) {
                        curNode.setLeftChild(newNode);
                        log.debug(String.format("%s added in %s", newNode.getValue(), curNode.getValue()));
                        return true;
                    } else {
                        curNode = curNode.getLeftChild();
                    }
                } else if (newNode.getKey() > curNode.getKey()) {
                    if (curNode.getRightChild() == null) {
                        curNode.setRightChild(newNode);
                        log.debug(String.format("%s added in %s", newNode.getValue(), curNode.getValue()));
                        return true;
                    } else {
                        curNode = curNode.getRightChild();
                    }
                } else if (newNode.getKey() == curNode.getKey()) {
                    log.debug(String.format("%s is already in %s\n", newNode.getValue(), curNode.getValue()));
                    return false;
                }
            }
        }
    }

    @Override
    public boolean remove(T value) {

        int hashKey = (int) value;
        Node<T> curNode = root;
        Node<T> parNode = root;

        if (curNode == null) {
            log.debug("binary tree is empty");
            return false;
        } else if (curNode.getKey() == hashKey) {
            root = null;
            log.debug(String.format("element %s is deleted", value));
            return true;
        }

        while (curNode.getKey() != hashKey) {
            parNode = curNode;
            if (hashKey > curNode.getKey()) {
                curNode = curNode.getRightChild();
            } else if (hashKey < curNode.getKey()) {
                curNode = curNode.getLeftChild();
            }
            if (curNode == null) {
                log.debug(String.format("%s not in tree", value));
                return false;
            }
        }


        if (curNode.getLeftChild() == null & curNode.getRightChild() == null) {

            if (curNode == parNode.getLeftChild()) {
                parNode.setLeftChild(null);
                log.debug(String.format("element %s is deleted\n", value));
                return true;
            } else if (curNode == parNode.getRightChild()) {
                parNode.setRightChild(null);
                log.debug(String.format("element %s is deleted\n", value));
                return true;
            }
        }
        if (curNode.getLeftChild() == null & curNode.getRightChild() != null) {
            parNode.setRightChild(curNode.getRightChild());
            log.debug(String.format("element %s is deleted\n", value));
            return true;
        } else if (curNode.getRightChild() == null & curNode.getLeftChild() != null) {
            parNode.setLeftChild(curNode.getLeftChild());
            log.debug(String.format("element %s is deleted\n", value));
            return true;
        }
        if (curNode.getRightChild() != null & curNode.getLeftChild() != null) {
            if (deletedNodeChangeToChild(curNode)) {
                log.debug(String.format("element %s is deleted\n", value));
            } else {
                log.debug(String.format("element %s is not deleted\n", value));
                return false;
            }
        }

        return false;
    }

    @Override
    public void addAll(Collection<T> c) {
        for (T element : c) {
            add(element);
        }
    }

    @Override
    public void removeAll(Collection<T> c) {
        for (T element : c) {
            remove(element);
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void balanceTree(T lowVal, T highVal) {

        int low = (int) lowVal;
        int high = (int) highVal;

        ArrayList<T> valueList = new ArrayList<>();

        if (root != null) {

            Stack<Node<T>> nodeStack = new Stack<>();
            nodeStack.push(root);

            while (!nodeStack.empty()) {
                Node<T> parElement = nodeStack.pop();

                valueList.add(parElement.getValue());
                if (parElement.getRightChild() != null && parElement.getRightChild().getKey() >= low & parElement.getRightChild().getKey() <= high) {
                    nodeStack.push(parElement.getRightChild());
                }
                else if ((parElement.getRightChild() != null ? parElement.getRightChild().getRightChild() : null) != null && parElement.getRightChild().getRightChild().getKey() > low & parElement.getRightChild().getRightChild().getKey() < high){
                    nodeStack.push(parElement.getRightChild().getRightChild());
                }
                else if((parElement.getRightChild() != null ? parElement.getRightChild().getLeftChild() : null) != null && parElement.getRightChild().getLeftChild().getKey() > low & parElement.getRightChild().getLeftChild().getKey() < high){
                    nodeStack.push(parElement.getRightChild().getLeftChild());
                }
                if (parElement.getLeftChild() != null && parElement.getLeftChild().getKey() >= low & parElement.getLeftChild().getKey() <= high) {
                    nodeStack.push(parElement.getLeftChild());
                }
                else if ((parElement.getLeftChild() != null ? parElement.getLeftChild().getRightChild() : null) != null && parElement.getLeftChild().getRightChild().getKey() > low & parElement.getLeftChild().getRightChild().getKey() < high){
                    nodeStack.push(parElement.getLeftChild().getRightChild());
                }
                else if((parElement.getLeftChild() != null ? parElement.getLeftChild().getLeftChild() : null) != null && parElement.getLeftChild().getLeftChild().getKey() > low & parElement.getLeftChild().getLeftChild().getKey() < high){
                    nodeStack.push(parElement.getLeftChild().getLeftChild());
                }
            }
            clear();
            addAll(valueList);
        }
    }

    private boolean deletedNodeChangeToChild(Node<T> node) {

        Node<T> curNode = node.getRightChild();
        Node<T> parNode = node;

        while (true) {
            parNode = curNode;
            curNode = curNode.getLeftChild();
            if (curNode.getRightChild() == null & curNode.getLeftChild() == null & curNode == parNode.getLeftChild()) {
                node.setKey(curNode.getKey());
                node.setValue(curNode.getValue());
                parNode.setLeftChild(null);

                return true;
            }
        }
    }
    private int lastElementInTree(){
        Node<T> curNode = root;
        int count = 0;
        while (curNode.getRightChild() != null){
            curNode = curNode.getRightChild();
            count ++;
        }
        return count;
    }
}

