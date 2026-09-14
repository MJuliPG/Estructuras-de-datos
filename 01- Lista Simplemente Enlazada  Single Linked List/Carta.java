/** Carta de poker. Palos: 'C' corazones, 'D' diamantes, 'P' picas, 'T' treboles. */
public class Carta implements Comparable<Carta> {
    static boolean USAR_SIMBOLOS = true;

    int numero;   
    char palo;    // 'C', 'D', 'P', 'T'

    public Carta(int numero, char palo) {
        this.numero = numero;
        this.palo = palo;
    }

  
    public String figura() {
        switch (numero) {
            case 1:  return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(numero);
        }
    }

    public String simbolo() {
        if (!USAR_SIMBOLOS) return String.valueOf(palo);
        switch (palo) {
            case 'C': return "♥";   // corazon
            case 'D': return "♦";   // diamante
            case 'P': return "♠";   // pica
            default:  return "♣";   // trebol
        }
    }

    @Override
    public int compareTo(Carta otra) {
        String orden = "CDPT";
        int diferenciaPalo = orden.indexOf(this.palo) - orden.indexOf(otra.palo);
        if (diferenciaPalo != 0) return diferenciaPalo;
        return this.numero - otra.numero;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carta)) return false;
        Carta c = (Carta) o;
        return c.numero == numero && c.palo == palo;
    }

    @Override
    public String toString() {
        return figura() + simbolo();
    }
}
