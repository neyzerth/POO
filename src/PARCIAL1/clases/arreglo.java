package PARCIAL1.clases;
import java.util.Scanner;

public class arreglo {
    public static void main(String[] args) {

        System.out.println("\033[H\033[2J");
        System.out.flush();
        //Declaracion de arreglos
        int vector [] = new int[5];

        //Asigmacion de datos
        vector[0] = 3;
        vector[1] = 23;
        vector[2] = 102;
        vector[3] = 4;
        vector[4] = 15;

        Scanner entrada =  new Scanner(System.in);
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Ingrese el valor del vector de la posicion" + i);
            vector[i] = entrada.nextInt();
        }
        entrada.close();
        System.out.println("Los valores del vector son los siguientes \n");

        //Recorrido
        for (int i = 0; i < vector.length; i++) {
            System.out.println("El valor del vector en la posicion "+i+" es: "+vector[i]);
        }
    }
    
}
