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

    // java 8 lambda expressions
    forEachNode(
      n -> {}, // do nothing.
      n -> n.next = new Node(data) // add new node to last node's next pointer.
    );
  }

  public void forEach(Consumer<T> function) {
    // public consumers only get data, not private nodes
    Consumer<Node> fn = n -> function.accept(n.data);

    // but reusing forEachNode function.
    forEachNode(fn, fn);
  }

  public boolean isEmpty() {
    return list == null;
  }

  private void forEachNode(Consumer<Node> function, Consumer<Node> lastNodeFunction) {
    if (isEmpty()) {
      return;
    }

    Node curr = list;

    function.accept(curr);

    while (curr.next != null) {
      curr = curr.next;

      if (curr.next == null) {
        break; // let lastNodeFunction handle last node.
      }

      // not last node, handle.
      function.accept(curr);      
    }

    lastNodeFunction.accept(curr);
  }
}
