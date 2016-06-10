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

    System.out.println("======");

    LinkedList<Integer> ints = new LinkedList<>();
    printList(ints);

    ints.add(11);
    printList(ints);

    ints.add(33);
    printList(ints);

    ints.add(44);
    printList(ints);
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