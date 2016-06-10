import java.util.function.Consumer;

public class LinkedList<T> {
  private class Node {
    private final T data;
    private Node next;

    private Node(T data) {
      this.data = data;
    }
  }

  Node list;

  public void add(T data) {
    if (isEmpty()) {
      list = new Node(data);
      return;
    }

    forEachNode(
      n -> {}, // do nothing.  
      n -> n.next = new Node(data) // add to last node
    );
  }

  public void forEach(Consumer<T> function) {
    forEachNode(
      n -> function.accept(n.data),
      n -> {} // do nothing.
    );
  }

  public boolean isEmpty() {
    return list == null;
  }

  private void forEachNode(Consumer<Node> function, Consumer<Node> lastNodeFunction) {
    if (list == null) {
      return;
    }

    Node curr = list;

    function.accept(curr);

    while (curr.next != null) {
      curr = curr.next;
      function.accept(curr);      
    }

    lastNodeFunction.accept(curr);
  }
}
