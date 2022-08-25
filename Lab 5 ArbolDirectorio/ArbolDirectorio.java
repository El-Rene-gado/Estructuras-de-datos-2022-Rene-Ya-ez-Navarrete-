package lab.pkg5.arboldirectorio;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Rene Yañez
 */

public class ArbolDirectorio {
	
	private class Carpeta{
		String nombre;
		LinkedList<Carpeta> hijos;
		public Carpeta(String nombre) {
			this.nombre = nombre;
			hijos = new LinkedList<Carpeta>();
		}
	}
	
	private Carpeta root;
	
	public ArbolDirectorio() {
		root = new Carpeta("root");
	}
	
	/*
	 * Dado un path del formato 'root/carpeta_1/.../carpeta_n', retornar el objeto CarpetaN
	 * En caso de no encontrarlo, retornar Null
	 */
	private Carpeta ir(String path) {
		StringTokenizer stPath = new StringTokenizer(path,"/");
		String nombreCarpeta;
		if(stPath.countTokens() == 1) return root;
		stPath.nextToken();
		Carpeta c = root;
		boolean encontrado = false;
		while(stPath.hasMoreTokens()) {
			nombreCarpeta = stPath.nextToken();
			encontrado = false;
			for(Carpeta h : c.hijos) {
				if(h.nombre.equals(nombreCarpeta)) {
					c = h;
					encontrado = true;
					break;
				}
			}
			if(!encontrado) return null;
		}
		return c;
	}
	
	/*
	 * Retornar la cantidad total de carpetas que posee el �rbol de directorios
	 */
	public int size() {
            
            return size(root);
	}
        
        public int size(Carpeta a){
            if(a==null)return 0;
            int cont=1;
            if(a.hijos.isEmpty())return cont;
            for(int i=0;i<a.hijos.size();i++){
                cont+=size(a.hijos.get(i));
            }
            
            return cont;
        }
	
	/*
	 * Dado un path del formato 'root/carpeta_1/.../carpeta_n' y un nombre de nueva carpeta, crear una nueva carpeta al 
	 * interior de la CarpetaN y retornar true
	 * Si no se consigue, retornar false
	 * CONDICION: no pueden haber dos carpetas en el mismo directorio con el mismo nombre
	 */
	public boolean crearCarpeta(String path, String nombre) {
            Carpeta carpetaContenedora = ir(path);
            if(carpetaContenedora==null) return false;
            if(isCarpeta(carpetaContenedora.hijos, nombre)) return false;
            
            carpetaContenedora.hijos.add(new Carpeta(nombre));
            return true;
	}
	
	/*
	 * Mover la carpeta a la que apunta path1 ('root/carpeta_1/.../carpeta_n') al interior de la carpeta apuntada por 
	 * path2 ('root/carpeta_1/.../carpeta_m'), de tal forma que las subcarpetas de carpetaN sean movidas como subcarpetas de 
	 * CarpetaM.
	 * En caso de conseguirlo, retornar true, si no, retornar false
	 * CONDICION: no pueden haber dos carpetas en el mismo directorio con el mismo nombre. 
	 * Si se da el caso, cancele toda la operaci�n
	 */
	public boolean mover(String path1, String path2) {
            Carpeta aMover=ir(path1);
            Carpeta destino=ir(path2);
            for(int i=0;i<aMover.hijos.size();i++){
                if(isCarpeta(destino.hijos, aMover.hijos.get(i).nombre)) return false;
            }
            destino.hijos.addAll(aMover.hijos);
            eliminarCarpeta(path1);
            return true;
	}
	
	/*
	 * Dada una lista de hermanos, averiguar si en su interior se encuentra una con el nombre entregado como par�metro
	 */
	private boolean isCarpeta(LinkedList<Carpeta> hermanos, String nombre) {
		for(Carpeta h : hermanos) {
			if(h.nombre.equals(nombre)) return true;
		}
		return false;
	}
	
	/*
	 * Eliminar la carpeta carpetaN ubicada en path ('root/carpeta_1/.../carpeta_n') junto a todo su subarbol
	 * Usted elige la politica de eliminaci�n del nodo raiz
	 */
	public boolean eliminarCarpeta(String path) {
            if(path==""){
                System.out.println("No sea wea, es la raiz.");
                return false;
            }
            Carpeta aEliminar=ir(path);
            StringTokenizer stPath = new StringTokenizer(path,"/");
            String newPath="";
            int a=stPath.countTokens();
            for (int i = 0; i < a-1; i++) {
                newPath=newPath+stPath.nextToken();
            }
            Carpeta contenedor = ir(newPath);
            contenedor.hijos.remove(aEliminar);
            return true;
	}
	
	public void print() {
		System.out.println("==================");
		System.out.println(root.nombre);
		print(root, 1);
		System.out.println("==================");
	}
	
	private void print(Carpeta c, int nivel) {
		String l = "";
		for(int i = 0; i < nivel; i++) l += "-";
		
		for(Carpeta h : c.hijos) {
			System.out.println(l+h.nombre);
			print(h, nivel+1);
		}
	}
	
}