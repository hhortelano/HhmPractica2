import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase base abstracta para cualquier trabajador del centro educativo.
 * <p>
 * Recoge datos comunes (nombre, apellidos, DNI, fecha de incorporación y salario base)
 * y define el contrato mínimo de comportamiento que deben implementar las subclases,
 * como el cálculo del salario y la acción de trabajar.
 * </p>
 *
 * <h2>Notas de diseño</h2>
 * <ul>
 *   <li>{@link #calcularSalario()} es abstracto: cada subclase define su propio cálculo.</li>
 *   <li>{@link #trabajar()} proporciona un texto genérico que las subclases pueden extender.</li>
 *   <li>{@link #antiguedad()} calcula años completos desde {@code fechaDeIncorporacion} hasta hoy.</li>
 * </ul>
 *
 * @author Tu nombre
 * @version 1.0
 * @since 1.0
 */
public abstract class Trabajador {

    /** Nombre de pila del trabajador. */
    private String nombre;

    /** Apellidos del trabajador. */
    private String apellidos;

    /** Documento identificativo. */
    private String dni;

    /** Fecha de incorporación al centro educativo. */
    private LocalDate fechaDeIncorporacion;

    /** Salario base mensual en euros. */
    private double salarioBase;

    // =========================
    // Constructores
    // =========================

    /**
     * Crea un trabajador con el nombre indicado.
     *
     * @param nombre nombre de pila
     */
    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea un trabajador con nombre y fecha de incorporación.
     *
     * @param nombre nombre de pila
     * @param fechaDeIncorporacion fecha de alta en el centro
     */
    public Trabajador(String nombre, LocalDate fechaDeIncorporacion) {
        this.nombre = nombre;
        this.fechaDeIncorporacion = fechaDeIncorporacion;
    }

    /**
     * Crea un trabajador con todos los atributos habituales.
     *
     * @param nombre nombre de pila
     * @param apellidos apellidos
     * @param dni documento identificativo
     * @param fechaDeIncorporacion fecha de alta en el centro
     * @param salarioBase salario base mensual en euros
     */
    public Trabajador(String nombre, String apellidos, String dni,
                      LocalDate fechaDeIncorporacion, double salarioBase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaDeIncorporacion = fechaDeIncorporacion;
        this.salarioBase = salarioBase;
    }

    // =========================
    // Getters y setters mínimos
    // =========================

    /**
     * Devuelve el nombre de pila.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el salario base mensual en euros.
     *
     * @return salario base
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * Devuelve la fecha de incorporación.
     *
     * @return fecha de incorporación, o {@code null} si no se estableció
     */
    public LocalDate getFechaDeIncorporacion() {
        return fechaDeIncorporacion;
    }

    /**
     * Devuelve los apellidos.
     *
     * @return apellidos (puede ser {@code null} si no se estableció)
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve el DNI.
     *
     * @return DNI (puede ser {@code null} si no se estableció)
     */
    public String getDni() {
        return dni;
    }

    // =========================
    // Comportamiento
    // =========================

    /**
     * Calcula el salario final del trabajador.
     * <p>La implementación concreta depende de cada subclase.</p>
     *
     * @return salario final en euros
     */
    abstract double calcularSalario();

    /**
     * Devuelve una descripción breve de la acción de trabajo realizada.
     * <p>
     * Las subclases suelen extender este mensaje añadiendo su contexto
     * (p. ej., departamento o especialidad).
     * </p>
     *
     * @return texto descriptivo de la acción de trabajo
     */
    String trabajar() {
        return "Estoy trabajando en el centro educativo";
    }

    /**
     * Calcula la antigüedad en años completos desde la fecha de incorporación hasta hoy.
     *
     * @return años completos de antigüedad; 0 si {@code fechaDeIncorporacion} es {@code null}
     */
    int antiguedad() {
        if (fechaDeIncorporacion == null) return 0;
        return (int) ChronoUnit.YEARS.between(fechaDeIncorporacion, LocalDate.now());
    }

    // =========================
    // Representación de texto
    // =========================

    /**
     * Representación legible del trabajador, útil para logs o depuración.
     *
     * @return cadena con los principales campos del trabajador
     */
    @Override
    public String toString() {
        return "<Trabajador " + nombre + ">\n"
                + "- Apellidos: " + apellidos + "\n"
                + "- Dni: " + dni + "\n"
                + "- Fecha de incorporacion: " + fechaDeIncorporacion + "\n"
                + "- SalarioBase: " + salarioBase + "\n";
    }
}