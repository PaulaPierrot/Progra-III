package clase5;
import java.util.HashSet;
import java.util.Set;
public class Clase5Actividad2 {
    public static class Grafo {
        private int[][] mAdy; //Matriz de adyacencia
        private int[] etiqs; //Vector para mapeo a índices
        private int cantNodos;

        public void inicializarGrafo() {
            mAdy = new int[100][100];
            etiqs = new int[100];
            cantNodos = 0;
        }

        public void agregarVertice(int v) {
            etiqs[cantNodos] = v;
            for (int i = 0; i <= cantNodos; i++) {
                mAdy[cantNodos][i] = 0; //Nueva fila en 0
                mAdy[i][cantNodos] = 0; //Nueva columna en 0
            }
            cantNodos++;
        }

        public void eliminarVertice(int v) {
            int ind = vert2Indice(v); //índice del vértice por eliminar
            for (int k = 0; k < cantNodos; k++)
                mAdy[k][ind] = mAdy[k][cantNodos-1]; //se “pisa” la fila...
            for (int k = 0; k < cantNodos; k++)
                mAdy[ind][k] = mAdy[cantNodos-1][k]; //... y la columna
            etiqs[ind] = etiqs[cantNodos-1];
            cantNodos--;
        }

        private int vert2Indice(int v) { //Mapeamos vértice a índice
            int i = cantNodos-1;
            while(i >= 0 && etiqs[i] != v)
                i--;
            return i;
        }

        public Set<Integer> vertices() {
            Set<Integer>  conj= new HashSet<>();
            for (int i = 0; i < cantNodos; i++) {
                conj.add(etiqs[i]);
            }
            return conj;
        }

        public void agregarArista(int v1, int v2, int peso) {
            int o = vert2Indice(v1);
            int d = vert2Indice(v2);
            mAdy[o][d] = peso;
        }

        public void eliminarArista(int v1, int v2) {
            int o = vert2Indice(v1);
            int d = vert2Indice(v2);
            mAdy[o][d] = 0;
        }

        public boolean verificarArista(int v1, int v2) {
            int o = vert2Indice(v1);
            int d = vert2Indice(v2);
            return mAdy[o][d] != 0;
        }

        /*public int pesoArista(int v1, int v2) {
            int o = vert2Indice(v1);
            int d = vert2Indice(v2);
            return mAdy[o][d];
        }*/
        public int contarGradoEntrada(int vertice) {
            int v = vert2Indice(vertice);
            int cantidad =0;
            //obtengo las aristas entrantes:
            for (int i=0; i<etiqs.length; i++) {
                if (mAdy[i][v] != 0) {
                    cantidad++;
                }
            }
            return cantidad;
        }

        public int contarGradoSalida(int vertice) {
            int v = vert2Indice(vertice);
            int cantidad =0;
            //obtengo las aristas entrantes:
            for (int i=0; i<etiqs.length; i++) {
                if (mAdy[v][i] != 0) {
                    cantidad++;
                }
            }
            return cantidad;
        }
        public Set<Integer> listarAdyacencia(int vertice) {
            int v = vert2Indice(vertice);
            /*int[] posiciones = new int[cantNodos];
            int pos = 0;*/
            Set<Integer> verticesAdyacentes = new HashSet<>();
            //obtengo las posiciones de los vertices adyacentes
            for (int i=0; i<cantNodos; i++) {
                if (mAdy[v][i] != 0) {
                    verticesAdyacentes.add(etiqs[i]);
                }
            }
            for (int i=0; i<cantNodos; i++) {
                if (mAdy[i][v] != 0) {
                    verticesAdyacentes.add(etiqs[i]);
                }
            }

            /*//Ahora que tengo las posiciones de los vertices, los busco en el vector que los guarda.
            for (int i = 0; i < posiciones.length; i++) {
                 verticesAdyacentes.add()[posiciones[i]];
            }*/
            return verticesAdyacentes;
        }
    }
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.inicializarGrafo();
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarArista(1,2,1);
        g.agregarArista(3,2,1);
        System.out.println(g.contarGradoEntrada(2));
        Set<Integer> lista = g.listarAdyacencia(2);
        System.out.println("Los vertices adyacentes son: ");
        for (Integer v : lista) {
            System.out.print(v + " ");
        }

    }
}
