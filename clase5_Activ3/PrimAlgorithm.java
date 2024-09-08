package clase5_Activ3;
import java.util.*;

public class PrimAlgorithm {

    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<distriEléctrica.Edge>> grafo) {
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] inMST = new boolean[numVertices];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);
            inMST[u] = true;

            for (distriEléctrica.Edge edge : grafo.get(u)) {
                int v = edge.destino;
                int weight = edge.costo;

                // Actualiza la clave y el padre si el vértice no está en el MST y el peso es menor
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        printMST(parent, numVertices, grafo);
    }

    // Encuentra el vértice con el menor valor de clave
    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Imprime el MST
    private static void printMST(int[] parent, int numVertices, List<List<distriEléctrica.Edge>> grafo) {
        int totalCost = 0;
        System.out.println("Estacion \tWeight");
        for (int i = 1; i < numVertices; i++) {
            for (distriEléctrica.Edge edge : grafo.get(parent[i])) {
                if (edge.destino == i) {
                    System.out.println(parent[i] + " - " + i + "\t" + "\t" + edge.costo);
                    totalCost += edge.costo;
                    break;
                }
            }
        }
        System.out.println("Total cost of MST: " + totalCost);
    }
}
