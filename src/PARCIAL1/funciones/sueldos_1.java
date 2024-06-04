package PARCIAL1.funciones;

import java.util.Scanner;

public class sueldos_1 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int salary = 0;
        int bono = 0;

        int opt = 0;
        boolean flujo = true;

        String txtWait = "ENTER para continuar";

        do {
            clear();

            System.out.println("CALCULADORA SUELDOS - TIENDA DON CHUY\n");

            System.out.println("Que puesto tiene el empleado que desea calcular el sueldo?");
            System.out.println("[1] Repositor");
            System.out.println("[2] Cajero");
            System.out.println("[3] Supervisor");
            System.out.println("[4] Salir");

            System.out.print(">>> ");
            opt = input.nextInt();

            switch (opt) {
                case 1: // REPOSITOR
                    salary = 2500;
                    bono = 15;

                case 2: // CAJERO
                    salary = 3150;
                    break;

                case 3: // SUPERVISOR
                    salary = 4500;
                    bono = -10;
                    break;

                case 4:
                    flujo = salir();
                    break;

                default:
                    System.out.println("Opcion no valida, intenta de nuevo");
                    waitKey(txtWait);
                    break;
            }

            if (opt != 4) {
                printSalary(salary, bono);
                waitKey(txtWait);
            }

        } while (flujo);
        clear();
        System.out.println("Hasta pronto :)");

    }

    public static double calcPorc(int porcent) {
        return (double) porcent / 100;

    }

    public static double calcTotal(int salary, int bonus) {
        if (bonus != 0) {
            return salary * (1 + calcPorc(bonus));
        } else
            return salary;
    }

    public static void printSalary(int salary, int bono ){
        System.out.println("Concepto\tCantidad");
        System.out.println("Salario\t\t$" + salary);
        System.out.println("Bono\t\t$" + salary * (calcPorc(bono)));
        System.out.println("\nTotal $" + calcTotal(salary, bono) + "\n");
    }

    public static boolean salir() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Realmente desea salir?[1]SI [2]NO");
            int confOut = input.nextInt();

            return confOut != 1;
        } catch (Exception e) {
            input.next();
            return true;
        }
    }

    // Hace pausa y espera un ENTER desplegando un texto
    @SuppressWarnings("resource")
    public static void waitKey(String txt) {
        Scanner key = new Scanner(System.in);
        System.out.print(txt);
        key.nextLine();
    }

    // Limpiar pantalla
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}
