import java.util.Scanner;

public class potencia2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double res;

        System.out.println("Ingresa el numero a sacar potencia");
        int num = input.nextInt();

        System.out.println("Ingresa la potencia ");
        int power = input.nextInt();
        
        
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
