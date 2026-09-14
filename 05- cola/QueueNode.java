/**
 * Nodo de cola:            [ object | next ]
 * Nodo de cola prioridad:  [ object | priority | next ]
 */
public class QueueNode {
    private Object object;
    public int priority;       // solo se usa en cola de prioridad (1 = mas urgente)
    public QueueNode next;

    public QueueNode(Object object) {
        this.object = object;
        this.priority = 0;
        this.next = null;
    }

    public QueueNode(Object object, int priority) {
        this(object);
        this.priority = priority;
    }

    public Object getObject() { return object; }
    public void setObject(Object object) { this.object = object; }
}
