import java.util.Scanner;

public class conversorBinario {
    //Las funciones se encuentran hasta el final:)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opt, decimal;
        String binary;
        boolean flow = true; //el flujo del programa, si termina o no

        do {
            clear();
            System.out.println("CONVERSOR DE BINARIO\n");
            System.out.println("[1] Decimal a binario");
            System.out.println("[2] Binario a decimal");
            System.out.println("[3] Salir");
            System.out.print("> ");
            opt = input.nextInt();
            
            clear();
            switch (opt) {
                case 1:
                    System.out.print("Numero a convertir a binario: \n> ");
                    decimal = input.nextInt();

                    binary = parseBinary(decimal);  //funcion de decimal->binario

                    printBinVal(binary);    //imprimir los valores individuales del binario
                    System.out.println(decimal + " a binario es: " + binary);
                    System.out.println("Bits: " + binary.length());
                    waitKey();
                    break;

                case 2:
                    System.out.print("Numero binario a convertir \n> ");
                    binary = input.next();

                    decimal = parseDec(binary); //funcion de binario->decimal

                    if (binary.contains("1") && binary.contains("0")) {
                        printBinVal(binary);    //imprimir los valores individuales del binario
                        System.out.println(binary + " a decimal es: " + decimal);
                    } else
                        System.out.println("Solo debes introducir 0 y 1");

                    waitKey();
                    break;

                case 3: flow = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    waitKey();
                    break;
            }

        } while (flow);
        input.close();
        clear();
        System.out.println(

            "▒▒▒▒▒▒▒▓\r\n" + //
            "▒▒▒▒▒▒▒▓▓▓\r\n" + //
            "▒▓▓▓▓▓▓░░░▓\r\n" + //
            "▒▓░░░░▓░░░░▓\r\n" + //
            "▓░░░░░░▓░▓░▓\r\n" + //
            "▓░░░░░░▓░░░▓\r\n" + //
            "▓░░▓░░░▓▓▓▓\r\n" + //
            "▒▓░░░░▓▒▒▒▒▓\t adios\r\n" + //
            "▒▒▓▓▓▓▒▒▒▒▒▓\r\n" + //
            "▒▒▒▒▒▒▒▒▓▓▓▓\r\n" + //
            "▒▒▒▒▒▓▓▓▒▒▒▒▓\r\n" + //
            "▒▒▒▒▓▒▒▒▒▒▒▒▒▓\r\n" + //
            "▒▒▒▓▒▒▒▒▒▒▒▒▒▓\r\n" + //
            "▒▒▓▒▒▒▒▒▒▒▒▒▒▒▓\r\n" + //
            "▒▓▒▓▒▒▒▒▒▒▒▒▒▓\r\n" + //
            "▒▓▒▓▓▓▓▓▓▓▓▓▓\r\n" + //
            "▒▓▒▒▒▒▒▒▒▓\r\n" + //
            "▒▒▓▒▒▒▒▒▓\r\n" + //
            "");

    }
    //----- F U N C I O N E S ----------

    //-- OPERACIONES --
    //Convierte un numero entero a binario (lo regresa en texto)
    //SE USA EL PROCEDIMIENTO VISTA EN CLASE DE LOGICA 
    public static String parseBinary(int dec) {
        String binary = ""; //acumulador
        int bit = 0;
        while (dec > 0) {
            bit = dec % 2;
            dec = (int) Math.floor(dec / 2);

            binary = String.valueOf(bit) + binary;
        }
        return binary;
    }

    //Calcula el valor de un bit segun su posicion y si es 1 o 0
    public static int bitValue(int bit, int pos) {
        int bitValue = (int) Math.pow(2.0, pos);
        return bit * bitValue;
    }

    //Convierte un numero binario a numero entero
    public static int parseDec(String bin) {
        int bits = bin.length();
        int dec = 0;
        int acum = 0;

        for (int i = 0; i < bits; i++) {
            dec = Integer.parseInt("" + bin.charAt(i)); //Convertir el bit en posicion i a entero

            if (dec == 0 || dec == 1) {
                acum += bitValue(dec, bits - i - 1);
            } else
                return 0;   //Si encuentra un numero distitno a 1-0, se termina la funcion
        }
        return acum;
    }

    //-- TEXTO --
    //Imprime los valores binarios en dos filas
    public static void printBinVal(String bin) {
        int bits = bin.length();
        int bit;

        System.out.print("\nBinario:\t");
        for (int i = 0; i < bits; i++) {
            bit = (int) bin.charAt(i) - '0';    //Es la forma que vi de pasar char->int
            System.out.print(bit + "\t"); //imprimir el bit individual (0-1)
        }

        System.out.print("\nValor:\t\t");
        for (int i = 0; i < bits; i++) {
            bit = (int) bin.charAt(i) - '0';    //Es la forma que vi de pasar char->int
            System.out.print(bitValue(bit, bits - i - 1)+"\t"); //Imprime el valor en decimal del bit
        }
        System.out.println("\n");
        
    }
    // Hace pausa y espera un ENTER desplegando un texto
    @SuppressWarnings("resource")
    public static void waitKey() {
        Scanner key = new Scanner(System.in);
        System.out.print("\nPresione ENTER para continuar... ");
        key.nextLine();
    }

    // Limpiar pantalla
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
