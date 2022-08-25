package lab.pkg9.arbol;

import java.lang.*;    

/*	Conclusión lab 9
	1) ¿Cuál estructura es más eficiente a la hora de realizar búsquedas? ¿Por qué? 
R: Es el AVL en cada caso porque es un árbol binario balanceado, de tal forma que su estructura de búsqueda es de orden O(logN), 
y solo hay que hacer comparaciones de si es mayor, menor o igual.

	2) ¿Cuál estructura es más eficiente a la hora de realizar inserciones? ¿Por qué?
R: Por lo general es el BST ya que no necesita ordenarse después de cada inserción, 
sin embargo en el caso de la inserción de una gran cantidad de números que vallan solo incrementando 
(Por ejemplo ingresando los números del 1 al 100000 de forma ordenada) o disminuyendo, 
es más eficiente el AVL al estar siempre balanceado.

*/

public class TestMain {
    public static void main(String[] args) {
	BSTree tree1 =new BSTree();
        AvlTree tree2=new AvlTree();
        
        
        long timeBST1 = System.nanoTime();
        int cont10000 =1;
        while(cont10000<2001){          // Originalmente todos los while tenian hasta el 20.000 pero al traspasarlo de un pc a otro tuve que cambiarlo sino daba error
            tree1.insert(cont10000);
            cont10000++;
        }
        long timeBST2 = System.nanoTime();
        long timeBST=timeBST2-timeBST1;
        
        
        long timeAVL1 = System.nanoTime();
        cont10000 =1;
        while(cont10000<2001){
            tree2.insert(cont10000);
            cont10000++;
        }
        long timeAVL2 = System.nanoTime();
        long timeAVL=timeAVL2-timeAVL1;
        
        System.out.println("BSTree "+timeBST); 
        System.out.println("AVL "+timeAVL);
        
        
        System.out.println("====================================");
        
        long timeBSTbusca1 = System.nanoTime();
        cont10000 =1;
        while(cont10000<2001){
            tree1.search(cont10000);
            cont10000++;
        }
        long timeBSTbusca2 = System.nanoTime();
        long timeBSTbusca=timeBSTbusca2-timeBSTbusca1;
        
        
        long timeAVLbusca1 = System.nanoTime();
        cont10000 =1;
        while(cont10000<2001){
            tree2.search(cont10000);
            cont10000++;
        }
        long timeAVLbusca2 = System.nanoTime();
        long timeAVLbusca=timeAVLbusca2-timeAVLbusca1;
        
        System.out.println("Busca BSTree "+timeBSTbusca);
        System.out.println("Busca AVL "+timeAVLbusca);
        
        
        System.out.println("====================================");
        
        long timeBSTNotFound1 = System.nanoTime();
        cont10000 =2000;
        while(cont10000<4001){
            tree1.search(cont10000);
            cont10000++;
        }
        long timeBSTNotFound2 = System.nanoTime();
        long timeBSTNotFound=timeBSTNotFound2-timeBSTNotFound1;
        
        
        long timeAVLNotFound1 = System.nanoTime();
        cont10000 =2000;
        while(cont10000<4001){
            tree2.search(cont10000);
            cont10000++;
        }
        long timeAVLNotFound2 = System.nanoTime();
        long timeAVLNotFound=timeAVLNotFound2-timeAVLNotFound1;
        
        System.out.println("Busca lo que no esta BSTree "+timeBSTNotFound);
        System.out.println("Busca lo que no esta AVL "+timeAVLNotFound);
        
    }

}
