package linked_list;

public class Solution {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.removeLast();
        list.addFirst(2);
        list.addLast(4);
        list.addFirst(3);
        list.remove(3);
        for (int i : list)
            System.out.println(i);
        System.out.print(list.size());
    }
}
