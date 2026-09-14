/** Nodo de lista circular SIMPLE: [ object | next ]. El next del ultimo apunta a la cabeza. */
public class CircularListNode {
    public Object object;
    public CircularListNode next;

    public CircularListNode(Object object) {
        this.object = object;
        this.next = null;
    }
}
