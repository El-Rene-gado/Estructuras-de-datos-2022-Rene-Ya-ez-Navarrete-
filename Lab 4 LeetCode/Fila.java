/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4.leetcode;

import java.util.LinkedList;

/**
 *
 * @author Rene Yañez
 */
public class Fila {
    LinkedList<Integer> listaFila;

    public Fila() {
        this.listaFila = new LinkedList<Integer>();
    }

    public int ping(int t) {
        // step 1). append the current call
        this.listaFila.addLast(t);

        // step 2). invalidate the outdated pings
        while (this.listaFila.getFirst() < t - 3000)
            this.listaFila.removeFirst();

        return this.listaFila.size();
    }
}
