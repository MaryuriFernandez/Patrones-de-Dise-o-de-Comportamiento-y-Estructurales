package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoEnDesarrollo implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Monografía final presentada a Decanatura.");
        proyecto.setEstado(new EstadoPresentadoDecanatura());
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("Durante desarrollo, las correcciones se gestionan internamente con el tutor.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("El proyecto se aprueba tras la sustentación, no ahora.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("El proyecto no puede ser rechazado en esta etapa.");
    }
}
