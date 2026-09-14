/**
 * LISTA DOBLEMENTE ENLAZADA.
 *
 *  head                                  tail
 *   v                                     v
 *  [null|A|*] <--> [*|B|*] <--> [*|C|null]
 *
 * 
 * 
 */
public class DoubleList implements DoubleListInterface {

    DoubleListNode head;
    DoubleListNode tail;
    int size = 0;

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int getSize() { return size; }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

 
    @Override
    public boolean insertHead(Object object) {
        DoubleListNode nuevo = new DoubleListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            nuevo.next = head;       
            head.prev = nuevo;       
            head = nuevo;
        }
        size++;
        return true;
    }


    @Override
    public boolean insertTail(Object object) {
        DoubleListNode nuevo = new DoubleListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.next = nuevo;        
            nuevo.prev = tail;        
            tail = nuevo;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Object object) { return insertTail(object); }

    
    @Override
    public boolean insertBefore(Object nuevoDato, Object x) {
        DoubleListNode nodoX = search(x);
        if (nodoX == null) return false;                
        if (nodoX == head) return insertHead(nuevoDato);

        DoubleListNode nuevo = new DoubleListNode(nuevoDato);
        DoubleListNode anterior = nodoX.prev;
        
        nuevo.prev = anterior;
        nuevo.next = nodoX;
        anterior.next = nuevo;
        nodoX.prev = nuevo;
        size++;
        return true;
    }

   
    @Override
    public boolean insertAfter(Object nuevoDato, Object x) {
        DoubleListNode nodoX = search(x);
        if (nodoX == null) return false;
        if (nodoX == tail) return insertTail(nuevoDato);

        DoubleListNode nuevo = new DoubleListNode(nuevoDato);
        DoubleListNode siguiente = nodoX.next;
       
        nuevo.prev = nodoX;
        nuevo.next = siguiente;
        nodoX.next = nuevo;
        siguiente.prev = nuevo;
        size++;
        return true;
    }

 
    @Override
    public boolean delete(Object elementoABorrar) {
        DoubleListNode temp = head;
        while (temp != null) {
            if (temp.object.equals(elementoABorrar)) {

                if (temp.prev != null) {
                    temp.prev.next = temp.next;     
                } else {
                    head = temp.next;               
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;     
                } else {
                    tail = temp.prev;              
                }

                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;                              
    }

   
    @Override
    public DoubleListNode search(Object object) {
        DoubleListNode temp = head;
        while (temp != null) {                      
            if (temp.object.equals(object)) return temp;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean contains(Object object) { return search(object) != null; }

    @Override
    public int indexOf(Object object) {
        DoubleListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.object.equals(object)) return pos;
            temp = temp.next;
            pos++;
        }
        return -1;
    }

   
    @Override
    public boolean update(Object valorViejo, Object valorNuevo) {
        boolean cambio = false;
        DoubleListNode temp = head;
        while (temp != null) {
            if (temp.object.equals(valorViejo)) {
                temp.object = valorNuevo;           
                cambio = true;
            }
            temp = temp.next;
        }
        return cambio;
    }

    
    @Override
    public void printForward() {
        DoubleListNode temp = head;
        System.out.print("null <- ");
        while (temp != null) {
            System.out.print(temp.object + (temp.next != null ? " <-> " : ""));
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

   
    @Override
    public void printBackward() {
        DoubleListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.object + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    
    public void reverse() {
        DoubleListNode temp = head;
        while (temp != null) {
            DoubleListNode aux = temp.next;
            temp.next = temp.prev;
            temp.prev = aux;
            temp = aux;
        }
        DoubleListNode aux = head;
        head = tail;
        tail = aux;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (DoubleListNode t = head; t != null; t = t.next) {
            sb.append(t.object).append(t.next != null ? ", " : "");
        }
        return sb.append("]").toString();
    }
}
