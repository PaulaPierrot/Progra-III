package clase13;


import java.util.*;


public class Clase13Actividad1 {
   public static class Grafo {
       private Map<Destino, List<Conexion>> adjList;


       public Grafo() {
           adjList = new HashMap<>();
       }


       // Agregar un destino (nodo)
       public void agregarDestino(Destino destino) {
           adjList.putIfAbsent(destino, new ArrayList<>());
       }


       // Agregar una conexión con un precio entre dos destinos
       public void agregarConexion(Destino origen, Destino destino, int precio) {
           adjList.putIfAbsent(origen, new ArrayList<>());
           adjList.putIfAbsent(destino, new ArrayList<>());
           adjList.get(origen).add(new Conexion(destino, precio));
           adjList.get(destino).add(new Conexion(origen, precio));  // Grafo no dirigido
       }


       // Algoritmo UCS para encontrar el camino de menor costo
       public void ucs(Destino origen, Destino destino) {
           PriorityQueue<NodoCosto> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
           Map<Destino, Integer> costos = new HashMap<>();
           Map<Destino, Destino> predecesores = new HashMap<>();


           cola.add(new NodoCosto(origen, 0));
           costos.put(origen, 0);


           while (!cola.isEmpty()) {
               NodoCosto nodoActual = cola.poll();
               Destino destinoActual = nodoActual.destino;
               int costoActual = nodoActual.costo;


               // Si llegamos al destino final, terminamos
               if (destinoActual.equals(destino)) {
                   imprimirCamino(predecesores, destino, origen);
                   System.out.println("Costo total: " + costoActual);
                   return;
               }


               // Expandir los vecinos del nodo actual
               for (Conexion conexion : adjList.getOrDefault(destinoActual, new ArrayList<>())) {
                   Destino vecino = conexion.destino;
                   int nuevoCosto = costoActual + conexion.precio;


                   // Si encontramos un camino más barato al vecino, actualizamos
                   if (nuevoCosto < costos.getOrDefault(vecino, Integer.MAX_VALUE)) {
                       costos.put(vecino, nuevoCosto);
                       predecesores.put(vecino, destinoActual);
                       cola.add(new NodoCosto(vecino, nuevoCosto));
                   }
               }
           }


           System.out.println("No se encontró un camino de " + origen.getNombre() + " a " + destino.getNombre());
       }


       // Imprimir el camino reconstruyendo desde el destino al origen
       private void imprimirCamino(Map<Destino, Destino> predecesores, Destino destino, Destino origen) {
           List<Destino> camino = new ArrayList<>();
           for (Destino at = destino; at != null; at = predecesores.get(at)) {
               camino.add(at);
           }
           Collections.reverse(camino);
           System.out.println("Camino de menor costo:");
           for (Destino d : camino) {
               System.out.print(d.getNombre() + " ");
           }
           System.out.println();
       }


       public static class Destino { // Este tipo de dato compone los nodos del grafo
           private String nombre;
           private int id;
           private static int cantDestinos = 0;


           public Destino(String nombre) {
               this.nombre = nombre;
               this.id = ++cantDestinos;
           }


           public String getNombre() {
               return nombre;
           }


           @Override
           public boolean equals(Object o) {
               if (this == o) return true;
               if (o == null || getClass() != o.getClass()) return false;
               Destino destino = (Destino) o;
               return id == destino.id;
           }


           @Override
           public int hashCode() {
               return Objects.hash(id);
           }
       }


       public static class Conexion {
           Destino destino;
           int precio;


           public Conexion(Destino destino, int precio) {
               this.destino = destino;
               this.precio = precio;
           }
       }


       public static class NodoCosto {
           Destino destino;
           int costo;


           public NodoCosto(Destino destino, int costo) {
               this.destino = destino;
               this.costo = costo;
           }
       }


       public static void main(String[] args) {
           Grafo grafo = new Grafo();


           Destino destino1 = new Destino("Buenos Aires");
           Destino destino2 = new Destino("Córdoba");
           Destino destino3 = new Destino("Santa Fe");
           Destino destino4 = new Destino("Mendoza");
           Destino destino5 = new Destino("Tucumán");
           Destino destino6 = new Destino("Salta");
           Destino destino7 = new Destino("Jujuy");
           Destino destino8 = new Destino("San Juan");
           Destino destino9 = new Destino("Neuquén");
           Destino destino10 = new Destino("Chubut");


           grafo.agregarDestino(destino1);
           grafo.agregarDestino(destino2);
           grafo.agregarDestino(destino3);
           grafo.agregarDestino(destino4);
           grafo.agregarDestino(destino5);
           grafo.agregarDestino(destino6);
           grafo.agregarDestino(destino7);
           grafo.agregarDestino(destino8);
           grafo.agregarDestino(destino9);
           grafo.agregarDestino(destino10);


           grafo.agregarConexion(destino1, destino2, 300);    // Buenos Aires - Córdoba
           grafo.agregarConexion(destino1, destino3, 250);    // Buenos Aires - Santa Fe
           grafo.agregarConexion(destino2, destino4, 400);    // Córdoba - Mendoza
           grafo.agregarConexion(destino2, destino5, 350);    // Córdoba - Tucumán
           grafo.agregarConexion(destino3, destino5, 300);    // Santa Fe - Tucumán
           grafo.agregarConexion(destino4, destino8, 200);    // Mendoza - San Juan
           grafo.agregarConexion(destino5, destino6, 150);    // Tucumán - Salta
           grafo.agregarConexion(destino6, destino7, 100);    // Salta - Jujuy
           grafo.agregarConexion(destino4, destino9, 600);    // Mendoza - Neuquén
           grafo.agregarConexion(destino9, destino10, 500);   // Neuquén - Chubut
           grafo.agregarConexion(destino8, destino9, 300);    // San Juan - Neuquén
           grafo.agregarConexion(destino5, destino10, 700);   // Tucumán - Chubut
           grafo.agregarConexion(destino1, destino10, 800);   // Buenos Aires - Chubut
           grafo.agregarConexion(destino3, destino8, 550);    // Santa Fe - San Juan
           System.out.println("Ruta de menor costo entre " + destino1.getNombre() + " y " + destino4.getNombre());
           grafo.ucs(destino1, destino4);
       }
   }
}
