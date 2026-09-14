public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    public Queue() {
        this(false);
    }

    public Queue(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
        clear();
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int size() { return size; }

   
    @Override
    public boolean insert(Object object) {
        if (isPriorityQueue) return insert(object, Integer.MAX_VALUE);   
        QueueNode nuevo = new QueueNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.next = nuevo;
            tail = nuevo;
        }
        size++;
        return true;
    }

    public boolean insert(Object object, int priority) {
        QueueNode nuevo = new QueueNode(object, priority);

        if (isEmpty()) {                                   
            head = tail = nuevo;
        } else if (priority < head.priority) {            
            nuevo.next = head;
            head = nuevo;
        } else {
            QueueNode temp = head;                        
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            nuevo.next = temp.next;
            temp.next = nuevo;
            if (nuevo.next == null) tail = nuevo;         
        }
        size++;
        return true;
    }


    @Override
    public Object extract() {
        if (isEmpty()) return null;
        Object dato = head.getObject();
        head = head.next;
        if (head == null) tail = null;                     
        size--;
        return dato;
    }

    public Object peek() {
        return isEmpty() ? null : head.getObject();
    }

    @Override
    public boolean search(Object object) {
        QueueNode temp = head;
        while (temp != null) {
            if (temp.getObject().equals(object)) return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        if (size < 2) return;
        boolean cambio;
        do {
            cambio = false;
            for (QueueNode t = head; t.next != null; t = t.next) {
                if (((Comparable<Object>) t.getObject()).compareTo(t.next.getObject()) > 0) {
                    Object o = t.getObject(); t.setObject(t.next.getObject()); t.next.setObject(o);
                    int p = t.priority; t.priority = t.next.priority; t.next.priority = p;
                    cambio = true;
                }
            }
        } while (cambio);
    }

    @Override
    public void reverse() {
        QueueNode anterior = null, actual = head;
        tail = head;
        while (actual != null) {
            QueueNode siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[frente] ");
        for (QueueNode t = head; t != null; t = t.next) {
            sb.append(t.getObject());
            if (isPriorityQueue) sb.append("(p").append(t.priority == Integer.MAX_VALUE ? "-" : t.priority).append(")");
            sb.append(" ");
        }
        return sb.append("[final]").toString();
    }
}
