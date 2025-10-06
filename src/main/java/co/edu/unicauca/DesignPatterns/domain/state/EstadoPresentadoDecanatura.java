package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoPresentadoDecanatura implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Consejo asigna fecha y jurados para sustentación.");
        proyecto.setEstado(new EstadoSustentacionPublica());
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("No aplica corrección aquí.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("No se aprueba aún. Espera sustentación.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("No se rechaza sin sustentación.");
    }
}
