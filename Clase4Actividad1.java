package clase4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Clase4Actividad1 {
    //dada una lista con denominaciones convencionales (1,5,10,25), implementar una función greedy que determine
    //si es posible entregar un cambio exacto utilizando una lista de monedas disponibles.

    public static boolean cambioExacto(int valor, int[] montosPosibles) {
        Arrays.sort(montosPosibles);
        for (int i = montosPosibles.length-1; i >=0; i--) {
            while (valor>= montosPosibles[i]) {
                valor -= montosPosibles[i];
            }
        }
        return (valor == 0); //si llegó a 0, es porque utilizando los montos de la lista
        //logró llegar al monto exacto.
        //costo: O(n log n)

    }
    public static void main(String[] args) {
        int[] montos = {1,5,10,25};
        //nota: si la lista de montos posibles contiene 1, el resultaod de la funcion cambioExacto siempre sera true
        //habiamos probado quitando el 1 y en ese caso nos decia que para el 16 no es posible entregar un cambio exacto.
        int monto = 16;
        boolean resultado = cambioExacto(monto, montos);
        if (resultado == true) {
            System.out.println("Es posible entregar un cambio exacto para el " + monto);
        }
        else {
            System.out.println("No es posible entregar un cambio exacto para el "+ monto);
        }
    }

}
