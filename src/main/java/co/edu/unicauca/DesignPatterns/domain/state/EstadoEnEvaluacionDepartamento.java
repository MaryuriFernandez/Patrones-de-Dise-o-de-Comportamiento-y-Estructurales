package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoEnEvaluacionDepartamento implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Ya fue presentado. Espera revisión del departamento.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        proyecto.incrementarIntentos();
        if (proyecto.getIntentosCorreccion() > 3) {
            System.out.println("Se superó el número máximo de correcciones. Anteproyecto rechazado.");
            proyecto.setEstado(new EstadoRechazado());
        } else {
            System.out.println("Anteproyecto devuelto para corrección. Intento " + proyecto.getIntentosCorreccion());
        }
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Anteproyecto aprobado por departamento. Enviado a Consejo de Facultad.");
        proyecto.setEstado(new EstadoAprobadoConsejo());
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Anteproyecto rechazado por departamento.");
        proyecto.setEstado(new EstadoRechazado());
    }
}
