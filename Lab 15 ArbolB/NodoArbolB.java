package lab15arbolb;

class NodoArbolB{
    int n;
    boolean leaf;
    int key[];
    NodoArbolB child[];

    //Constructores
    public NodoArbolB(int t) {
        n = 0;
        leaf = true;
        key = new int[((2 * t) - 1)];
        child = new NodoArbolB[(2 * t)];
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
}