package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoFinalizado implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto ya finalizado. No se puede presentar nada más.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto finalizado. No hay correcciones pendientes.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto finalizado y aprobado. Felicidades, proceso completado.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede rechazar un proyecto finalizado.");
    }
}
