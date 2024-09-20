package clase7;

import java.util.ArrayList;
import java.util.List;

public class Clase7Actividad2 {
    public static Respuesta floydWarshall(int grafo[][], int V) {
        int dist[][] = new int[V][V];
        //comenzamos inicializando la matriz de distancias, en base a la original.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = grafo[i][j];
            }
        }
        //usamos una matriz para almacenar tambien las ciudades en las que debemos parar para abaratar costos.
        int[][] paradas = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                paradas[i][j]=0;

            }
        }
        //ahora chequeamos los caminos intermedios y actualizamos
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        paradas[i][j] = k;
                    }
                }
            }
        }
        //Devolvemos la matriz actualizado.
        Respuesta respuesta = new Respuesta();
        respuesta.paradasIntermedias = paradas;
        respuesta.pesosActualizados = dist;
        return respuesta;
    }

    public static void main(String[] args) {
        final int INF = 9999; //representa el infinito.
        List<String> ciudades = new ArrayList<>();
        ciudades.add("Buenos Aires");
        ciudades.add("Rosario");
        ciudades.add("San Miguel de Tucumán");
        ciudades.add("Córdoba Capital");
        ciudades.add("Viedma");
        int[][] matriz = {
                {0,270,1000,500,2000},
                {250,0,INF,600,420,INF},
                {1000, INF,0,INF,INF},
                {INF,400,INF,0,INF},
                {INF,1500,INF,INF,0}
        };
        Respuesta resp = floydWarshall(matriz, ciudades.size());
        for (int i = 0; i < ciudades.size(); i++) {
            for (int j = 0; j < ciudades.size(); j++) {
                if (i != j) {
                    System.out.print(ciudades.get(i) + " y " + ciudades.get(j) + ": Distancia de " + resp.pesosActualizados[i][j]);
                    if (resp.paradasIntermedias[i][j]!=0) {
                        System.out.print(" pasando por " + ciudades.get(resp.paradasIntermedias[i][j]));
                    }
                    System.out.println();
                }
            }
        }


    }

    public static class Respuesta {
        int[][] pesosActualizados;
        int[][] paradasIntermedias;
    }

}
