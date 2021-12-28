import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    private int  key;
    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;

}
