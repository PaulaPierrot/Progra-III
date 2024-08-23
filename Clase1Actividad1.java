public class Clase1Actividad1 {
    public static void main(String[] args) {
        int [] array = {1,2,3}; //1
        int mayor = 0;  //1


        for(int i = 0; i< array.length;i++){//1+2(n+1)+2n
            if(mayor < array[i]){ //2n
                mayor = array[i]; //n
            }
        }


        System.out.println("El elemento mayor es: " + mayor);
//1
    }
}
/*
Complejidad asintótica = 1+1+1+2(n+1)+2n+2n+n+1 = 7n+6 = O(n)

Demostración:
7n +6 <= C.n
7n/n + 6/n <=(C.n)/n
7 + 6/n <= C

if n  1 → C =13

7 +6/n <= 13

 */