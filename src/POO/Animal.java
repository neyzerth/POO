package POO;
class Animal {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método que será sobrescrito
    public void hacerSonido() {
        System.out.println(nombre + " está haciendo un sonido.");
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

// Clase derivada
class Perro extends Animal {
    // Atributo específico de Perro
    private String raza;

    // Constructor
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad); // Llamada al constructor de la clase base
        this.raza = raza;
    }

    // Sobrescribir método hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " está ladrando.");
    }

    // Método específico de Perro
    public void ladrar() {
        System.out.println(getNombre() + " está ladrando.");
    }

    // Getters y setters
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}

