import java.util.Scanner;

public class conversorBinario {
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

    public static String parseBinary(int dec) {
        String binary = "";
        int bit = 0;
        while (dec >= 1) {
            bit = dec % 2;
            dec = (int) Math.floor(dec / 2);

            binary = String.valueOf(bit) + binary;
        }
        return binary;
    }

    public static int bitValue(int bit, int pos) {
        int bitValue = (int) Math.pow(2.0, pos);
        return bit * bitValue;

    }

    public static int parseDec(String bin) {
        int bits = bin.length();
        int dec = 0;
        int acum = 0;
        for (int i = 0; i < bits; i++) {
            dec = Integer.parseInt("" + bin.charAt(i));

            if (dec == 0 || dec == 1) {
                acum += bitValue(dec, bits - i - 1);
                System.out.println(dec + " -> " + bitValue(dec, bits - i - 1));
            } else
                return 0;
        }
        return acum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opt, decimal, bit, bits;
        String binario;
        boolean flow = true;

        do {
            clear();
            binario = "";
            System.out.println("CONVERSOR DE BINARIO\n");
            System.out.println("[1] Decimal a binario");
            System.out.println("[2] Binario a decimal");
            System.out.println("[3] Salir");
            System.out.print("> ");
            opt = input.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Numero a convertir a binario: \n> ");
                    decimal = input.nextInt();

                    binario = parseBinary(decimal);
                    bits = binario.length();

                    for (int i = 0; i < bits; i++) {
                        bit = (int) binario.charAt(i) - '0';
                        System.out.println(bit + " -> " + bitValue(bit, bits - i - 1));
                    }

                    System.out.println();
                    System.out.println(decimal + " a binario es: " + binario);
                    System.out.println("Bits: " + bits);
                    waitKey();
                    break;

                case 2:
                    System.out.print("Numero binario a convertir \n> ");
                    binario = input.next();
                    bits = binario.length();

                    decimal = parseDec(binario);

                    System.out.println();
                    if (binario.contains("1") && binario.contains("0"))
                        System.out.println(binario + " a decimal es: " + decimal);
                    else
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

}
