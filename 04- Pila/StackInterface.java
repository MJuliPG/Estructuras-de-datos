/** Operaciones de la Pila (diapositiva "Interface Pila / Stack"). LIFO: ultimo en entrar, primero en salir. */
public interface StackInterface {
    public void clear();
    public boolean isEmpty();
    public Object peek();                 // ver la cima SIN sacarla
    public Object pop();                  // sacar la cima
    public boolean push(Object object);   // meter en la cima
    public int size();
    public boolean search(Object object);
    public void sort();
    public void reverse();
    public String toString();
}
