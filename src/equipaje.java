import java.util.Scanner;

public class equipaje {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
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

            waitKey();
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

    // Hace pausa y espera un ENTER desplegando un texto
    @SuppressWarnings("resource")
    public static void waitKey() {
        Scanner key = new Scanner(System.in);
        System.out.print("\nPresione ENTER para continuar...");
        key.nextLine();
    }

    // Limpiar pantalla
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
