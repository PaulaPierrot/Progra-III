package clase11;

public class Clase11Actividad3 {
    static final int n = 4;  // Tamaño de la oficina 4x4
    static char[][] tablero = new char[n][n];  // Matriz para representar la oficina

    public static void main(String[] args) {
        inicializarTablero();

        colocarComputadorasEImpresoras(0);
    }


    static void inicializarTablero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = '.';  // Espacios vacíos representados por '.'
            }
        }
    }

    static void colocarComputadorasEImpresoras(int fila) {
        if (fila == n) {  // Si hemos colocado en todas las filas
            imprimirSolucion();
            return;
        }

        // Intentamos colocar una computadora y una impresora en cada columna de la fila actual
        for (int colComputadora = 0; colComputadora < n; colComputadora++) {
            if (esValidoComputadora(fila, colComputadora)) {
                tablero[fila][colComputadora] = 'C';  // Colocamos una computadora

                for (int colImpresora = 0; colImpresora < n; colImpresora++) {
                    if (esValidoImpresora(fila, colImpresora) && colImpresora != colComputadora) {
                        tablero[fila][colImpresora] = 'I';  // Colocamos una impresora

                        // Llamada recursiva para la siguiente fila
                        colocarComputadorasEImpresoras(fila + 1);

                        // Backtracking: retiramos la impresora
                        tablero[fila][colImpresora] = '.';
                    }
                }

                // Backtracking: retiramos la computadora
                tablero[fila][colComputadora] = '.';
            }
        }
    }

    static boolean esValidoComputadora(int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'C') {
                return false;  // Si ya hay una computadora en la misma columna en una fila anterior
            }
        }
        return true;
    }

    static boolean esValidoImpresora(int fila, int col) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'I') {
                return false;  // Si ya hay una impresora en la misma columna en una fila anterior
            }
        }
        return true;
    }

    static void imprimirSolucion() {
        System.out.println("Solución:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


