package clase3_enclase;


import java.util.ArrayList;


public class Actividad3 {
   public static void main(String[] args) {
       ArrayList<Cliente> clientes = new ArrayList<Cliente>();
       Cliente c1 = new Cliente("Juana", 1, 12);
       Cliente c2 = new Cliente("Julia", 2, 23);
       Cliente c3 = new Cliente("Juan", 3, 90);
       Cliente c4 = new Cliente("Julieta", 4, 30);
       clientes.add(c1);
       clientes.add(c2);
       clientes.add(c3);
       clientes.add(c4);
       Cliente[] clientesMayor = encontrarDosMayores(clientes, 0, clientes.size() - 1);


       System.out.println("Los clientes con mayor score son ");
       for (Cliente c : clientesMayor) {
           System.out.println(c.getNombre() + " con scoring de " + c.getScoring());
       }
   }


   public static Cliente[] encontrarDosMayores(ArrayList<Cliente> lista, int inicio, int fin) {
       // Caso base
       if (inicio == fin) {
           Cliente[] mayor = new Cliente[]{(lista.get(inicio)), new Cliente("señuelo", -1, Integer.MIN_VALUE)};
           return mayor; // un solo elemento
       } else if (inicio + 1 == fin) { // Si hay dos elementos
           if (lista.get(inicio).getScoring() > lista.get(fin).getScoring()) {
               return new Cliente[]{lista.get(inicio), lista.get(fin)};
           } else {
               return new Cliente[]{lista.get(fin), lista.get(inicio)};
           }


       }




       // Dividir el array en dos mitades
       int medio = (inicio + fin) / 2;
       Cliente[] mayoresIzq = encontrarDosMayores(lista, inicio, medio);
       Cliente[] mayoresDer = encontrarDosMayores(lista, medio + 1, fin);


       // Combinar los resultados d
       Cliente max1, max2;
       int maxInt;
       if (mayoresIzq[0].getScoring() > mayoresDer[0].getScoring()) {
           max1 = mayoresIzq[0];
           if (mayoresIzq[1].getScoring() > mayoresDer[0].getScoring()) {
               max2 = mayoresIzq[1];
           } else {
               max2 = mayoresDer[0];
           }
       } else {
           max1 = mayoresDer[0];
           if (mayoresIzq[0].getScoring() > mayoresDer[1].getScoring()) {
               max2 = mayoresIzq[0];
           } else {
               max2 = mayoresDer[1];
           }


       }
       Cliente[] mayores = new Cliente[]{max1, max2};
       return mayores;
   }


}

