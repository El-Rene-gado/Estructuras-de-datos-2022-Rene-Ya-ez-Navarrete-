package lab.pkg10;

import java.util.Stack;

public class Parsing {

    public static String fromInfijoToPostfijo(String infijo) {
        String salida = "";
        Stack<Character> pila = new Stack<Character>();
        char[] chars = infijo.toCharArray();

        for (char C : chars) {
            if (isANumber(C)) {
                salida += C;
            } else if (prioridad(C) == 0) {
                pila.push(C);
            } else if (prioridad(C) == -1) {
                while (pila.peek() != '(') {
                    salida += pila.pop();
                }
                pila.pop();
            } else if (prioridad(C) == 1 || prioridad(C) == 2) {
                if (pila.isEmpty()){
                    pila.push(C);
                } else {
                    if (prioridad(C) > prioridad(pila.peek())) {
                        pila.push(C);
                    } else {
                        salida += pila.pop();
                        pila.push(C);
                    }
                }
            }
        }
        while (!pila.isEmpty()) {
            salida += pila.pop();
        }
        return salida;
    }

    private static boolean isANumber(char symbol) {
        return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' ||
                symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' ||
                symbol == '8' || symbol == '9';
    }

    private static int prioridad(char symbol) {
        if(symbol == '(') return 0;
        if(symbol == '+' || symbol == '-') return 1;
        if(symbol == '*' || symbol == '/') return 2;
        return -1;
    }


    public static ArbolExpresion getArbol(String postfijo) {
        char[] C = postfijo.toCharArray();
        Stack<ArbolExpresion> pila2 = new Stack<>();
        for (int i = 0; i < C.length; i++) {
            ArbolExpresion tree = new ArbolExpresion(C[i]);
            if (isANumber(C[i])) {
                pila2.push(tree);
            } else {
                tree.left = pila2.pop();
                tree.right = pila2.pop();
                pila2.push(tree);
            }
        }
        return pila2.peek();
    }

    public static int calcular(ArbolExpresion x) {
        if (x == null) return 0;
        int valor = calcular(x.right);
        int resultado = 0;
        if (isANumber(x.symbol)) {
            resultado = Character.getNumericValue(x.symbol);
        } else if (prioridad(x.symbol) == 1 || prioridad(x.symbol) == 2) {
            switch (x.symbol) {
                case '+':
                    resultado = valor + calcular(x.left);
                    break;
                case '-':
                    resultado = valor - calcular(x.left);
                    break;
                case '*':
                    resultado = valor * calcular(x.left);
                    break;
                case '/':
                    resultado = valor / calcular(x.left);
                    break;
            }
        }
        return resultado;
    }
}