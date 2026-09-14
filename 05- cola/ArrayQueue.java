public class ArrayQueue {
    private Object[] array;
    private int frente = 0;     
    private int fin = -1;       
    private int size = 0;

    public ArrayQueue(int capacidad) {
        array = new Object[capacidad];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == array.length; }
    public int size() { return size; }

    public boolean insert(Object object) {
        if (isFull()) return false;
        fin = (fin + 1) % array.length;     
        array[fin] = object;
        size++;
        return true;
    }

    public Object extract() {
        if (isEmpty()) return null;
        Object dato = array[frente];
        array[frente] = null;
        frente = (frente + 1) % array.length;
        size--;
        return dato;
    }

    public Object peek() { return isEmpty() ? null : array[frente]; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[frente] ");
        for (int i = 0; i < size; i++) sb.append(array[(frente + i) % array.length]).append(" ");
        return sb.append("[final]").toString();
    }
}
