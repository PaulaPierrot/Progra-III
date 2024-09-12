package clase4;
import java.util.Arrays;
import java.util.Collections;

public class Clase4Actividad4 {
    //GREEDY FLORIST
    //La idea sería que cada amigo compre primero una las flores más caras, así el aumento de precio no los afecta tanto
    //ya que despues quedarian solo las flores mas baratas por comprar.


    public static int getMinimumCost(int[] c, int k) {
        int suma = 0;
        int vueltasPorElGrupo = 0;
        int cont = 0;
        //ordenamos el array: para comprar primero las mas caras, trabajaremos desde la última (más cara) hasta la primera (mas barata).
        Arrays.sort(c);
        for (int i = c.length - 1; i >= 0; i--) {
            suma += (vueltasPorElGrupo+1)*c[i];
            cont++;
            //cada amigo va comprando de a una flor, una vez que se dio "una vuelta" al grupo de amigos, se va incrementando el precio.
            if (cont%k==0) {
                vueltasPorElGrupo++;
            }
        }

        return suma;
        //Costo O(n log n), por contener el Array.sort()
    }
    public static void main(String[] args) {
        //Parámetros de prueba que aparecen en HACKERRANT.
        int[] c = {1,3,5,7,9}; //representa los precios originales.
        //NOTA: segun hackerrant, la longitud de c representa el numero de flores que desean comprar.
        int k = 4; //numero de amigos
        int costo = getMinimumCost(c, k);
        System.out.println("El costo mínimo es de $" + costo);

    }
}
