/**
 * LISTA DOBLE CIRCULAR (version corta): tail.next == head  y  head.prev == tail.
 * Usa su propio nodo interno con prev y next.
 */
public class DoubleCircularList {

    static class Nodo {
        Object dato;
        Nodo anterior, siguiente;
        Nodo(Object dato) { this.dato = dato; }
    }

    Nodo head, tail;
    int size = 0;

    public boolean isEmpty() { return head == null; }

    public void insertTail(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            nuevo.anterior = tail;
            tail = nuevo;
        }
        cerrarCirculo();
        size++;
    }

    public void insertHead(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            head = tail = nuevo;
        } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
        }
        cerrarCirculo();
        size++;
    }

    public boolean delete(Object dato) {
        Nodo temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.dato.equals(dato)) {
                if (size == 1) { head = tail = null; size = 0; return true; }
                temp.anterior.siguiente = temp.siguiente;   
                temp.siguiente.anterior = temp.anterior;   
                if (temp == head) head = temp.siguiente;
                if (temp == tail) tail = temp.anterior;
                size--;
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

    private void cerrarCirculo() {
        tail.siguiente = head;
        head.anterior = tail;
    }

    public void printAdelante() {
        Nodo temp = head;
        for (int i = 0; i < size; i++) { System.out.print(temp.dato + " "); temp = temp.siguiente; }
        System.out.println();
    }

    public void printAtras() {
        Nodo temp = tail;
        for (int i = 0; i < size; i++) { System.out.print(temp.dato + " "); temp = temp.anterior; }
        System.out.println();
    }
}
