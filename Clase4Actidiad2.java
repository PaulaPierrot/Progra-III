package clase4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Clase4Actividad2 {
    /* Un sistema de tesorería tiene a disposición una variedad de
    comprobantes que incluyen monedas, cheques, bonos y otros documentos financieros.
    Cada comprobante tiene un valor específico.
    El objetivo es realizar una compra de moneda extranjera minimizando
    el número de comprobantes utilizados.
    */
    public static Map<Comprobante, Integer> comprobantes(int valor, Comprobante[] comprobantesPosibles) {
        Map<Comprobante, Integer> comprobantes = new HashMap<Comprobante, Integer>();
        for (int i = comprobantesPosibles.length - 1; i >= 0; i--) {
            int cont = 0;
            while (valor >= comprobantesPosibles[i].getMonto()) {
                if (cont == 0) {
                    comprobantes.put(comprobantesPosibles[i], 0);
                }
                comprobantes.put(comprobantesPosibles[i], ++cont);
                valor -= comprobantesPosibles[i].getMonto();
            }
        }
        //costo: O (n al cuadrado), por usar bubble sort.
        return comprobantes;
    }

    public static void main(String[] args) {
        Comprobante c1 = new Comprobante(1, "Factura");
        Comprobante c2 = new Comprobante(5, "Cheque");
        Comprobante c3 = new Comprobante(10, "Bono");
        Comprobante c4 = new Comprobante(25, "Otro");
        Comprobante[] comprobantesPosibles = {c1, c2, c3, c4};
        Map<Comprobante, Integer> resultado = comprobantes(80, comprobantesPosibles);
        System.out.println("Se necesitan: ");
        for (Map.Entry<Comprobante, Integer> entry : resultado.entrySet()) {
            System.out.println(entry.getValue() + " del tipo de documento: " + entry.getKey().getNombre() + " ($" + entry.getKey().getMonto() + ")");

        }

    }

    public static Comprobante[] ordenarMayorAMenor(Comprobante[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {
                // Intercambiar si el elemento actual es menor que el siguiente
                if (lista[j].getMonto() < lista[j + 1].getMonto()) {
                    Comprobante temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        return lista; // O n al cuadrado,

    }

    static class Comprobante {
        int monto;
        String nombre;

        public Comprobante(int monto, String nombre) {
            this.monto = monto;
            this.nombre = nombre;
        }

        public int getMonto() {
            return monto;
        }

        public void setMonto(int monto) {
            this.monto = monto;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}
