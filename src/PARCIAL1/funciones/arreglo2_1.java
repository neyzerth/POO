package PARCIAL1.funciones;
import java.util.Scanner;

public class arreglo2_1 {
    public static void main(String[] args) {
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
    
    public static int max(int[]nums){
        int max = 0;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }
    public static int min(int[]nums){
        int min = nums[0];
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }
    public static double prom(int[] nums){
        int acum = 0;
        for (int num : nums) 
            acum+=num;
    
        return (double) acum/nums.length;
    }
}

