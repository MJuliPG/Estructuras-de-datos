public class ListStack implements StackInterface {

    StackNode top;
    int size = 0;

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { return top == null; }
    
    @Override
    public boolean push(Object object) {
        StackNode nuevo = new StackNode(object);
        nuevo.below = top;
        top = nuevo;
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;
        Object dato = top.object;
        top = top.below;
        size--;
        return dato;
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : top.object;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean search(Object object) {
        StackNode temp = top;
        while (temp != null) {
            if (temp.object.equals(object)) return true;
            temp = temp.below;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        ListStack aux = new ListStack();         
        while (!isEmpty()) {
            Object actual = pop();
            while (!aux.isEmpty() && ((Comparable<Object>) aux.peek()).compareTo(actual) < 0) {
                push(aux.pop());
            }
            aux.push(actual);
        }
        while (!aux.isEmpty()) push(aux.pop());
    }

    @Override
    public void reverse() {
        StackNode anterior = null, actual = top;
        while (actual != null) {
            StackNode siguiente = actual.below;
            actual.below = anterior;
            anterior = actual;
            actual = siguiente;
        }
        top = anterior;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[cima] ");
        for (StackNode t = top; t != null; t = t.below) sb.append(t.object).append(" ");
        return sb.append("[fondo]").toString();
    }
}
