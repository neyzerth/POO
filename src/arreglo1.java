import java.util.Scanner;

public class arreglo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int cont5 = 0;
        double prom = 0;

        int[] nums = new int[10];

        System.out.println("Ingresa 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i+1)+"> ");
            nums[i] = input.nextInt(); 

            prom += nums[i]; 

            if(nums[i] == 5) cont5++;
        }
        input.close();

        System.out.println("El promedio es: "+prom/10);
        System.out.println("Contador de 5's: "+cont5);
    }
}
