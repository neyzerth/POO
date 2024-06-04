package PARCIAL1.clases;
import java.util.Scanner;

public class arreglo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double prom = 0;
        int min, max;

        int[] nums = new int[10];

        System.out.println("Ingresa 10 numeros: ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "> ");
            nums[i] = input.nextInt();
        }

        max = nums[0];
        min = nums[0];

        // foreach
        // num <- nums[i]
        for (int num : nums) {
            prom += num;

            if (num > max)
                max = num;

            if (num < min)
                min = num;
        }
        //input.close();

        prom /= 10;

        System.out.println("El promedio es: " + prom);
        System.out.println("El numero mayor es: " + max);
        System.out.println("El numero menor es: " + min);
    }
}
