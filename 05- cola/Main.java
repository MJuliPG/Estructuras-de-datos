public class Main {
    public static void main(String[] args) {
        System.out.println("=== COLA normal (FIFO) - fila del banco ===");
        Queue cola = new Queue();
        cola.insert("Ana"); cola.insert("Juan"); cola.insert("Pedro"); cola.insert("Luisa");
        System.out.println(cola + "  size=" + cola.size());
        System.out.println("extract() = " + cola.extract() + "  (sale el PRIMERO que llego)");
        System.out.println("extract() = " + cola.extract());
        System.out.println(cola + "  search(\"Pedro\")=" + cola.search("Pedro"));
        cola.insert("Carlos");
        cola.reverse(); System.out.println("reverse: " + cola);
        cola.sort();    System.out.println("sort:    " + cola);

        System.out.println("\n=== COLA DE PRIORIDAD - triage urgencias (1 = rojo ... 5 = azul) ===");
        Queue urgencias = new Queue(true);
        urgencias.insert("Paciente1-gripa", 5);
        urgencias.insert("Paciente2-fractura", 3);
        urgencias.insert("Paciente3-infarto", 1);
        urgencias.insert("Paciente4-corte", 4);
        urgencias.insert("Paciente5-quemadura", 2);
        urgencias.insert("Paciente6-fractura", 3);    // misma prioridad que P2 -> va despues (FIFO)
        System.out.println(urgencias);
        System.out.print("Orden de atencion: ");
        while (!urgencias.isEmpty()) System.out.print(urgencias.extract() + " | ");
        System.out.println();

        System.out.println("\n=== COLA CIRCULAR con arreglo (capacidad 3) ===");
        ArrayQueue aq = new ArrayQueue(3);
        aq.insert(1); aq.insert(2); aq.insert(3);
        System.out.println(aq + " llena? " + aq.isFull() + "  insert(4)=" + aq.insert(4));
        System.out.println("extract=" + aq.extract() + "  insert(4)=" + aq.insert(4) + "  " + aq);
    }
}
