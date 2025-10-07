package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoSustentacionPublica implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("El estudiante realiza su sustentación pública.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("Las correcciones dependen del jurado. No aplica aquí.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto aprobado en sustentación. ¡Felicidades!");
        proyecto.setEstado(new EstadoFinalizado());
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto rechazado en sustentación.");
        proyecto.setEstado(new EstadoRechazado());
    }
}
