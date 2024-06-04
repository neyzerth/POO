package PARCIAL1.otros;
import java.util.Random;
import java.util.Scanner;

public class ExamenPSeint {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int opt=0;
        int pos, newVal; 
        String txtMenu="Presiona ENTER para regresar al menu"; 
        String txtInitial="PRIMERO INICIALIZA LAS VENTAS";
        String txtInput=">>> ";
        boolean initial=false; 
        boolean tax=false;
        Double[][] sales = new Double[2][12];
        Double auxArray1[] = new Double[12];
        Double auxArray2[] = new Double[12];

        do{
            clear();
            System.out.println("Calculo Neto de Ventas");
            System.out.println( "[1] Inicializar Ventas");
            System.out.println( "[2] Modificar Ventas");
            System.out.println( "[3] Calcular descuento e impuesto");
            System.out.println( "[4] Mostrar valor bruto y neto de las ventas");
            System.out.println( "0 para SALIR");
            opt = Integer.parseInt(input(txtInput));

            switch(opt){
                case 1://Inicializar ventas
                    System.out.print("\n");
                    for(int i=0; i<=11; i++)
                        sales[0][i] = (double) (random.nextInt(500) + 1);
                        
                    if(initial){
                        System.out.println("Las ventas ya han sido inicializadas, quieres inicializarlas de nuevo?");
                        opt = Integer.parseInt(input("SI[1] NO[2]"));
                    }
                    if(opt==1){
                        initial = true;
                        System.out.println("Ventas inicializadas");
                        waitKey(txtMenu);
                    }
                break;

                case 2://Modificar ventas
                    if(initial){
                        clear();
                        System.out.println("Ventas ($)");
                        for(int i=0; i<=11; i++)
                            System.out.println((i+1)+") \n$"+sales[0][i]);
                
                        System.out.print("Que venta desea modificar?(Solo del 1 al 12)\n ");
                        do
                            pos = Integer.parseInt(input(txtInput));
                        while((pos+1) < 1 || (pos+1) > 12);

                        System.out.print("Ingrese nuevo valor a la venta "+(pos+1)+"\n(solo de $1 a $500)\n");
                        do
                            newVal = Integer.parseInt(input(txtInput));
                        while(newVal < 1 || newVal > 500);
                        sales[0][pos-1] = (double) newVal;
                        sales[1][pos] = 0.0;

                        System.out.println("Modificado exitosamente!");
                    } else
                        System.out.println(txtInitial);
                    waitKey(txtMenu);
                break;

                case 3: //Calcular descuento e impuesto
                    if(initial){
                        clear();
                        System.out.println("Valor Neto ($)   Descuento   Impuesto");
                        for(int i=0; i<=11; i++){
                            sales[1][i] = netSale(sales[0][i]);      

                            System.out.print(i+") $"+sales[1][i]);
                            System.out.print(Spaces(5));
                            System.out.print( (calcDisc(sales[1][i]) * 100) + "%");
                            System.out.print(Spaces(5));
                            System.out.println("10%");
                        }
                        tax = true;
                    } else
                        System.out.println(txtInitial);

                    waitKey(txtMenu);
                break;

                case 4: //Mostrar valor bruto y neto de las ventas
                    if(initial && tax){
                        for(int i = 0; i <= 11; i++){
                            auxArray1[i] = sales[0][i];
                            auxArray2[i] = sales[1][i];
                        }
                        
                        clear();
                        System.out.println("Valor bruto ==> Valor Neto");
                        for (int i = 0; i < 12; i++) {
                            auxArray1[i] = sales[0][i];
                            auxArray2[i] = sales[1][i];
                        }
                        for(int i = 0; i <= 11; i++){
                            System.out.print(correctSpace(String.valueOf(i+1) , 2)+") ");
                            System.out.print("$"+correctSpace(String.valueOf(sales[0][i]), largNumL(auxArray1)) );
                            System.out.print(" ==> ");
                            if(sales[1][i] != 0)
                                System.out.print("$"+sales[1][i]);
                            else 
                                System.out.print("No calculada");
                            
                            System.out.print("\n");
                            
                        }
                    } else
                        System.out.println(txtInitial+" Y CALCULA EL VALOR NETO (Descuento e impuesto)");
                    
                    waitKey(txtMenu);
                break;

                default:
                    System.out.println("Desea salir del programa? SI[0] NO[1]");
                    opt = Integer.parseInt(input(txtInput));

                    System.out.println("Hasta pronto :)");
                break;
            }

        } while(opt!=0);

    }
    //public static void printSales(String){}
    public static Double calcDisc(Double sale){
        Double discount;
        if(sale > 1 && sale <= 100) discount = 0.95;    // 5% of discount
        else if(sale <= 300) discount = 0.90;           //10% of discount
        else discount = 0.85;                           //15% of discount
        return discount;
    }
    public static Double netSale(Double sale){
        return sale * calcDisc(sale) * 1.1;
    }

    @SuppressWarnings("resource")
    public static String input(String txt) {
        Scanner value = new Scanner(System.in);

        System.out.print(txt);
        String txtInput;
        txtInput = value.nextLine();
        return txtInput;
    }

    @SuppressWarnings("resource")
    public static void waitKey(String txt) {
        Scanner key = new Scanner(System.in);
        System.out.print(txt);
        key.nextLine();
    }

    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static int largNumL(Double[] arrayNum){
        Double largestNum = arrayNum[0] ;
        for(int i=1; i <= (arrayNum.length-1); i++)
            if (largestNum < arrayNum[i]) 
                largestNum = arrayNum[i];
        
        return String.valueOf(largestNum).length();
    }

    public static String Spaces(int cant){
        String txtSpace = "";
        for (int i = 0; i < cant; i++) txtSpace+=" ";
        return txtSpace;
    }

    public static String correctSpace(String txt, int maxLength){
        int spaces = maxLength - txt.length();
        String newText = txt + Spaces(spaces);

        return newText;
    }

    /*public static String correctSpaceaa(int num, int maxLength){
        String strNum = String.valueOf(num);
        int spaces = maxLength - strNum.length();
        String newText = strNum + Spaces(spaces);

        return newText;
    }*/
    
    public static void columnDouble(String value, int maxLength){
        int lengthValue = value.length();
        System.out.println(lengthValue);
    }
    

}