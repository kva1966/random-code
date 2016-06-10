public class Test {
  public static void main(String[] args) {
    LinkedList<String> names = new LinkedList<>();
    printList(names);

    names.add("Davy");
    printList(names);

    names.add("Ka Ming");
    printList(names);

    names.add("Kamal");
    printList(names);
  }

  private static void printList(LinkedList<?> list) {
    System.out.println("---");

    if (list.isEmpty()) {
      System.out.println("<EMPTY LIST>");
      return;
    }
    
    list.forEach(data -> System.out.println(data.toString()));
  }
}