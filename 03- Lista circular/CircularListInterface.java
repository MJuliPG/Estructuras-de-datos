public interface CircularListInterface {
    boolean isEmpty();
    int getSize();
    void clear();

    boolean insertHead(Object object);
    boolean insertTail(Object object);
    boolean add(Object object);
    boolean insertBefore(Object nuevo, Object x);

    boolean delete(Object object);
    boolean update(Object valorViejo, Object valorNuevo);
    CircularListNode search(Object object);
    boolean contains(Object object);
    int indexOf(Object object);

    void print();
}
