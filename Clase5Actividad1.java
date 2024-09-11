import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class GrafoEstrategia {
    private Map<Cliente, LinkedList<Cliente>> adj; // Lista de adyacencia
    public GrafoEstrategia(int v) {
        adj = new HashMap<>();
    }

    private void addEdge(Cliente v) { // Método para inicializar la lista de adyacencia para un cliente
        if (!adj.containsKey(v)) {
            adj.put(v, new LinkedList<>());
        }
    }

    public void seguir(Cliente v, Cliente u) { // Método para que un usuario siga a otro
        addEdge(v); // Inicializa la lista de adyacencia de v si no está
        addEdge(u);

        if (!adj.get(v).contains(u)) {
            adj.get(v).add(u);
        }
    }

    public void dejarDeSeguir(Cliente v, Cliente u) {
        if (adj.containsKey(v)) {
            adj.get(v).remove(u);
        }
    }

    public LinkedList<Cliente> listaDeSeguidos(Cliente v) {
        return adj.getOrDefault(v, new LinkedList<>()); // Retorna lista vacía si el cliente no está en el mapa
    }

    public LinkedList<Cliente> listaDeSeguidores(Cliente v) {
        LinkedList<Cliente> seguidores = new LinkedList<>();
        for (Map.Entry<Cliente, LinkedList<Cliente>> entry : adj.entrySet()) {
            Cliente key = entry.getKey();
            LinkedList<Cliente> follows = entry.getValue();
            if (follows.contains(v)) {
                seguidores.add(key); // Añadir el cliente que sigue a v
            }
        }
        return seguidores;
    }

    //____________________________________________________________

    public static class Cliente {
        private int id;
        private String nombre;

        // Constructor de Cliente
        public Cliente(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public int getId() {
            return id;
        }

        // Equals y hashCode para uso en HashMap
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cliente cliente = (Cliente) o;
            return id == cliente.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return nombre;
        }
    }


    //____________________________________________________________

    public static void main(String[] args) {
        GrafoEstrategia grafo = new GrafoEstrategia(5);

        Cliente c1 = new Cliente(0, "Camila");
        Cliente c2 = new Cliente(1, "Martin");
        Cliente c3 = new Cliente(2, "Juan");
        Cliente c4 = new Cliente(3, "Pedro");
        Cliente c5 = new Cliente(4, "Martina");

        grafo.seguir(c1, c2);
        grafo.seguir(c1, c3);
        grafo.seguir(c2, c4);
        grafo.seguir(c3, c4);
        grafo.seguir(c4, c5);

        // Mostrar lista de seguidos para Camila
        System.out.println("Usuarios que sigue Camila: " + grafo.listaDeSeguidos(c1));

        // Mostrar lista de seguidores para Pedro
        System.out.println("Seguidores de Pedro: " + grafo.listaDeSeguidores(c4));
    }
}
