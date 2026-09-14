public class Main {
    public static void main(String[] args) {
        DoubleList lista = new DoubleList();
        lista.add(6); lista.add(4); lista.add(1); lista.add(3);   
        System.out.print("Inicial:             "); lista.printForward();
        System.out.print("De fin a inicio:     "); lista.printBackward();

        lista.update(1, 0);         System.out.print("update(1, 0):        "); lista.printForward();
        lista.delete(0);            System.out.print("delete(0) medio:     "); lista.printForward();
        lista.delete(6);            System.out.print("delete(6) cabeza:    "); lista.printForward();
        lista.delete(3);            System.out.print("delete(3) cola:      "); lista.printForward();
        lista.insertHead(6);        System.out.print("insertHead(6):       "); lista.printForward();
        lista.insertTail(9);        System.out.print("insertTail(9):       "); lista.printForward();
        lista.insertBefore(5, 4);   System.out.print("insertBefore(5, 4):  "); lista.printForward();
        lista.insertAfter(7, 4);    System.out.print("insertAfter(7, 4):   "); lista.printForward();
        System.out.print("De fin a inicio:     "); lista.printBackward();
        lista.reverse();            System.out.print("reverse():           "); lista.printForward();
        System.out.println("size=" + lista.getSize() + " contains(7)=" + lista.contains(7) + " indexOf(7)=" + lista.indexOf(7));
    }
}
