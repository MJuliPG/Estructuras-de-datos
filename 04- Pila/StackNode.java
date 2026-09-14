public class StackNode {
    public Object object;
    public StackNode below;   

    public StackNode() {
        this.object = null;
        this.below = null;
    }

    public StackNode(Object object) {
        this.object = object;
        this.below = null;
    }
}
