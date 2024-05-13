import java.util.Scanner;

public class potencia {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa el numero a sacar potencia");
        int num = input.nextInt();

        System.out.println("Ingresa la potencia ");
        int power = input.nextInt();

        double res = Math.pow(num,power);
        
        System.out.print(num + "^" + power);
        if(power < 0)
            System.out.print(" = 1/"+num + "^" + (-power));

        System.out.print(" = " + res);
    }
    //Andres were here
}
