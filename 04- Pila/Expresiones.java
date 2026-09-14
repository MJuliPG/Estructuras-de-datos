
public class Expresiones {

    public static void main(String[] args) {
        infijaAPosfija("5 + 3 * 2");                       
        evaluarPosfija("5 3 2 * +");                       
        infijaAPosfija("Z - (A + B) * C");                 
        infijaAPosfija("A + B * (C - D) / E + F * G");     
        evaluarPosfija("2 3 4 * + 5 -");                   
        System.out.println("\"(a+[b*c])\" balanceado? " + parentesisBalanceados("(a+[b*c])"));
        System.out.println("\"(a+b))\"    balanceado? " + parentesisBalanceados("(a+b))"));
    }

    static int prioridad(String op) {
        switch (op) {
            case "^": return 3;
            case "*": case "/": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }

    static boolean esOperador(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^");
    }

    static String[] tokens(String expresion) {
        expresion = expresion.replace('–', '-').replace('—', '-').replace('×', '*');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c) || c == '.') {
                sb.append(c);
                if (i + 1 < expresion.length() && (Character.isDigit(expresion.charAt(i + 1)) || expresion.charAt(i + 1) == '.')) continue;
            } else {
                sb.append(c);
            }
            sb.append(' ');
        }
        return sb.toString().trim().split(" ");
    }


    static String infijaAPosfija(String infija) {
        ListStack pila = new ListStack();
        StringBuilder salida = new StringBuilder();

        System.out.println("\nINFIJA: " + infija);
        System.out.printf("%-9s| %-40s| %-12s| %s%n", "Elemento", "Operacion", "Pila", "Salida");
        System.out.println("---------------------------------------------------------------------------");

        for (String t : tokens(infija)) {
            String operacion;
            if (t.equals("(")) {
                pila.push(t);
                operacion = "Push (";
            } else if (t.equals(")")) {
                operacion = "Pop hasta (: ";
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    String sacado = (String) pila.pop();
                    salida.append(sacado).append(" ");
                    operacion += sacado + " ";
                }
                pila.pop();                                   
                operacion += "(descarto ( )";
            } else if (esOperador(t)) {
                operacion = "";
                while (!pila.isEmpty() && prioridad((String) pila.peek()) >= prioridad(t)) {
                    String sacado = (String) pila.pop();
                    salida.append(sacado).append(" ");
                    operacion += "Pop " + sacado + " (prio >=), ";
                }
                pila.push(t);
                operacion += "Push " + t;
            } else {
                salida.append(t).append(" ");
                operacion = "Imprimo " + t;
            }
            System.out.printf("%-9s| %-40s| %-12s| %s%n", t, operacion, pilaComoLista(pila), salida.toString().trim());
        }
        while (!pila.isEmpty()) salida.append(pila.pop()).append(" ");
        System.out.printf("%-9s| %-40s| %-12s| %s%n", "(fin)", "Vaciar la pila", "[]", salida.toString().trim());
        System.out.println("POSFIJA: " + salida.toString().trim());
        return salida.toString().trim();
    }

    
    static double evaluarPosfija(String posfija) {
        ListStack pila = new ListStack();
        System.out.println("\nEVALUAR POSFIJA: " + posfija);
        System.out.printf("%-9s| %-30s| %s%n", "Elemento", "Operacion", "Pila");
        System.out.println("-----------------------------------------------------------");

        for (String t : tokens(posfija)) {
            if (esOperador(t)) {
                double op2 = (Double) pila.pop();
                double op1 = (Double) pila.pop();
                double r;
                switch (t) {
                    case "+": r = op1 + op2; break;
                    case "-": r = op1 - op2; break;
                    case "*": r = op1 * op2; break;
                    case "/": r = op1 / op2; break;
                    default:  r = Math.pow(op1, op2);
                }
                pila.push(r);
                System.out.printf("%-9s| %-30s| %s%n", t, fmt(op1) + " " + t + " " + fmt(op2) + " = " + fmt(r) + " (push)", pilaComoLista(pila));
            } else {
                pila.push(Double.parseDouble(t));
                System.out.printf("%-9s| %-30s| %s%n", t, "Push " + t, pilaComoLista(pila));
            }
        }
        double resultado = (Double) pila.pop();
        System.out.println("RESULTADO: " + fmt(resultado));
        return resultado;
    }

    static boolean parentesisBalanceados(String s) {
        ListStack pila = new ListStack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;
                char abre = (Character) pila.pop();
                if ((c == ')' && abre != '(') || (c == ']' && abre != '[') || (c == '}' && abre != '{')) return false;
            }
        }
        return pila.isEmpty();
    }

    static String pilaComoLista(ListStack pila) {
        ListStack aux = new ListStack();
        for (StackNode t = pila.top; t != null; t = t.below) aux.push(t.object);   
        StringBuilder sb = new StringBuilder("[");
        for (StackNode t = aux.top; t != null; t = t.below) {
            Object o = t.object;
            sb.append(o instanceof Double ? fmt((Double) o) : o).append(t.below != null ? "," : "");
        }
        return sb.append("]").toString();
    }

    static String fmt(double d) {
        return d == Math.floor(d) ? String.valueOf((long) d) : String.valueOf(d);
    }
}
