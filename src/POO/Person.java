package POO;

public class Person {
    String name;
    int age;
    private String curp;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.curp = name+age+"RGR325";
    }
    public Person(){
    }
    public void sayHi(){
        System.out.println(String.format("Hola, me llamo %s y tengo %d años", this.name, this.age));
    }

    public String getCurp(){
        return curp;
    }
}
