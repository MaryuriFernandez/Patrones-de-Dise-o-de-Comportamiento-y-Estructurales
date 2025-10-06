package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoInicio implements EstadoProyecto{
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Formato A diligenciado. Presentado al coordinador.");
        proyecto.setEstado(new EstadoEnEvaluacionComite());
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("No hay nada que corregir aún. Debes presentar el Formato A primero.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede aprobar sin evaluación previa.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("No se puede rechazar en esta etapa.");
    }
}
