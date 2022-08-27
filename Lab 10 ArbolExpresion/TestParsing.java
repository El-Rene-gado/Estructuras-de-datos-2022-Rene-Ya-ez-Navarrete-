package lab.pkg10;

import java.util.Scanner;
public class TestParsing {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese su expresión: ");
        String expresion = in.next();
        in.close();
        String salida = Parsing.fromInfijoToPostfijo(expresion);
        System.out.print("Expresion postfija: " + salida);
        ArbolExpresion a = Parsing.getArbol(salida);
        System.out.println("\n\tEXPRESION: \n");
        a.print(0);
    }
}


