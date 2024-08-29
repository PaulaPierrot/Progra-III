public class Main {
    public static void main(String[] args) {
        ColaDinamica cola = new ColaDinamica();  // Crea una nueva instancia de la cola
        cola.InicializarCola();      // Inicializa la cola

        // Acolar elementos
        System.out.println("Encolando elementos:");
        for (int i = 1; i <= 10; i++) {
            cola.Acolar(i);
            System.out.println("Encolado: " + i);  // Muestra el valor que se está encolando
        }

        // Desacolar y mostrar elementos
        System.out.println("Desacolando elementos:");
        while (!cola.ColaVacia()) {
            int primero = cola.Primero();  // Obtiene el valor del primer elemento de la cola
            System.out.println("Desacolado: " + primero);  // Muestra el valor que se está desacolando
            cola.Desacolar();  // Desacola el primer elemento
        }
    }
}