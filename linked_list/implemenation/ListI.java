package linked_list.implemenation;

public interface ListI<E> extends Iterable<E> {

    void addLast(E obj);

    void addFirst(E obj);

    E removeFirst();

    E removeLast();

    E remove(E obj);

    boolean contains(E obj);

    int size();
}
