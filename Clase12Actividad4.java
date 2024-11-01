package Clase12;
import java.util.*;

public class Clase12Actividad4 {


    /*
     * Diseña e implementa un sistema que modele una red social utilizando grafos.
     * Cada usuario será un nodo, y las amistades entre usuarios serán las aristas.
     * El sistema debe permitir: Agregar usuarios a la red,
     *  cada uno con un identificador único y nombre.
     * Conectar usuarios indicando que son amigos (relación bidireccional).
     * Implementar un metodo para realizar un recorrido DFS (Depth First Search)
     * desde un usuario dado, mostrando los usuarios alcanzables a través de sus amistades.
     * Implementar un recorrido BFS (Breadth First Search) para
     *  explorar la red desde un usuario dado,
     *  siguiendo las conexiones de amistad.

     * */


    public static class Grafo {
        private Map<Usuario, List<Usuario>> adjList;

        public Grafo() {
            adjList = new HashMap<>();
        }

        // Agregar un vértice
        public void agregarUsuario(Usuario usuario) {
            adjList.putIfAbsent(usuario, new ArrayList<>());
            //el putIfAbsent se fija si está o no. Si no está, lo agrega.
        }

        // Agregar una arista
        public void agregarConexion(Usuario origen, Usuario destino) {
            adjList.putIfAbsent(origen, new ArrayList<>());
            adjList.putIfAbsent(destino, new ArrayList<>());
            adjList.get(origen).add(destino);
            adjList.get(destino).add(origen);  // Por ser un grafo no dirigido
        }


        public void bfs(Usuario inicio) {
            Set<Usuario> visitados = new HashSet<>();
            Queue<Usuario> cola = new LinkedList<>();
            cola.add(inicio);
            visitados.add(inicio);

            while (!cola.isEmpty()) {
                Usuario usuario = cola.poll();
                System.out.print(usuario.getNombre()  + " ");

                for (Usuario vecino : adjList.get(usuario)) {
                    if (!visitados.contains(vecino)) {
                        cola.add(vecino);
                        visitados.add(vecino);
                    }
                }
            }
            System.out.println();
        }

            // DFS (Depth-First Search)
            public void dfs(Usuario inicio) {
                Set<Usuario> visitados = new HashSet<>();
                Stack<Usuario> pila = new Stack<>();
                pila.push(inicio);
                visitados.add(inicio);

                while (!pila.isEmpty()) {
                    Usuario usuario = pila.pop();
                    System.out.print(usuario.getNombre()+ " ");

                    for (Usuario vecino : adjList.get(usuario)) {
                        if (!visitados.contains(vecino)) {
                            pila.push(vecino);
                            visitados.add(vecino);
                        }
                    }
                }
                System.out.println();
            }


    public static class Usuario { //Este tipo de dato compone los nodos del grafo
        private String nombre;
        private int id;
        private static int cantUsuarios = 0; //se utiliza para hacer los ids unicos

        public Usuario(String nombre) {
            this.nombre = nombre;
            this.id = ++cantUsuarios;
            //Crea un nuevo usuario.
        }

        public String getNombre() {
            return nombre;
        }

        public int getId() {
            return id;
        }
    }
        public static void main(String[] args) {
            Grafo grafo = new Grafo();

            Usuario usuario1 = new Usuario("Paula");
            Usuario usuario2 = new Usuario("Chiara");
            Usuario usuario3 = new Usuario("Chen");
            Usuario usuario4 = new Usuario("Eden");

            grafo.agregarUsuario(usuario1);
            grafo.agregarUsuario(usuario2);
            grafo.agregarUsuario(usuario3);
            grafo.agregarUsuario(usuario4);

            grafo.agregarConexion(usuario1, usuario2);
            grafo.agregarConexion(usuario1, usuario3);
            grafo.agregarConexion(usuario2, usuario4);

            //para testear, usamos el usuario 1 en ambas busquedas

            System.out.println("BFS desde el usuario 1:");
            grafo.bfs(usuario1);

            System.out.println("DFS desde el usuario 1:");
            grafo.dfs(usuario1);
        }
    }



}

