import java.util.Random;

/**
 * LISTA SIMPLEMENTE ENLAZADA propia (sin ArrayList ni LinkedList).
 *
 *  head --> [A|*] --> [B|*] --> [C|*] --> null
 *                               ^ tail
 *
 * head = cabeza, tail = cola, next = siguiente, object = dato.
 * Recordar: comparar Objetos con .equals()  |  primitivos con ==
 */
public class List implements ListInterface {

    ListNode head;     
    ListNode tail;     
    int size = 0;

    public List() {
        clear();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public boolean insertHead(Object object) {
        ListNode nuevo = new ListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;         
        } else {
            nuevo.next = head;            
            head = nuevo;                
        }
        size++;
        return true;
    }

 
    @Override
    public boolean insertTail(Object object) {
        ListNode nuevo = new ListNode(object);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.next = nuevo;          
            tail = nuevo;                
        }
        size++;
        return true;
    }

   
    public boolean insertTailRecorriendo(Object object) {
        ListNode nuevo = new ListNode(object);
        if (head == null) {
            head = tail = nuevo;
        } else {
            ListNode temp = head;
            while (temp.next != null) {   
                temp = temp.next;
            }
            temp.next = nuevo;
            tail = nuevo;
        }
        size++;
        return true;
    }

   
    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

  
    @Override
    public boolean insert(Object object, ListNode node) {
        if (node == null) return false;
        ListNode nuevo = new ListNode(object);
        nuevo.next = node.next;           
        node.next = nuevo;               
        if (node == tail) tail = nuevo;   
        size++;
        return true;
    }

 
    public boolean insertBefore(Object nuevoDato, Object x) {
        if (isEmpty()) return false;
        if (head.object.equals(x)) {                
            return insertHead(nuevoDato);
        }
        ListNode anterior = head;
        while (anterior.next != null && !anterior.next.object.equals(x)) {
            anterior = anterior.next;               
        }
        if (anterior.next == null) return false;    
        ListNode nuevo = new ListNode(nuevoDato);
        nuevo.next = anterior.next;                 
        anterior.next = nuevo;                      
        size++;
        return true;
    }

   
    public boolean insertAfter(Object nuevoDato, Object x) {
        ListNode nodoX = search(x);
        if (nodoX == null) return false;
        return insert(nuevoDato, nodoX);
    }


    public boolean insertAt(Object object, int posicion) {
        if (posicion < 0 || posicion > size) return false;
        if (posicion == 0) return insertHead(object);
        if (posicion == size) return insertTail(object);
        ListNode temp = head;
        for (int i = 0; i < posicion - 1; i++) temp = temp.next;  
        return insert(object, temp);
    }

   
    @Override
    public boolean remove(Object object) {
        if (isEmpty()) return false;

      
        if (head.object.equals(object)) {
            head = head.next;
            if (head == null) tail = null;           
            size--;
            return true;
        }
       
        ListNode anterior = head;
        while (anterior.next != null) {
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

    
    public Object removeAt(int posicion) {
        if (posicion < 0 || posicion >= size) return null;
        ListNode temp = head;
        for (int i = 0; i < posicion; i++) temp = temp.next;
        Object dato = temp.object;
        remove(dato);           
        return dato;
    }

    
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.object + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

   
    public ListNode search(Object object) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.object.equals(object)) return temp;
            temp = temp.next;
        }
        return null;
    }

   
    public int indexOf(Object object) {
        ListNode temp = head;
        int posicion = 0;
        while (temp != null) {
            if (temp.object.equals(object)) return posicion;
            temp = temp.next;
            posicion++;
        }
        return -1;
    }

    
    public Object get(int posicion) {
        if (posicion < 0 || posicion >= size) return null;
        ListNode temp = head;
        for (int i = 0; i < posicion; i++) temp = temp.next;
        return temp.object;
    }

   
    public boolean update(Object valorViejo, Object valorNuevo) {
        boolean cambio = false;
        ListNode temp = head;
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
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object getHead() {
        return isEmpty() ? null : head.object;
    }

    @Override
    public Object getTail() {
        return isEmpty() ? null : tail.object;
    }

    @Override
    public Object get(ListNode node) {
        return node == null ? null : node.object;
    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (node == null) return false;
        node.object = object;
        return true;
    }

    
    @Override
    public Object getBeforeTo(ListNode node) {
        if (isEmpty() || node == null || node == head) return null;
        ListNode temp = head;
        while (temp != null && temp.next != node) temp = temp.next;
        return temp == null ? null : temp.object;
    }

    @Override
    public Object getNextTo(ListNode node) {
        if (node == null || node.next == null) return null;
        return node.next.object;
    }

    @Override
    public boolean isEquals(Object object) {
        if (!(object instanceof List)) return false;
        List otra = (List) object;
        if (otra.size != this.size) return false;
        ListNode a = this.head, b = otra.head;
        while (a != null) {
            if (!a.object.equals(b.object)) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            array[i++] = temp.object;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        Object[] array = object.length >= size ? object : new Object[size];
        ListNode temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.object;
            temp = temp.next;
        }
        return array;
    }

    
    @Override
    public List subList(ListNode fromNode, ListNode toNode) {
        List nueva = new List();
        ListNode temp = fromNode;
        while (temp != null) {
            nueva.add(temp.object);
            if (temp == toNode) break;
            temp = temp.next;
        }
        return nueva;
    }

   
    @Override
    @SuppressWarnings("unchecked")
    public List sortList() {
        if (size < 2) return this;
        boolean huboCambio;
        do {
            huboCambio = false;
            ListNode actual = head;
            while (actual.next != null) {
                Comparable<Object> a = (Comparable<Object>) actual.object;
                if (a.compareTo(actual.next.object) > 0) {      
                    Object temp = actual.object;
                    actual.object = actual.next.object;
                    actual.next.object = temp;
                    huboCambio = true;
                }
                actual = actual.next;
            }
        } while (huboCambio);
        return this;
    }

   
    public void shuffle() {
        Object[] array = toArray();
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        ListNode temp = head;
        for (Object o : array) {
            temp.object = o;
            temp = temp.next;
        }
    }

   
    public void reverse() {
        ListNode anterior = null;
        ListNode actual = head;
        tail = head;
        while (actual != null) {
            ListNode siguiente = actual.next;   
            actual.next = anterior;             
            anterior = actual;                  
            actual = siguiente;
        }
        head = anterior;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.object);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        return sb.append("]").toString();
    }
}
