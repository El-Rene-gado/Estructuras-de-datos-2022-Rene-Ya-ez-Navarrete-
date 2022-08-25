package lab.pkg6.jueves;
import javax.print.attribute.standard.NumberOfDocuments;
import java.util.LinkedList;
import java.util.Stack;


// Cristian Pinilla && Rene Yañez


public class Main {

    public static void main(String[] args) {
        Stack<ArbolBinario> nodos=new Stack<>();
        
        for (int i = 0; i < 10; i++) {
            nodos.add(new ArbolBinario(i));
        }
        
        while(nodos.size()>1){
            ArbolBinario iz=nodos.pop();
            ArbolBinario der=nodos.pop();
            nodos.push(new ArbolBinario(iz.dato+der.dato,iz,der));
        }
        ArbolBinario raiz=nodos.pop();
        System.out.println("Altura del arbol: "+raiz.altura());
        System.out.println("Tamaño del arbol (total de nodos): "+ raiz.size());
        raiz.tree();

        ArbolBinario[] nodos2=new ArbolBinario[32];
        for (int i = 0; i < nodos2.length; i++) {
            nodos2[i]=new ArbolBinario(i);
        }
        ArbolBinario raiz2=generaBinario(nodos2, 0, 31);
        System.out.println("Altura del arbol: "+raiz2.altura());
        System.out.println("Tamaño del arbol (total de nodos): "+ raiz2.size());
        raiz2.tree();
        
        LinkedList<ArbolBinario> lista= raiz2.rango(11, 22);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa \n");
        
        for (int i = 0; i < lista.size(); i++) {
           lista.get(i).imprime(); 
        }
        
        
        

    }

    public static ArbolBinario generaBinario(ArbolBinario[] nodos, int i, int j){
        if(i>j){
            return null;
        }
        int mitad=(i+j)/2;
        nodos[mitad].iz=generaBinario(nodos, i,mitad-1);
        nodos[mitad].der=generaBinario(nodos,mitad+1,j);
        return nodos[mitad];
    }
}
