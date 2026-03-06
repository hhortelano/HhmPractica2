import java.time.LocalDate;

public class Profesor extends Trabajador {
    private String especialidad;
    private int horasLecivasSemanales;

    // Constructores

    public Profesor(String nombre) {
        super(nombre);
    }

    public Profesor(String nombre, LocalDate fechaDeIncorporacion) {
        super(nombre, fechaDeIncorporacion);
    }

    public Profesor(String nombre, String apellidos, String dni, LocalDate fechaDeIncorporacion, double salarioBase, String especialidad, int horasLecivasSemanales) {
        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.especialidad = especialidad;
        this.horasLecivasSemanales = horasLecivasSemanales;
    }

    // Calcular salario

    @Override
    double calcularSalario() {
        return getSalarioBase()+horasLecivasSemanales*15;
    }

    // Trabajar

    @Override
    String trabajar() {
        return super.trabajar()+" en la especialidad " + especialidad;
    }
}
