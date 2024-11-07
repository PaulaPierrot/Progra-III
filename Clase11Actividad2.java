package clase11;

public class Clase11Actividad2 {
    static final int TAMANO = 4;  // tamaño de la habitación 4x4

    public static void main(String[] args) {
        int[] escritorios = new int[TAMANO]; // arreglo para almacenar la posición de los escritorios (1 por fila)
        int[] sillas = new int[TAMANO]; // arreglo para almacenar la posición de las sillas (1 por fila)

        colocarEscritoriosYSillas(0, escritorios, sillas);
    }

    // Metodo para colocar escritorios y sillas usando backtracking
    static void colocarEscritoriosYSillas(int fila, int[] escritorios, int[] sillas) {
        if (fila == TAMANO) {
            imprimirSolucion(escritorios, sillas);
            return;
        }

        // Intentamos colocar un escritorio y una silla en cada columna de la fila actual
        for (int colEscritorio = 0; colEscritorio < TAMANO; colEscritorio++) {
            if (esValido(escritorios, fila, colEscritorio)) {
                escritorios[fila] = colEscritorio;  // Colocamos el escritorio en esta columna

                // Intentamos colocar una silla en cada columna
                for (int colSilla = 0; colSilla < TAMANO; colSilla++) {
                    if (esValido(sillas, fila, colSilla) && colSilla != colEscritorio) { // La silla no puede estar en la misma columna que el escritorio
                        sillas[fila] = colSilla;  // Colocamos la silla en esta columna

                        // Llamamos recursivamente para la siguiente fila
                        colocarEscritoriosYSillas(fila + 1, escritorios, sillas);
                    }
                }
            }
        }
    }

    // Verificamos si es válido colocar un escritorio o silla en la columna dada
    static boolean esValido(int[] elementos, int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (elementos[i] == columna) {
                return false;  // Si ya hay un elemento en la misma columna en una fila anterior
            }
        }
        return true;
    }

    static void imprimirSolucion(int[] escritorios, int[] sillas) {
        System.out.println("Solución:");
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (escritorios[i] == j) {
                    System.out.print("E ");  // Imprimimos escritorio
                } else if (sillas[i] == j) {
                    System.out.print("S ");  // Imprimimos silla
                } else {
                    System.out.print(". ");  // Si no hay nada
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}


