import java.util.Scanner;

public class sueldos2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int salary = 0;
        double realSalary = 0.0;

        int opt = 0;
        int confOut = 2;
        
        String txtWait = "ENTER para continuar";

        do{
            clear();
            
            System.out.println("CALCULADORA SUELDOS - TIENDA DON CHUY\n");

            System.out.println("Que puesto tiene el empleado que desea calcular el sueldo?");
            System.out.println("[1] Repositor");
            System.out.println("[2] Cajero");
            System.out.println("[3] Supervisor");
            System.out.println("[4] Salir");

            System.out.print(">>> ");
            opt = input.nextInt();

            if(opt == 1) {          //REPOSITOR
                salary = 2500;
                realSalary = salary*1.15;

                System.out.println("Concepto\tCantidad");
                System.out.println("Salario\t\t$"+salary);
                System.out.println("Bono\t\t$"+(salary*0.15));
                System.out.println("\nTotal $"+realSalary+"\n");

                waitKey(txtWait);

            } else if (opt == 2 ){  //CAJERO
                salary = 3150;

                System.out.println("Concepto\tCantidad");
                System.out.println("Salario\t\t$"+salary);
                System.out.println("\nTotal $"+salary+"\n");

                waitKey(txtWait);
            
            } else if(opt == 3) {//SUPERVISOR
                salary = 4500;
                realSalary = salary*0.9;

                System.out.println("Concepto\tCantidad");
                System.out.println("Salario\t\t$"+salary);
                System.out.println("Des. Jubilacion\t$"+(salary*0.10));
                System.out.println("\nTotal  $"+realSalary+"\n");

                waitKey(txtWait);
            
            } else if (opt == 4 ){ 
                System.out.println("Realmente desea salir?[1]SI [2]NO");
                confOut = input.nextInt();
            } else {
                System.out.println("Opcion no valida, intenta de nuevo");  
                waitKey(txtWait);               
            }

        } while (confOut == 2);

        clear();
        System.out.println("Hasta pronto :)");

    }

    //Hace pausa y espera un ENTER desplegando un texto
    @SuppressWarnings("resource")
    public static void waitKey(String txt) {
        Scanner key = new Scanner(System.in);
        System.out.print(txt);
        key.nextLine();
    }

    //Limpiar pantalla
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
}
