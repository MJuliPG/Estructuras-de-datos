/**
 * 
 *   null <-- [ prev | object | next ] <--> [ prev | object | next ] --> null
 */
public class DoubleListNode {
    public DoubleListNode prev;  
    public Object object;         
    public DoubleListNode next;   

    public DoubleListNode(Object object) {
        this.prev = null;
        this.object = object;
        this.next = null;
    }
}
