import java.util.*;

public class Clase4Actividad3 {
    public static void main(String[] args) {

        int CapacidadCamion = 100;
        int CamionValor = 0;

        ValorPeso[] objetos = {
                new ValorPeso(30,55),
                new ValorPeso(25,30),
                new ValorPeso(40,60),
                new ValorPeso(10,5),
                new ValorPeso(15,20),
                new ValorPeso(20,25),
        };

        Arrays.sort(objetos, Comparator.comparingInt(ValorPeso::getPeso).reversed());

        System.out.println("Objetos:");
        System.out.println("Peso Valor");
        for (ValorPeso par : objetos) {
            System.out.print(par.peso + " | " + par.valor);
            System.out.println(" ");
        }

        for(ValorPeso item : objetos){
            if(CapacidadCamion == 0){
                break;
            }
            if(item.peso < CapacidadCamion){
                CapacidadCamion-= item.peso;
                CamionValor += item.valor;
            }
        }
        System.out.println("");
        System.out.println("Valor máximo obtenido: " + CamionValor);

    }
}

class ValorPeso{
    int peso;
    int valor;

    public ValorPeso(int peso,int valor){
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
