public class Clase1Actividad1Bsin {
    public static void main(String[] args) {
        String[][] facturas = {  //1
                {"1", "100", "150.50"},
                {"2", "101", "200.75"},
                {"3", "100", "99.99"},
                {"4", "102", "300.00"},
                {"5", "101", "50.00"}
        };


        String[][] clientes = { //1
                {"100", "Cliente A"},
                {"101", "Cliente B"},
                {"102", "Cliente C"}
        };

        String[][] sumImportes = new String[clientes.length][3];  //1

        for (int i = 0; i < clientes.length; i++) {//1+2(n+1)+2n
            String idCliente = clientes[i][0];//n
            String nombreCliente = clientes[i][1];//n
            double sumaImportes = 0;//n

            for (int j = 0; j < facturas.length; j++) {//1+2(n+1)+2n
                if (facturas[j][1]==(idCliente)) {//n
                    sumaImportes += Double.parseDouble(facturas[j][2]); //2n
                }
            }

            sumImportes[i][0] = idCliente; //n
            sumImportes[i][1] = nombreCliente; //n
            sumImportes[i][2] = String.valueOf(sumaImportes); //2n
        }

        System.out.println("ID Cliente | Nombre Cliente | Importe Total"); //1
        for (int i = 0; i < sumImportes.length; i++) {//1+2(n+1)+2n
            System.out.println(sumImportes[i][0] + " | " + sumImportes[i][1] + " | " + sumImportes[i][2]);//n
        }


    }
}
/*
Complejidad asintótica =1+1+1+1+2.(n+1)+2n+3n+n.(1+2.(n+1)+2n+n+2n)+4n+1+1+2.(n+1)+2n+n
=7n^2 +19n+10= O(n^2)


Demostración:
7n2 +19n +10 <= Cn2
7n^2/n^2 + 19n/n^2 + 10/n^2 <= Cn^2/n^2
7 + 19n + 10n^2 <= C
if n 1 → C = 36
7 + 19n + 10n^2 <= 36
 */