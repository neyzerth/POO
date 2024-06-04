package PARCIAL1.clases;


public class numMayor {
    public static void main(String[] args) {
        int n1, n2;

        n1 = 23;
        n2 = 23;

        if (n1 > n2) {
            System.out.println("El numero mayor es: " + n1);
        } else if (n1 == n2) {
            System.out.println("Los numeros son iguales");
        } else {
            System.out.println("El numero mayor es: " + n2);
        }

    }
}
