/**
 * LISTA CIRCULAR SIMPLE: el ultimo nodo apunta al PRIMERO (no hay null).
 *
 *   head -> [A|*] -> [B|*] -> [C|*] -+
 *             ^                      |
 *             +----------------------+   (tail.next == head)
 */
public class CircularList implements CircularListInterface {

    public CircularListNode head;
    public CircularListNode tail;
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
        CircularListNode nuevo = new CircularListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
            nuevo.next = nuevo;          
        } else {
            nuevo.next = head;
            head = nuevo;
            tail.next = head;             
        }
        size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        CircularListNode nuevo = new CircularListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
            nuevo.next = nuevo;
        } else {
            tail.next = nuevo;
            tail = nuevo;
            tail.next = head;             
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Object object) { return insertTail(object); }

   
    @Override
    public boolean insertBefore(Object nuevoDato, Object x) {
        if (isEmpty()) return false;
        if (head.object.equals(x)) return insertHead(nuevoDato);

        CircularListNode anterior = head;
        for (int i = 0; i < size - 1; i++) {            
            if (anterior.next.object.equals(x)) {
                CircularListNode nuevo = new CircularListNode(nuevoDato);
                nuevo.next = anterior.next;
                anterior.next = nuevo;
                size++;
                return true;
            }
            anterior = anterior.next;
        }
        return false;
    }

    

    @Override
    public boolean delete(Object object) {
        if (isEmpty()) return false;

        
        if (size == 1) {
            if (head.object.equals(object)) { clear(); return true; }
            return false;
        }
        
        if (head.object.equals(object)) {
            head = head.next;
            tail.next = head;             
            size--;
            return true;
        }
        
        CircularListNode anterior = head;
        for (int i = 0; i < size - 1; i++) {
            if (anterior.next.object.equals(object)) {
                if (anterior.next == tail) tail = anterior;   
                anterior.next = anterior.next.next;
                size--;
                return true;
            }
            anterior = anterior.next;
        }
        return false;
    }

    
    @Override
    public void print() {
        if (isEmpty()) { System.out.println("(vacia)"); return; }
        CircularListNode temp = head;
        do {
            System.out.print(temp.object + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(vuelve a " + head.object + ")");
    }

    
    public void printConSize() {
        CircularListNode temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.object + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printVueltas(int cantidadNodos) {
        CircularListNode temp = head;
        for (int i = 0; i < cantidadNodos && temp != null; i++) {
            System.out.print(temp.object + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public CircularListNode search(Object object) {
        CircularListNode temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.object.equals(object)) return temp;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean contains(Object object) { return search(object) != null; }

    @Override
    public int indexOf(Object object) {
        CircularListNode temp = head;
        for (int i = 0; i < size; i++) {      
            if (temp.object.equals(object)) return i;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean update(Object valorViejo, Object valorNuevo) {
        boolean cambio = false;
        CircularListNode temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.object.equals(valorViejo)) {
                temp.object = valorNuevo;
                cambio = true;
            }
            temp = temp.next;
        }
        return cambio;
    }

    public boolean updateWhile(Object valorViejo, Object valorNuevo) {
        if (isEmpty()) return false;
        boolean cambio = false;
        CircularListNode temp = head;
        while (temp != tail) {
            if (temp.object.equals(valorViejo)) { temp.object = valorNuevo; cambio = true; }
            temp = temp.next;
        }
        if (tail.object.equals(valorViejo)) { tail.object = valorNuevo; cambio = true; }  
        return cambio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        CircularListNode temp = head;
        for (int i = 0; i < size; i++) {
            sb.append(temp.object).append(i < size - 1 ? ", " : "");
            temp = temp.next;
        }
        return sb.append("]").toString();
    }
}
