/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.leetcode;

/**
 *
 * @author Rene Yañez
 */
class Solution {
    /*
    In a town, there are n people labeled from 1 to n. 
    There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the 
person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be 
identified, or return -1 otherwise.
*/
    
    public int findJudge(int n, int[][] trust) {
        int[] conta = new int[n + 1]; // el n+1 es porque no hay alguien etiquetado como 0.

        for (int[] t : trust) { // recorre la matriz de confianza para asignar la cantidad de confiaza al contador
            conta[t[0]]--;
            conta[t[1]]++;
        }

        for (int i = 1; i < n + 1; ++i)
            if (conta[i] == n - 1){    // el n-1 es porque todos excepto el juez confiaron en alguien
            return i;
            }
        return -1;
        }
}