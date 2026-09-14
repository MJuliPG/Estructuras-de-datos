import java.util.Scanner;

/**
 * EJERCICIO DE CLASE: Baraja de poker (52 cartas) usando SOLO nuestra List.
 * 1) Crear e imprimir ordenada por palos y numeros (A, J, Q, K).
 * 2) Menu: 1. Revolver (shuffle)  2. Ordenar un palo (subLista + sortList)  3. Salir
 */
public class BarajaPoker {

    public static void main(String[] args) {
        List baraja = crearBaraja();
        System.out.println("Baraja inicial:");
        imprimirBaraja(baraja);

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1. Revolver la baraja\n2. Ordenar por un palo\n3. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    baraja.shuffle();
                    System.out.println("Baraja revuelta:");
                    imprimirBaraja(baraja);
                    break;
                case 2:
                    System.out.print("Palo (C, D, P, T): ");
                    char palo = Character.toUpperCase(sc.next().charAt(0));
                    List delPalo = extraerPalo(baraja, palo);
                    delPalo.sortList();
                    System.out.println("Cartas de " + palo + " ordenadas: " + delPalo);
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 3);
    }

    static List crearBaraja() {
        List baraja = new List();
        char[] palos = {'C', 'D', 'P', 'T'};
        for (char palo : palos) {
            for (int numero = 1; numero <= 13; numero++) {
                baraja.add(new Carta(numero, palo));
            }
        }
        return baraja;
    }

    static List extraerPalo(List baraja, char palo) {
        List resultado = new List();
        ListNode temp = baraja.head;
        while (temp != null) {
            Carta c = (Carta) temp.object;       
            if (c.palo == palo) {                
                resultado.add(c);
            }
            temp = temp.next;
        }
        return resultado;
    }

    static void imprimirBaraja(List baraja) {
        ListNode temp = baraja.head;
        int contador = 0;
        while (temp != null) {
            System.out.print(temp.object + "\t");
            contador++;
            if (contador % 13 == 0) System.out.println();
            temp = temp.next;
        }
    }
}
