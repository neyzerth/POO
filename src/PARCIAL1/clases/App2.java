package PARCIAL1.clases;
import java.util.Scanner;

import PARCIAL1.funciones.arreglo2_1;

public class App2 {
    
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] programs = {
            "Potencia",
            "Intercambiar 2 valores",
            "Arreglo 1",
            "Arreglo 2",
            "Equipaje",
            "Matriz"
        };

        int menu;
        int cantApps = programs.length;
        do {
            clear();
            System.out.println("SELECCIONA UN PROGRAMA");
            for (int i = 0; i < cantApps; i++)
                System.out.println(String.format("[%d] %s", i + 1, programs[i]));

            System.out.println(String.format("[%d] Salir", cantApps + 1));
            System.out.print("> ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    potencia.main(args);
                    waitKey();
                    break;
                case 2:
                    intercambiar.main(args);
                    waitKey();
                    break;
                case 3:
                    arreglo1.main(args);
                    waitKey();
                    break;
                case 4:
                    arreglo2_1.main(args);
                    waitKey();
                    break;
                case 5:
                    equipaje.main(args);
                    waitKey();
                    break;
                case 6:
                    matriz.main(args);
                    waitKey();
                    break;
                case 7:
                    System.out.println("adios");
                    break;

                default:
                    System.out.println("Opcion no valida...");
                    waitKey();
                    break;
            }
        } while (menu != cantApps + 1);
    }
    // Limpiar pantalla
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
    @SuppressWarnings("resource")
    public static void waitKey() {
        Scanner key = new Scanner(System.in);
        System.out.print("\nENTER para continuar...");
        key.nextLine();
    }

}