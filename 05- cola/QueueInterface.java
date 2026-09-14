public interface QueueInterface {
    public void clear();
    public boolean isEmpty();
    public Object extract();                 // sacar por el FRENTE (head)
    public boolean insert(Object object);    // meter por el FINAL (tail)
    public int size();
    public boolean search(Object object);
    public void sort();
    public void reverse();
    public String toString();
}
