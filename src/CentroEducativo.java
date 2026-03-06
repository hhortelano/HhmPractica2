import java.util.ArrayList;

public class CentroEducativo {
    private final ArrayList<Trabajador> centro;

    //Creamos los constructores


    public CentroEducativo(ArrayList<Trabajador> centro) {
        this.centro = centro;
    }

    // Añadir trabajadores
    void anadirTrabajadores(Trabajador trabajador){
        centro.add(trabajador);
    }

    // Muestrar todos los trabajadores
    void mostrarTrabajadores(){
        for (Trabajador i : centro){
            if (i instanceof Profesor){
                System.out.println(i.toString()+"\n");
            } else {
                System.out.println(i.toString()+"\n");
            }
        }
    }

    // Salario medio
    double salarioMedio(){
        double acum = 0;
        for (Trabajador i : centro){
            if (i instanceof Profesor){
                acum+=i.calcularSalario();
            } else {
                acum+=i.calcularSalario();
            }
        }
        return acum;
    }

    // Trabajador más antiguo
    Trabajador trabajadorMasAntiguo(){
        Trabajador antiguo = centro.getFirst();
        for (Trabajador i : centro){
            if (antiguo.antiguedad()<i.antiguedad()){
                antiguo=i;
            }
        }
        return antiguo;
    }

    // Buscar trabajadores
    ArrayList<Trabajador> buscarTrabajadores(String op, String buscar){
        ArrayList<Trabajador> resultados = new ArrayList<>();
        if (op.equals("Nombre")){;
            for (Trabajador i : centro){
                if (i.getNombre().equals(buscar)){
                    resultados.add(i);
                }
            }
        } else if (op.equals("Tipo")){
            if (buscar.equals("Profesor")){
                for (Trabajador i : centro){
                    if (i instanceof Profesor){
                        resultados.add(i);
                    }
                }
            } else if (buscar.equals("Personal administrativo")) {
                for (Trabajador i : centro){
                    if (i instanceof PersonalAdministrativo){
                        resultados.add(i);
                    }
                }
            }
        }
        return resultados;
    }
}
