package Otros;
import java.util.Scanner;

public class Fun {
    public static void clear(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    @SuppressWarnings("resource")
    public static void waitKey(String note) {
        Scanner key = new Scanner(System.in);
        System.out.print(note);
        key.nextLine();
    }
    
    @SuppressWarnings("resource")
    public static void waitKey() {
        Scanner key = new Scanner(System.in);
        System.out.print("\nENTER para continuar...");
        key.nextLine();
    }
}
