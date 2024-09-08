package clase5_Activ3;
import java.util.*;

public class distriEléctrica {
    static class Edge {
        int destino;
        int costo;

        Edge(int destino, int costo){
            this.destino = destino;
            this.costo = costo;
        }
    }

    static List<List<Edge>> creargrafo(int numVertice){
        List<List<Edge>> grafo = new ArrayList<>();
        for (int i=0; i < numVertice;i++){
            grafo.add(new ArrayList<>());
        }
        return grafo;
    }

    static void addEdge(List<List<Edge>> grafo, int origen, int destino, int costo){
        grafo.get(origen).add(new Edge(destino, costo));
        grafo.get(destino).add(new Edge(origen, costo));
    }

}
