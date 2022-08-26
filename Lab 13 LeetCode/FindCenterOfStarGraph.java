/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.leetcode;

import java.util.HashMap;

/**
 *
 * @author Rene Yañez
 */
class Solution {
    
    /*
    There is an undirected star graph consisting of n nodes labeled from 1 to n. 
    A star graph is a graph where there is one center node and exactly n - 1 edges that connect 
    the center node with every other node.

    You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that 
    there is an edge between the nodes ui and vi. Return the center of the given star graph.
    
    */
    public int findCenter(int[][] edges) {

        int n = edges.length;

        HashMap<Integer,Integer> map = new HashMap<>(); // se usa la funcion de java Hash Map que crea un mapa hash
        
        
        for(int[] i:edges){  // se recorre la matriz usando un arreglo de int
            
            // la estrella tiene la propiedad que todos los nodos estan conectados solo a un unico nodo en comun
            map.put(i[0],map.getOrDefault(i[0],0)+1);   
            map.put(i[1],map.getOrDefault(i[1],0)+1);
            
            if(map.get(i[0])==n){
                return i[0];
            }
            
            if(map.get(i[1])==n){
                return i[1];
            }
        }
        
        // si sale del for retorna -1 por no cumplir la condicio de estrella
        return -1;
    }
}