package co.edu.unicauca.DesignPatterns.domain.state;

public class EstadoEnEvaluacionComite implements EstadoProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Ya fue presentado al comité. Espera revisión.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        proyecto.incrementarIntentos();
        if (proyecto.getIntentosCorreccion() > 3) {
            System.out.println("Se superó el número máximo de correcciones. Rechazado por Comité.");
            proyecto.setEstado(new EstadoRechazado());
        } else {
            System.out.println("Formato A devuelto para corrección. Intento " + proyecto.getIntentosCorreccion());
        }
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        proyecto.reiniciarIntentos();
        System.out.println("Formato A aceptado por el Comité. Puede escribir el anteproyecto.");
        proyecto.setEstado(new EstadoEscribiendoAnteproyecto());
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Formato A rechazado por el Comité.");
        proyecto.setEstado(new EstadoRechazado());
    }
}
