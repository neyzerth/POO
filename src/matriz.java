import java.util.Random;

public class matriz {
    public static void main(String[] args) {
        Random random = new Random();

        int columna = 4;
        int fila = 5;

        int[][] matriz = new int[columna][fila];

        for (int i = 0; i < columna; i++) {

            for (int j = 0; j < fila; j++) {
                matriz[i][j] = random.nextInt(100) + 1;

                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();  
        }
    }
}
