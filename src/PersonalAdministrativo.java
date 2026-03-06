import java.time.LocalDate;

public class PersonalAdministrativo extends Trabajador {
    private String departamento;
    private int nivel;

    // Constructores

    public PersonalAdministrativo(String nombre) {
        super(nombre);
    }

    public PersonalAdministrativo(String nombre, LocalDate fechaDeIncorporacion) {
        super(nombre, fechaDeIncorporacion);
    }

    public PersonalAdministrativo(String nombre, String apellidos, String dni, LocalDate fechaDeIncorporacion, double salarioBase, String departamento, int nivel) {
        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.departamento = departamento;
        this.nivel = nivel;
    }

    // Calcular salario

    @Override
    double calcularSalario() {
        return getSalarioBase()*(0.10*nivel+1);
    }

    // Trabajar

    @Override
    String trabajar() {
        return super.trabajar()+" en el departamento de " + departamento;
    }
}
