package linked_list;

public class PrintList {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(2);

        list.getTail().next = list.head;

        System.out.print(list.detectCycle());
    }
}
