public interface DoubleListInterface {
    boolean isEmpty();
    int getSize();
    void clear();

    boolean insertHead(Object object);
    boolean insertTail(Object object);
    boolean add(Object object);
    boolean insertBefore(Object nuevo, Object x);
    boolean insertAfter(Object nuevo, Object x);

    boolean delete(Object elementoABorrar);
    boolean update(Object valorViejo, Object valorNuevo);
    DoubleListNode search(Object object);
    boolean contains(Object object);
    int indexOf(Object object);

    void printForward();
    void printBackward();
}
