public class intercambiar {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = 0;

        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("\nIntercambio de valor");

        c = a;
        a = b;
        b = c;
        
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }
}