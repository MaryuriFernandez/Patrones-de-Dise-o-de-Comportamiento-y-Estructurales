package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoEscribiendoAnteproyecto implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Anteproyecto presentado a Jefatura.");
        proyecto.setEstado(new EstadoEnEvaluacionDepartamento());
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("No aplica corrección aquí. El anteproyecto aún no ha sido evaluado.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede aprobar sin evaluación del departamento.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede rechazar sin evaluación.");
    }
}
