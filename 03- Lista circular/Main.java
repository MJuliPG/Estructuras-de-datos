public class Main {
    public static void main(String[] args) {
        CircularList lista = new CircularList();
        lista.add('A'); lista.add('B'); lista.add('C'); lista.add('D');
        System.out.print("Opcion 1 (do-while): "); lista.print();
        System.out.print("Opcion 2 (size):     "); lista.printConSize();
        System.out.print("10 pasos (da vueltas): "); lista.printVueltas(10);

        lista.update('C', 'Z');      System.out.print("update('C','Z'):     "); lista.print();
        lista.updateWhile('D', 'W'); System.out.print("updateWhile('D','W'):"); lista.print();
        lista.insertHead('0');       System.out.print("insertHead('0'):     "); lista.print();
        lista.insertBefore('X', 'Z');System.out.print("insertBefore(X, Z):  "); lista.print();
        lista.delete('0');           System.out.print("delete cabeza:       "); lista.print();
        lista.delete('W');           System.out.print("delete cola:         "); lista.print();
        lista.delete('X');           System.out.print("delete medio:        "); lista.print();
        System.out.println("tail.next = " + lista.tail.next.object + " (debe ser la cabeza " + lista.head.object + ")");
        System.out.println("indexOf('Z')=" + lista.indexOf('Z') + " size=" + lista.getSize());

        System.out.println("\n--- Doble circular ---");
        DoubleCircularList dc = new DoubleCircularList();
        dc.insertTail(1); dc.insertTail(2); dc.insertTail(3); dc.insertHead(0);
        System.out.print("Adelante: "); dc.printAdelante();
        System.out.print("Atras:    "); dc.printAtras();
        dc.delete(0); dc.delete(3);
        System.out.print("Sin 0 y 3: "); dc.printAdelante();
    }
}
