package PARCIAL1.clases;

import java.util.Random;
import java.util.Scanner;

public class App {

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
                    potencia();
                    waitKey("...");
                    break;
                case 2:
                    intercambiar();
                    waitKey("...");
                    break;
                case 3:
                    arreglo();
                    waitKey("...");
                    break;
                case 4:
                    arreglo2();
                    waitKey("...");
                    break;
                case 5:
                    equipaje();
                    waitKey("...");
                    break;
                case 6:
                    matriz();
                    waitKey("...");
                    break;
                case 7:
                    System.out.println("adios");
                    break;

                default:
                    waitKey("Opcion no valida...");
                    break;
            }
        } while (menu != cantApps + 1);
    }

    // ----- ARREGLOS --------------------
    public static void arreglo() {

        System.out.println("\033[H\033[2J");
        System.out.flush();
        // Declaracion de arreglos
        int vector[] = new int[5];

        // Asigmacion de datos
        vector[0] = 3;
        vector[1] = 23;
        vector[2] = 102;
        vector[3] = 4;
        vector[4] = 15;

        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Ingrese el valor del vector de la posicion" + i);
            vector[i] = entrada.nextInt();
        }
        System.out.println("Los valores del vector son los siguientes \n");

        // Recorrido
        for (int i = 0; i < vector.length; i++) {
            System.out.println("El valor del vector en la posicion " + i + " es: " + vector[i]);
        }
    }

    public static void arreglo2() {
        Scanner input = new Scanner(System.in);

        int[] nums = new int[10];

        System.out.println("Ingresa 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "> ");
            nums[i] = input.nextInt();
        }

        System.out.println("El promedio es: " + prom(nums));
        System.out.println("El numero mayor es: " + max(nums));
        System.out.println("El numero menor es: " + min(nums));
    }

    public static int max(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }

    public static int min(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    public static double prom(int[] nums) {
        int acum = 0;
        for (int num : nums)
            acum += num;

        return (double) acum / nums.length;
    }

    public static void intercambiar() {
        int a = 10;
        int b = 5;
        int c = 0;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("\nIntercambio de valor");

        c = a;
        a = b;
        b = c;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    // ----------------------------------------------------
    // ----------POTENCIA---------
    public static void potencia() {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa el numero a sacar potencia");
        int num = input.nextInt();

        System.out.println("Ingresa la potencia ");
        int power = input.nextInt();

        printPower(num, power);

    }

    public static void printPower(int num, int power) {

        double res = 0;
        System.out.print(num + "^" + power);

        switch (power) {
            case 0:
                res = 1.0;
                break;

            default:
                if (power < 0)
                    System.out.print(" = 1/" + num + "^" + (-power));

                res = Math.pow(num, power);
                break;
        }

        System.out.print(" = " + res);

    }
    // -------------------------------
    // ---------------SUELDOS------------

    @SuppressWarnings("resource")
    public static void sueldos() {
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

    public static void printSalary(int salary, int bono) {
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

    // -------------------------------
    // ---------EQUIPAJE---------------
    public static void equipaje() {
        // INICIALIZACION DE VARIABLES
        Scanner input = new Scanner(System.in);
        int zone = 0;
        int priceKg = 0;
        int kg = 0;
        int price = 0;

        do {
            clear();
            // LECTURA DE DATOS
            System.out.println("AEROLINEA PC29 ");
            System.out.println("De que Zona vienes?");
            System.out.println("[1] America del Norte");
            System.out.println("[2] America Central");
            System.out.println("[3] America del Sur");
            System.out.println("[4] Europa");
            System.out.println("[5] Asia");
            System.out.println("[0] SALIR");
            do {
                System.out.print("> ");
                zone = input.nextInt();
            } while (zone > 5 || zone < 0);

            System.out.println("Cuantos kg pesa su maleta? (max 5kg)");
            System.out.print("> ");
            kg = input.nextInt();

            // ASIGNAR PRECIO/KG SEGUN ZONA
            priceKg = priceZone(zone);

            // IMPRESION DE DATOS
            System.out.println("Precio p/kg es de $" + priceKg);
            if (kg <= 5) {
                price = kg * priceKg;
                System.out.println("El precio total de su equipaje será $" + price);
            } else
                System.out.println("Lo siento, solo se permiten maletas con peso maximo de 5kg");

            waitKey("Enter para continuar");
        } while (zone != 0);
    }

    public static int priceZone(int zone) {
        switch (zone) {
            case 1: // America del Norte
                return 24;
            case 2: // America Central
                return 20;
            case 3: // America del Sur
                return 21;
            case 4: // Europa
                return 10;
            case 5: // Asia
                return 18;
            default:
                return 0;
        }
    }
    // -------------------------------

    public static void matriz() {
        Random random = new Random();

        int columna = 4;
        int fila = 10;

        int[][] matriz = new int[columna][fila];

        for (int i = 0; i < columna; i++) {

            for (int j = 0; j < fila; j++) {
                matriz[i][j] = random.nextInt(100) + 1;

                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // -----------OTROS------------
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
