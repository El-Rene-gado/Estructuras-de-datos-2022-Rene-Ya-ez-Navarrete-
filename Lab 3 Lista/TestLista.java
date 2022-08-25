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
public class TestLista {

	public static void main(String [] args) {
		Lista lista1 = new Lista();
                lista1.InsertaInicio(7);
                lista1.InsertaInicio(8);
                lista1.InsertaInicio(9);
                lista1.InsertaInicio(10);
                lista1.InsertaInicio(11);
                lista1.InsertaInicio(12);
                lista1.InsertaInicio(1);
                lista1.InsertaInicio(2);
                lista1.InsertaInicio(3);
                lista1.InsertaInicio(4);
                lista1.InsertaInicio(5);
                lista1.InsertaInicio(6);
                
                
                System.out.println("Lista: ");
                lista1.Print();
                System.out.println("\n");
                System.out.println("Promedio: "+ +lista1.RetornaPromedio()+"\n");
                
                Lista lista2 = new Lista();
                int[] a=lista1.getInt();
                
		for (int i = 0; i < a.length; i++) {
                    if(a[i]!=0){
                    lista2.InsertaInicio(a[i]);
                    }
                    
                }
                
                lista2.Print();
                
            }
                
                
	}

