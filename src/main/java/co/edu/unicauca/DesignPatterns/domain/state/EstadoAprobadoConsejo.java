package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoAprobadoConsejo implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto aprobado por Consejo, se emite la resolución. Inicia desarrollo.");
        proyecto.setEstado(new EstadoEnDesarrollo());
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("No aplica corrección. El proyecto ya fue aprobado.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Ya está aprobado.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede rechazar un proyecto aprobado.");
    }
}
