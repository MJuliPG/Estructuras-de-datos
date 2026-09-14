public class Main {
    public static void main(String[] args) {
        List lista = new List();
        lista.add(6);
        lista.add(8);
        lista.add(2);
        lista.add(7);
        lista.print();                                   // 6 -> 8 -> 2 -> 7 -> null

        lista.insertHead(1);        System.out.print("insertHead(1):        "); lista.print();
        lista.insertTail(9);        System.out.print("insertTail(9):        "); lista.print();
        lista.insertBefore(5, 2);   System.out.print("insertBefore(5, 2):   "); lista.print();
        lista.insertAfter(3, 8);    System.out.print("insertAfter(3, 8):    "); lista.print();
        lista.remove(1);            System.out.print("remove(1) cabeza:     "); lista.print();
        lista.remove(9);            System.out.print("remove(9) cola:       "); lista.print();
        lista.remove(5);            System.out.print("remove(5) medio:      "); lista.print();
        lista.update(8, 80);        System.out.print("update(8, 80):        "); lista.print();

        System.out.println("contains(2)=" + lista.contains(2) + "  indexOf(2)=" + lista.indexOf(2)
                + "  size=" + lista.getSize() + "  head=" + lista.getHead() + "  tail=" + lista.getTail());
        System.out.println("antes del 2: " + lista.getBeforeTo(lista.search(2))
                + " | despues del 2: " + lista.getNextTo(lista.search(2)));

        lista.sortList();           System.out.print("sortList():           "); lista.print();
        lista.reverse();            System.out.print("reverse():            "); lista.print();
        lista.shuffle();            System.out.print("shuffle():            "); lista.print();

        List otra = new List();
        otra.add("C"); otra.add("A"); otra.add("B");
        System.out.println("Strings ordenados: " + otra.sortList());
    }
}
