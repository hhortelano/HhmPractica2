import java.time.LocalDate;

/**
 * Representa a un miembro del personal administrativo de un centro educativo.
 * <p>
 * Además de los datos básicos de {@link Trabajador}, esta clase modela el
 * {@code departamento} de asignación y el {@code nivel} (categoría) del puesto,
 * que influyen en el cálculo del salario final.
 * </p>
 *
 * <h2>Cálculo de salario</h2>
 * El salario se calcula como:
 * <pre>
 * salario = salarioBase * (1 + 0.10 * nivel)
 * </pre>
 * donde {@code nivel} es un entero &gt;= 0.
 *
 * @author Tu nombre
 * @version 1.0
 * @since 1.0
 */
public class PersonalAdministrativo extends Trabajador {

    /**
     * Departamento en el que desempeña sus funciones (p. ej., "Secretaría", "Dirección").
     */
    private String departamento;

    /**
     * Nivel o categoría administrativa (p. ej., 1, 2, 3). A mayor nivel, mayor complemento.
     */
    private int nivel;

    // =========================
    // Constructores
    // =========================

    /**
     * Crea un administrativo con el nombre indicado.
     *
     * @param nombre nombre de pila
     */
    public PersonalAdministrativo(String nombre) {
        super(nombre);
    }

    /**
     * Crea un administrativo con nombre y fecha de incorporación.
     *
     * @param nombre nombre de pila
     * @param fechaDeIncorporacion fecha de alta en el centro
     */
    public PersonalAdministrativo(String nombre, LocalDate fechaDeIncorporacion) {
        super(nombre, fechaDeIncorporacion);
    }

    /**
     * Crea un administrativo con todos los datos habituales.
     *
     * @param nombre nombre de pila
     * @param apellidos apellidos
     * @param dni documento identificativo
     * @param fechaDeIncorporacion fecha de alta en el centro
     * @param salarioBase salario base mensual en euros
     * @param departamento departamento de asignación (p. ej., "Secretaría")
     * @param nivel nivel/categoría administrativa (p. ej., 1, 2, 3)
     */
    public PersonalAdministrativo(String nombre, String apellidos, String dni,
                                  LocalDate fechaDeIncorporacion, double salarioBase,
                                  String departamento, int nivel) {
        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.departamento = departamento;
        this.nivel = nivel;
    }

    // =========================
    // Lógica de negocio
    // =========================

    /**
     * {@inheritDoc}
     * <p>Implementación específica para personal administrativo:
     * aplica un incremento del 10% del salario base por cada nivel.</p>
     *
     * @return salario final en euros
     */
    @Override
    double calcularSalario() {
        return getSalarioBase() * (0.10 * nivel + 1);
    }

    /**
     * {@inheritDoc}
     * <p>Devuelve un texto representando la acción realizada,
     * incluyendo su departamento.</p>
     *
     * @return cadena descriptiva del trabajo realizado
     */
    @Override
    String trabajar() {
        return super.trabajar() + " en el departamento de " + departamento;
    }

    // =========================
    // Getters/Setters (opcional documentarlos si son públicos)
    // =========================

    /**
     * Devuelve el departamento asignado.
     * @return departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento.
     * @param departamento nuevo departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve el nivel/categoría administrativa.
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel/categoría administrativa.
     * @param nivel nuevo nivel (debe ser &gt;= 0)
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}