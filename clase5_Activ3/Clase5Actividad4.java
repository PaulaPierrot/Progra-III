package clase5_Activ4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numVertices = 6;  // Número de centros de distribución
        Dijkstra.Graph grafo = new Dijkstra.Graph(numVertices);

        // Agregar carreteras (aristas) con tiempos de viaje (pesos) entre centros de distribución
        grafo.addEdge(0, 1, 4);  // Desde el centro 0 al 1 con un tiempo de 4 minutos
        grafo.addEdge(0, 2, 1);  // Desde el centro 0 al 2 con un tiempo de 1 minuto
        grafo.addEdge(2, 1, 2);  // Desde el centro 2 al 1 con un tiempo de 2 minutos
        grafo.addEdge(1, 3, 1);  // Desde el centro 1 al 3 con un tiempo de 1 minuto
        grafo.addEdge(2, 3, 5);  // Desde el centro 2 al 3 con un tiempo de 5 minutos
        grafo.addEdge(3, 4, 3);  // Desde el centro 3 al 4 con un tiempo de 3 minutos
        grafo.addEdge(4, 5, 1);  // Desde el centro 4 al 5 con un tiempo de 1 minuto
        grafo.addEdge(3, 5, 2);  // Desde el centro 3 al 5 con un tiempo de 2 minutos

        // Ejecutar el algoritmo de Dijkstra desde el centro de distribución principal (vértice 0)
        grafo.dijkstra(0);
    }
}

package clase5_Activ3;

import java.util.*;

public class Dijkstra {

    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight));
            adjList.get(target).add(new Edge(source, weight));  // Carreteras bidireccionales
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(startVertex, 0));

            boolean[] visited = new boolean[vertices];

            while (!pq.isEmpty()) {
                int u = pq.poll().target;

                if (visited[u]) continue;
                visited[u] = true;

                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;
                    int weight = edge.weight;

                    if (!visited[v] && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                        pq.add(new Edge(v, distances[v]));
                    }
                }
            }

            printSolution(distances, startVertex);
        }

        void printSolution(int[] distances, int startVertex) {
            System.out.println("Tiempo mínimo desde el centro de distribución " + startVertex);
            for (int i = 0; i < vertices; i++) {
                System.out.println("Hasta el centro " + i + " es " + distances[i] + " minutos");
            }
        }
    }
}
