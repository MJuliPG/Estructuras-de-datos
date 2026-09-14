/**
 * NODO de lista simplemente enlazada.
 *   [ object | next ] ---> [ object | next ] ---> null
 * (En el tablero: class Nodo { Object dato; Nodo siguiente; })
 */
public class ListNode {
    public Object object;   // campo informacion (dato)
    public ListNode next;   // campo enlace (siguiente). Si es el ultimo: null

    public ListNode(Object object) {
        this.object = object;
        this.next = null;
    }

    public ListNode() {
        this(null);
    }
}
