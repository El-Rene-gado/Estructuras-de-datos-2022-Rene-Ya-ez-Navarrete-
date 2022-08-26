/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.leetcode;

import java.util.ArrayList;

/**
 *
 * @author Rene Yañez
 */
class Solution {
    
    /*
    There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
    The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes 
    a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, 
    no vertex has an edge to itself.

    You want to determine if there is a valid path that exists from vertex source to vertex destination.
    Given edges and the integers n, source, and destination, return true if there is a valid path from source 
    to destination, or false otherwise.
    */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] grafo = new ArrayList[n];  // se crea el grafo, el array list es solo por si las dudas se puede hecer de con arreglos
        for (int i = 0; i < n; ++i) {
            grafo[i] = new ArrayList<>();
        }
        
        for (int[] arista : edges) {    // se llena el array de grafo con las aristas
            grafo[arista[0]].add(arista[1]);
            grafo[arista[1]].add(arista[0]);
        }
        
        boolean[] visto = new boolean[n];  // arregloa para almacenar si fue visto el vertice
        return tieneCamino(grafo, visto, source, destination);
    }

    public boolean tieneCamino(ArrayList<Integer> []grafo, boolean []visto, int inicio, int llegada) {
        if(inicio == llegada)  // si el destino es la llegada
            return true;

        visto[inicio] = true;   // se marca el inicio como ya recorrido
        
        for(int k : grafo[inicio]){
            if(!visto[k]){      // si visto sub k es falso
                if(tieneCamino(grafo, visto, k, llegada)){ // itera sobre si mismo cambiando el inicio por la iteracion k del for
                    return true;
                }
            }
        }
        return false;
    }
}