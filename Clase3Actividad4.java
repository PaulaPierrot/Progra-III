package clase3_enclase;
import java.util.*;
public class Clase3Actividad4 {
   public static void main(String[] args) {
       int[] lista = {0,2,3,4,80,39,90};
       int n = 5;
       // Llamada al método para encontrar los dos mayores


       if (n>lista.length) {
           System.out.println("El valor debe ser más pequeño que el largo de la lista");
       }
       else {
           int[] mayores = encontrarNMayores(lista, n, 0, lista.length-1);


           System.out.println("Los " + n + " números más grandes son:");
           for (int i = 0; i < mayores.length; i++) {
               System.out.print(mayores[i] + " ");
           }
       }
       }




   public static int[] encontrarNMayores(int[] lista, int n, int inicio, int fin) {
       // Caso base: la lista es menor o igual a 1, no hay que continuar subdividiendo.
       if (fin - inicio +1 <= n) {
           int[] listaAux = new int[fin - inicio + 1];
           System.arraycopy(lista, inicio, listaAux, 0, fin - inicio + 1);
           Arrays.sort(listaAux);
           return listaAux;
       }




       // Dividir el array en dos mitades
       int medio = (inicio + fin) / 2;
       int[] mayoresIzq = encontrarNMayores(lista, n, inicio, medio);
       int[] mayoresDer = encontrarNMayores(lista, n, medio + 1, fin);


       // Combinar los resultados
       //lo movemos a un metodo separado por una cuestión de prolijidad.
       int[] mayores = combinar(mayoresIzq, mayoresDer, n);
       return mayores;


   }


   public static int[] combinar(int[] lista1, int[] lista2, int n) {
       int[] listaAux = new int[lista1.length + lista2.length];
       int[] listaComb = new int[n];


       // Combinar las dos listas
       for (int i = 0; i < lista1.length; i++) {
           listaAux[i] = lista1[i];
       }
       for (int i = 0; i < lista2.length; i++) {
           listaAux[i + lista1.length] = lista2[i];
       }


       // Ordenar la lista combinada de menor a mayor.
       Arrays.sort(listaAux);


       // Tomar los últimos n elementos, que seran los mayores
       int index = listaAux.length - 1;
       for (int i = 0; i < n; i++) {
           listaComb[i] = listaAux[index];
           index--;
       }


       return listaComb;
   }
   //Logica similar a un MergeSort -> Complejidad temporal en el peor de los casos: O(n log(n)).


}

