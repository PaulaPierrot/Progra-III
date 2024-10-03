public class SeleccionPaquetesFuerzaBruta {
   static class Paquete {
       int costo;
       int ganancia;


       public Paquete(int costo, int ganancia) {
           this.costo = costo;
           this.ganancia = ganancia;
       }
   }


   public static void main(String[] args) {
       Paquete[] paquetes = {
               new Paquete(12, 150),  // Paquete 1
               new Paquete(20, 200),  // Paquete 2
               new Paquete(15, 100),  // Paquete 3
               new Paquete(25, 300)   // Paquete 4
       };


       int presupuesto = 35;


       Resultado mejorResultado = mejorCombinacion(paquetes, presupuesto);
       System.out.println("Ganancia máxima: " + mejorResultado.gananciaMaxima);
       System.out.println("Costo total: " + mejorResultado.costoTotal);
   }


   static class Resultado {
       int gananciaMaxima;
       int costoTotal;


       public Resultado(int gananciaMaxima, int costoTotal) {
           this.gananciaMaxima = gananciaMaxima;
           this.costoTotal = costoTotal;
       }
   }


   static Resultado mejorCombinacion(Paquete[] paquetes, int presupuesto) {
       int n = paquetes.length;
       int mejorGanancia = 0;
       int mejorCosto = 0;


       for (int i = 0; i < (1 << n); i++) {  // Probar todas las combinaciones
           int costoTotal = 0;
           int gananciaTotal = 0;


           for (int j = 0; j < n; j++) {
               if ((i & (1 << j)) != 0) {
                   costoTotal += paquetes[j].costo;
                   gananciaTotal += paquetes[j].ganancia;
               }
           }


           if (costoTotal <= presupuesto && gananciaTotal > mejorGanancia) {
               mejorGanancia = gananciaTotal;
               mejorCosto = costoTotal;
           }
       }


       return new Resultado(mejorGanancia, mejorCosto);
   }
}



//GREEDY:
//Complejidad: O(n log n) debido a la ordenación.

import java.util.Arrays;
import java.util.Comparator;


public class SeleccionPaquetesGreedy {
   static class Paquete {
       int costo;
       int ganancia;
       double relacion;


       public Paquete(int costo, int ganancia) {
           this.costo = costo;
           this.ganancia = ganancia;
           this.relacion = (double) ganancia / costo;
       }
   }


   public static void main(String[] args) {
       Paquete[] paquetes = {
               new Paquete(12, 150),  // Paquete 1
               new Paquete(20, 200),  // Paquete 2
               new Paquete(15, 100),  // Paquete 3
               new Paquete(25, 300)   // Paquete 4
       };


       int presupuesto = 35;
       int gananciaMaxima = seleccionGreedy(paquetes, presupuesto);
       System.out.println("Ganancia máxima usando greedy: " + gananciaMaxima);
   }


   static int seleccionGreedy(Paquete[] paquetes, int presupuesto) {
       Arrays.sort(paquetes, Comparator.comparingDouble(p -> -p.relacion));


       int gananciaTotal = 0;
       int costoTotal = 0;


       for (Paquete paquete : paquetes) {
           if (costoTotal + paquete.costo <= presupuesto) {
               costoTotal += paquete.costo;
               gananciaTotal += paquete.ganancia;
           }
       }


       return gananciaTotal;
   }
}



//DINÁMICO:
//Complejidad: O(n2^ n)
public class SeleccionPaquetesConBits {
   // Clase que representa un paquete con costo y ganancia
   static class Paquete {
       int costo;
       int ganancia;


       public Paquete(int costo, int ganancia) {
           this.costo = costo;
           this.ganancia = ganancia;
       }
   }


   // Método principal
   public static void main(String[] args) {
       // Definir los paquetes de inversión
       Paquete[] paquetes = {
               new Paquete(12, 150),  // Paquete 1
               new Paquete(20, 200),  // Paquete 2
               new Paquete(15, 100),  // Paquete 3
               new Paquete(25, 300)   // Paquete 4
       };


       int presupuesto = 35;  // Presupuesto máximo


       // Llamar a la función que encuentra la mejor combinación usando bits
       int gananciaMaxima = seleccionConBits(paquetes, presupuesto);


       // Mostrar el resultado
       System.out.println("Ganancia máxima usando bits: " + gananciaMaxima);
   }


   // Función para seleccionar la mejor combinación usando bits
   static int seleccionConBits(Paquete[] paquetes, int presupuesto) {
       int n = paquetes.length;
       int mejorGanancia = 0;


       // Explorar todas las combinaciones posibles usando bits (2^n combinaciones)
       for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
           int costoTotal = 0;
           int gananciaTotal = 0;


           // Revisar cada bit para ver qué paquetes están seleccionados
           for (int j = 0; j < n; j++) {
               if ((i & (1 << j)) != 0) {  // Si el bit j está activado, seleccionamos el paquete j
                   costoTotal += paquetes[j].costo;
                   gananciaTotal += paquetes[j].ganancia;
               }
           }


           // Verificar si el costo total no excede el presupuesto y si la ganancia es mejor
           if (costoTotal <= presupuesto && gananciaTotal > mejorGanancia) {
               mejorGanancia = gananciaTotal;
           }
       }


       // Retornar la mejor ganancia encontrada
       return mejorGanancia;
   }
}



