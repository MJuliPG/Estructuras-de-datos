/** Operaciones de la lista (copiadas de la diapositiva "Interface Lista"). */
public interface ListInterface {
    /* essential operations */
    public boolean isEmpty();
    public int getSize();

    public void clear();
    public boolean add(Object object);
    public boolean insert(Object object, ListNode node);
    public boolean remove(Object object);

    public Object getHead();
    public Object getTail();
    public Object get(ListNode node);

    public boolean insertHead(Object object);
    public boolean insertTail(Object object);
    public boolean set(ListNode node, Object object);

    /* expansion operations */
    public boolean contains(Object object);
    public boolean isEquals(Object object);
    public Object[] toArray();
    public Object[] toArray(Object[] object);
    public Object getBeforeTo(ListNode node);
    public Object getNextTo(ListNode node);
    public List subList(ListNode fromNode, ListNode toNode);
    public List sortList();
}
