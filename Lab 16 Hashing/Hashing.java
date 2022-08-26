package lab16hashing;

public class Hashing {
	
    /*
    a. ¿Qué ocurre con las funciones de inserción, búsqueda y eliminación cuando el
factor de carga es cercano a 1?
    R: tienden a demorar más porque tienen que recorrer los nodos que ya hay para realizar la operación
    
    b. Describa los pasos a realizar para duplicar el tamaño de la tabla Hash y reducir
el factor de carga. ¿Para qué valor de 𝛼 es necesario realizar este proceso?
    R: hay que crear una nueva tabla con el doble de tamaño e insertar los nodos de la primera tabla.
    
    */
    
	class Nodo{
		int key;
                Nodo hermano;
		public Nodo(int k,Nodo h) {
                        hermano=h;
			key = k;
		}
	}

	Nodo [] T;
	
	public Hashing(int m) {
		T = new Nodo[m];
		for(int i = 0; i < m; i++) T[i] = null;
	}
	
	// Implementar
	// return true si fue posible insertar
	// false en otro caso
	public boolean insertar(int key) {
            if(buscar(key)!=null){ return false;} // revisa si esta ya en T
            if(T[h1(key)]==null){       // si no hay nada en la posicion h1(key)
                T[h1(key)]= new Nodo(key,null);
                return true;
            }else{
                Nodo k=T[h1(key)];
                while(k.hermano!=null) {   // pone el nodo en el ultimo hermano                 
                    k=k.hermano;
                }
                k.hermano=new Nodo(key,null);
                return true;
            }
	}
	
	// Implementar
	// Si la clave no existe, return null
	public Nodo buscar(int key) {
            int i=h1(key);
            Nodo n=T[i];
            if(T[i]==null){
                return null;    
            }
            
            while(n.hermano!=null){ // recorre el arreglo T hasta encontrar el numero 
                if(n.key==key){
                    return n;
                }
                n=n.hermano;
            }
            return null;
	}
	
	// Implementar
	// return true si fue posible eliminar
	// false en otro caso
	public boolean eliminar(int key) {
            int i=h1(key);
            
            Nodo n=T[i];
            Nodo f=n;
            if(T[i]==null){
                return false;
            }
            
            while(n.hermano!=null){
                if(n.key==key){
                   f.hermano=n.hermano;
                   return true;
                }
                f=n;
                n=n.hermano;
            }
            
            return false;
	}
        
        public float factorCarga(){
            float cont=0;
            for (int j = 0; j < T.length; j++) {    
                if(T[j]!=null){ cont++;}            // cuenta cuantas pocicione estan ocupadas
            }
            return cont/T.length;   // el resultado es la cantidad ocupada dividido por la cantidad de posiciones
        }
	
	
	int h(int k, int i) {
		return (h1(k) + (i * h2(k))) % T.length;
	}
	
	int h1(int k) {
		return k % T.length;
	}
	
	int h2(int k) {
		return 1 + (k % (T.length-1));
	}
	
}
