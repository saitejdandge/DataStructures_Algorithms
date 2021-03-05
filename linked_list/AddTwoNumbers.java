package linked_list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AddTwoNumbers {

    public static void main(String[] args) {

        List<Integer> listA = new String("9999999".toCharArray()).chars().mapToObj(i -> (char) i)
                .map(Character::getNumericValue).collect(Collectors.toList());
        List<Integer> listB = new String("999".toCharArray()).chars().mapToObj(i -> (char) i)
                .map(Character::getNumericValue).collect(Collectors.toList());

        System.out.println(listA);
        System.out.println(listB);
        System.out.println(addTwo(listA, listB));

    }

    public static List<Integer> addTwo(List<Integer> listA, List<Integer> listB) {

        List<Integer> result = new LinkedList<>();

        Iterator<Integer> iteratorA = listA.iterator();
        Iterator<Integer> iteratorB = listB.iterator();

        int sum = 0;
        while (iteratorA.hasNext() || iteratorB.hasNext()) {

            Integer v1 = 0;
            if (iteratorA.hasNext())
                v1 = iteratorA.next();

            Integer v2 = 0;
            if (iteratorB.hasNext())
                v2 = iteratorB.next();

            sum += v1 + v2;
            result.add(sum % 10);
            sum /= 10;

        }
        if (sum > 0)
            result.add(sum);
        return result;
    }
}