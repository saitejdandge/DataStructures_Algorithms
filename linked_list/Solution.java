package linked_list;

public class Solution {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            if (i % 2 == 0)
                list.addFirst(i);
            else
                list.addLast(i);

        for(int i:list)
            System.out.println(i);

    }
}
