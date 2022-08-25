/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4.leetcode;

/**
 *
 * @author Rene Yañez
 */
public class Pila {
        public static int maxDepth(String s) {
        int cont=0; // contador
        Stack<Integer> st = new Stack<>();
         
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                st.push(i);
            else if(s.charAt(i) == ')')
            {
                if(cont < st.size())
                    cont = st.size();
                st.pop();
            }
        }
        return cont;
    }
}