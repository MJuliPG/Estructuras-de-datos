public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pila con ARREGLO (capacidad 5) ===");
        ArrayStack a = new ArrayStack(5);
        a.push(3); a.push(1); a.push(4); a.push(1); a.push(5);
        a.push(9);                                    // llena -> overflow
        System.out.println(a + "  size=" + a.size());
        System.out.println("peek=" + a.peek() + "  pop=" + a.pop() + "  ahora: " + a);
        a.sort();    System.out.println("sort:    " + a);
        a.reverse(); System.out.println("reverse: " + a);

        System.out.println("\n=== Pila con NODOS ===");
        ListStack p = new ListStack();
        p.push("A"); p.push("B"); p.push("C"); p.push("D");
        System.out.println(p + "  size=" + p.size());
        System.out.println("pop=" + p.pop() + " (LIFO: sale el ultimo)  ahora: " + p);
        System.out.println("search(\"B\")=" + p.search("B"));
        p.reverse(); System.out.println("reverse: " + p);
        ListStack n = new ListStack();
        n.push(7); n.push(2); n.push(9); n.push(4);
        n.sort();    System.out.println("sort (mayor en la cima): " + n);

        // Ctrl+Z con una pila
        ListStack historial = new ListStack();
        historial.push("escribir Hola"); historial.push("negrita"); historial.push("borrar linea");
        System.out.println("\nCtrl+Z deshace: " + historial.pop() + ", luego: " + historial.pop());
    }
}
