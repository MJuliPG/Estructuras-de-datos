/**
 * OPCION 1: PILA CON ARREGLO (tamaño fijo).
 *   size=5 -> array = {null, null, null, null, null}, top = -1  (vacia)
 *   push(O1)          array = {O1, null, ...},          top = 0
 *   llena cuando top == size - 1
 */
public class ArrayStack implements StackInterface {

    private int size;       
    private Object[] array;
    private int top;         

    public ArrayStack(int size) {
        this.size = size;
        this.array = new Object[size];
        this.top = -1;
        clear();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) array[i] = null;
        top = -1;
    }

    @Override
    public boolean isEmpty() { return top == -1; }

    public boolean isFull() { return top == size - 1; }

    @Override
    public boolean push(Object object) {
        if (isFull()) {
            System.out.println("Desbordamiento (stack overflow): la pila esta llena");
            return false;
        }
        top++;                  
        array[top] = object;      
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;   
        Object dato = array[top];
        array[top] = null;
        top--;
        return dato;
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : array[top];
    }

    @Override
    public int size() { return top + 1; }   

    @Override
    public boolean search(Object object) {
        for (int i = 0; i <= top; i++) {
            if (array[i].equals(object)) return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top - i; j++) {
                if (((Comparable<Object>) array[j]).compareTo(array[j + 1]) > 0) {
                    Object t = array[j]; array[j] = array[j + 1]; array[j + 1] = t;
                }
            }
        }
    }

    @Override
    public void reverse() {
        for (int i = 0, j = top; i < j; i++, j--) {
            Object t = array[i]; array[i] = array[j]; array[j] = t;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[cima] ");
        for (int i = top; i >= 0; i--) sb.append(array[i]).append(" ");
        return sb.append("[fondo]").toString();
    }
}
