package PARCIAL1.funciones;
import java.util.Scanner;

public class potencia {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa el numero a sacar potencia");
        int num = input.nextInt();

        System.out.println("Ingresa la potencia ");
        int power = input.nextInt();

        printPower(num, power);

        
    }
    public static void printPower(int num, int power){

        double res = 0;
        System.out.print(num+"^"+power);

        switch (power) {
            case 0:
                res = 1.0;
                break;
        
            default:
                if(power < 0)
                    System.out.print(" = 1/"+num + "^" + (-power));

                res = Math.pow(num,power);
                break;
        }        

        System.out.print(" = " + res);

    }
}
