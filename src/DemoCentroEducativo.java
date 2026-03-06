import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase de entrada que demuestra el uso del modelo de un centro educativo:
 * crea profesores y personal administrativo, los añade a un centro,
 * muestra listados, calcula salario medio, busca por criterios y ejecuta
 * acciones de trabajo.
 *
 * <p>Este código se usa como “demo” o prueba manual de los casos de uso
 * principales del proyecto.</p>
 *
 * @author Héctor Hortelano
 * @version 1.0
 */
public class DemoCentroEducativo {

    /**
     * Punto de entrada de la aplicación de demostración.
     * <ul>
     *   <li>Instancia varios {@code Trabajador} (profesores y personal administrativo).</li>
     *   <li>Crea un {@code CentroEducativo} con una lista inicial.</li>
     *   <li>Muestra trabajadores, añade nuevos, calcula salario medio y busca por criterios.</li>
     * </ul>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Profesor profesor1 = new Profesor("Pascual", "Ramirez", "20324323S",
                LocalDate.parse("2022-02-02"), 2000, "Ciencias", 20);

        Profesor profesor2 = new Profesor("Alberto", "Pascualez", "32313131231",
                LocalDate.parse("2020-06-11"), 3000, "Electronica", 30);

        PersonalAdministrativo personalAdministrativo1 = new PersonalAdministrativo("Hector", "Criado", "42452432",
                LocalDate.parse("2010-06-11"), 2500, "Arte", 2);

        PersonalAdministrativo personalAdministrativo2 = new PersonalAdministrativo("Juanma", "Lozano", "49234234",
                LocalDate.parse("2024-06-11"), 1500, "Cocina", 1);

        // Hacemos un array provisional
        ArrayList<Trabajador> provisional = new ArrayList<>();
        provisional.add(profesor1);
        provisional.add(personalAdministrativo1);

        // Creamos un centro con el array de antes
        CentroEducativo chomon = new CentroEducativo(provisional);

        // Y mostramos el array y añado al resto
        chomon.mostrarTrabajadores();
        chomon.anadirTrabajadores(profesor2);
        chomon.anadirTrabajadores(personalAdministrativo2);

        // Salario medio
        System.out.println("Salario medio");
        System.out.println(chomon.salarioMedio());

        // Trabajador con más antiguedad
        System.out.println("Más antiguo");
        System.out.println(chomon.trabajadorMasAntiguo());

        // Busco un trabajador
        System.out.println("Buscar");
        for (Trabajador i : chomon.buscarTrabajadores("Tipo", "Personal administrativo")) {
            System.out.print(i.toString());
        }

        // Muestro el trabajar
        System.out.println("Trabajar");
        System.out.println(profesor1.trabajar());
        System.out.println(personalAdministrativo1.trabajar());
    }
}