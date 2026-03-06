import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Trabajador {
    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaDeIncorporacion;
    private double salarioBase;

    //Constructores
    //Nombre

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    //nombre y la fecha de incorporación

    public Trabajador(String nombre, LocalDate fechaDeIncorporacion) {
        this.nombre = nombre;
        this.fechaDeIncorporacion = fechaDeIncorporacion;
    }

    //todos los atributos

    public Trabajador(String nombre, String apellidos, String dni, LocalDate fechaDeIncorporacion, double salarioBase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaDeIncorporacion = fechaDeIncorporacion;
        this.salarioBase = salarioBase;
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaDeIncorporacion() {
        return fechaDeIncorporacion;
    }

    public void setFechaDeIncorporacion(LocalDate fechaDeIncorporacion) {
        this.fechaDeIncorporacion = fechaDeIncorporacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Calcular el salario
    abstract double calcularSalario();

    // Trabajar
    String trabajar(){
        return "Estoy trabajando en el centro educativo";
    }

    // Antiguedad
    int antiguedad(){
        if (fechaDeIncorporacion == null) return 0;
        return (int) ChronoUnit.YEARS.between(fechaDeIncorporacion, LocalDate.now());
    }

    // To string

    @Override
    public String toString() {
        return "<Trabajador " + nombre + ">\n- Apellidos: " + apellidos + "\n- Dni: " + dni + "\n- Fecha de incorporacion: " + fechaDeIncorporacion + "\n- SalarioBase: " + salarioBase +"\n";
    }
}
