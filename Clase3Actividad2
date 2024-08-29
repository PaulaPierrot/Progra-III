package clase3_enclase;


public class Clase3Actividad2 {


   public static void main(String[] args) {
       int[] lista = {0,2,3,4,80,39};


       // Llamada al método para encontrar los dos mayores
       int[] mayores = encontrarDosMayores(lista, 0, lista.length-1);


       System.out.println("Los dos números más grandes son:");
       System.out.println(mayores[0]);
       System.out.println(mayores[1]);
   }


   public static int[] encontrarDosMayores(int[] lista, int inicio, int fin) {
       // Caso base
       if (inicio == fin) {
           int[] mayor = new int[]{lista[inicio],Integer.MIN_VALUE};
           return mayor; // un solo elemento
       } else if (inicio + 1 == fin) { // Si hay dos elementos
           if (lista[inicio] > lista[fin]) {
               return new int[]{lista[inicio], lista[fin]};
           } else {
               return new int[]{lista[fin], lista[inicio]};
           }


       }




       // Dividir el array en dos mitades
       int medio = (inicio + fin) / 2;
       int[] mayoresIzq = encontrarDosMayores(lista, inicio, medio);
       int[] mayoresDer = encontrarDosMayores(lista, medio + 1, fin);


       // Combinar los resultados
       int max1, max2;
       if (mayoresIzq[0] > mayoresDer[0]) {
           max1 = mayoresIzq[0];
           max2 = Math.max(mayoresIzq[1], mayoresDer[0]);
       } else {
           max1 = mayoresDer[0];
           max2 = Math.max(mayoresIzq[0], mayoresDer[1]);
       }
       int[] mayores = new int[]{max1, max2};
       return mayores;
   }


   //Complejidad O(n)
}
