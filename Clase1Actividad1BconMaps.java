import java.util.*; //1


public class Clase1Actividad1BconMaps {
    public static void main(String[] args) {

        int[][] facturas = { //1
                {1, 101, 200},
                {2, 102, 150},
                {3, 101, 300},
                {4, 103, 250}
        };


        String[][] clientes = { //1
                {"101", "Juan"},
                {"102", "Pedro"},
                {"103", "Maria"}
        };

        Map<Integer, Object[]> clienteImportes = new HashMap<>(); //1

        for (String[] cliente : clientes) { //(n+1)?
            int idCliente = Integer.parseInt(cliente[0]);//2n
            String nombreCliente = cliente[1]; //n
            clienteImportes.put(idCliente, new Object[]{nombreCliente, 0});//2n ?
        }

        for (int[] factura : facturas) {//n+1 ?
            int idCliente = factura[1]; //n
            int importe = factura[2]; //n


            if (clienteImportes.containsKey(idCliente)) { //2n
                Object[] clienteData = clienteImportes.get(idCliente); //2n
                clienteData[1] = (int) clienteData[1] + importe; //2n
            }
        }

        List<Object[]> resultado = new ArrayList<>(); //1


        for (Map.Entry<Integer, Object[]> entry : clienteImportes.entrySet()) { //(n+1) ??????
            int idCliente = entry.getKey();//2n
            Object[] clienteData = entry.getValue(); //2n
            String nombreCliente = (String) clienteData[0];//2n
            int importeTotal = (int) clienteData[1];//2n
            resultado.add(new Object[]{idCliente, nombreCliente, importeTotal}); //2n
        }

        for (Object[] res : resultado) { //(n+1)
            System.out.println("ID Cliente: " + res[0] + ", Nombre: " + res[1] + ", Importe Total: " + res[2]);//n
        }
    }
}
/*
Complejidad asintótica : 4+n+1+3n+n+1+2n+6n+1+n+1+10n+n+1+n = 26n +9 = O(n)

Demostración:
26n + 9  Cn
26n/n + 9/n <= Cn/n

if  n1 →  C = 35

26 + 9n <= 35
 */
