/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract.pkg3.lista;

/**
 *
 * @author Prueba
 */
class Lista { 
 private Nodo laCabeza;
 Lista() { 
    laCabeza = null;
 } 
 //---Inserta un objeto(int) al comienzo de la lista
 public void InsertaInicio(int o) {
  if (EstaVacia()) laCabeza=new Nodo(o, null);
  else  laCabeza = new Nodo(o, laCabeza);
}

//---- Inserta al final ----
public void InsertaFinal(int o) {
  if (EstaVacia()) laCabeza=new Nodo(o, null);
   else{
         Nodo t;
         for(t = laCabeza; t.next != null; t= t.next) ;
         t.next = new Nodo(o,null);
     }
 }

    public int[] getInt() {
        Nodo t=laCabeza;
        int prom=RetornaPromedio();
        int[] listaPrev=new int[Size()];
        for (int i = 0; i < Size(); i++) {
            if(t.elObjeto>prom){
                listaPrev[i]=t.elObjeto;
                
            }
            t=t.next;
        }
        
        
        return listaPrev;
    }

    
// ---cuenta la cantidad de nodos de la lista (Size)
public int Size() {
 int tnodos=0;
 for(Nodo t = laCabeza; t !=null; t= t.next)  tnodos++;
 return tnodos;
}

//eliminar un nodo de la lista 
// Elimina el primer nodo n tal que o.elObjeto==o 
public void Eliminar(int o) { 
 if(!EstaVacia()) { 
  if(laCabeza.elObjeto==o) laCabeza = laCabeza.next;
   else { 
     Nodo p = laCabeza;
     Nodo t = laCabeza.next; 
     while (t !=null && t.elObjeto != o)  { 
      p = t ; t = t.next;
     } 
     if(t.elObjeto==o) p.next = t.next;
    }
 }
}

// Verifica si la lista está vacias;
public boolean EstaVacia() {
return laCabeza == null;
}

//-----Imprime la lista-----
void Print() {
   if(laCabeza!=null) Imprimir(laCabeza);
    else System.out.println("Lista Vacia");
    }

 void Imprimir(Nodo m ) {
    if(m !=null) {m.Print(); Imprimir(m.next);}
  }

public int RetornaPromedio(){
    int a=0;
    int cant=0;
    if(EstaVacia()==true)return a;
    for(Nodo t = laCabeza; t !=null; t= t.next) {
        a=a+t.elObjeto;       
        cant++;
    }
    
    return a/cant;
}
 
//-----Clase Nodo--------- 
 private class Nodo { 
  public int elObjeto;
  public Nodo next;
  public Nodo(int nuevoObjeto, Nodo next)
  {this.elObjeto=nuevoObjeto; this.next = next;} 
  void Print(){ System.out.print("- " + elObjeto);}
 }

}