package clase5_Activ3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numVertice = 5;
        // crear grafo
        List<List<distriEléctrica.Edge>> grafo = distriEléctrica.creargrafo(numVertice);

        distriEléctrica.addEdge(grafo,0,1,10);
        distriEléctrica.addEdge(grafo,0,3,8);
        distriEléctrica.addEdge(grafo,1,2,20);
        distriEléctrica.addEdge(grafo,1,3,25);
        distriEléctrica.addEdge(grafo,2,4,15);

        PrimAlgorithm.primMST(numVertice,grafo);
    }
}
