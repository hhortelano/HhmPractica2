import java.time.LocalDate;

/**
 * Representa a un profesor del centro educativo.
 * <p>
 * Un profesor posee una {@code especialidad} (p. ej., Matemáticas, Ciencias)
 * y un número de horas lectivas semanales que influyen en su salario final.
 * </p>
 *
 * <h2>Cálculo de salario</h2>
 * El salario se calcula como:
 * <pre>
 * salario = salarioBase + horasLectivasSemanales * 15
 * </pre>
 *
 * Cada hora lectiva semanal añade 15€ al salario base.
 *
 * @author Tu nombre
 * @version 1.0
 * @since 1.0
 */
public class Profesor extends Trabajador {

    /**
     * Especialidad del profesor (p. ej., "Lengua", "Física", "Historia").
     */
    private String especialidad;

    /**
     * Horas lectivas que imparte cada semana.
     */
    private int horasLecivasSemanales;

    // =========================
    // Constructores
    // =========================

    /**
     * Crea un profesor con todos los datos necesarios.
     *
     * @param nombre nombre de pila
     * @param apellidos apellidos del profesor
     * @param dni documento identificativo
     * @param fechaDeIncorporacion fecha de incorporación al centro
     * @param salarioBase salario base mensual en euros
     * @param especialidad especialidad académica del profesor
     * @param horasLecivasSemanales número de horas lectivas impartidas cada semana
     */
    public Profesor(String nombre, String apellidos, String dni,
                    LocalDate fechaDeIncorporacion, double salarioBase,
                    String especialidad, int horasLecivasSemanales) {

        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.especialidad = especialidad;
        this.horasLecivasSemanales = horasLecivasSemanales;
    }

    // =========================
    // Lógica de negocio
    // =========================

    /**
     * {@inheritDoc}
     * <p>
     * Para un profesor, el salario final se obtiene sumando al salario base
     * 15€ por cada hora lectiva semanal.
     * </p>
     *
     * @return salario final en euros
     */
    @Override
    double calcularSalario() {
        return getSalarioBase() + horasLecivasSemanales * 15;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Devuelve un texto indicando que el profesor está trabajando en su especialidad.
     * </p>
     *
     * @return frase descriptiva del trabajo realizado
     */
    @Override
    String trabajar() {
        return super.trabajar() + " en la especialidad " + especialidad;
    }
}