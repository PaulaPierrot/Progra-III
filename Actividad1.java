package clase3_enclase;

import java.util.ArrayList;

public class Actividad1 {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c1 = new Cliente("Juana", 1, 12);
        Cliente c2 = new Cliente("Julia", 2, 23);
        Cliente c3 = new Cliente("Juan", 3, 13);
        Cliente c4 = new Cliente("Julieta", 4, 30);
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        Cliente mayorScore = mayor(clientes);
        System.out.println("El cliente con mayor score es " + mayorScore.getNombre() + " con un scoring de " + mayorScore.getScoring());
    }

    private static Cliente mayor(ArrayList<Cliente> lista) {
        return mayor(lista, 0, lista.get(0));
    }

    private static Cliente mayor(ArrayList<Cliente> lista, int i, Cliente mayor) {
        if (i == lista.size()) {
            return mayor;
        }
        if (lista.get(i).getScoring() > mayor.getScoring()) {
            mayor = lista.get(i);
        }
        return mayor(lista, i + 1, mayor);
    }
}

class Cliente {
    private String nombre;
    private int id;
    private int scoring;

    public Cliente(String nombre, int id, int scoring) {
        this.nombre = nombre;
        this.id = id;
        this.scoring = scoring;
    }

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
