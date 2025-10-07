package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.EstadoProyecto;
import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public class EtapaEnEvaluacionComite implements EtapaProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Ya fue presentado al comité. Espera revisión.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        proyecto.setEstado(EstadoProyecto.CORRECCIONES_COMITE);
        proyecto.incrementarIntentos();
        if (proyecto.getIntentosCorreccion() > 3) {
            System.out.println("Se superó el número máximo de correcciones. Rechazado por Comité.");
            proyecto.setEstado(EstadoProyecto.RECHAZADO_POR_COMITE);
            proyecto.setEtapa(new EtapaRechazado());
        } else {
            System.out.println("Formato A devuelto para corrección. Intento " + proyecto.getIntentosCorreccion());
        }
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        proyecto.reiniciarIntentos();
        System.out.println("Formato A aceptado por el Comité. Puede escribir el anteproyecto.");
        proyecto.setEstado(EstadoProyecto.ACEPTADO_POR_COMITE);
        proyecto.setEtapa(new EtapaEscribiendoAnteproyecto());
        proyecto.setEstado(EstadoProyecto.ESCRIBIENDO_ANTEPROYECTO);
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Formato A rechazado por el Comité.");
        proyecto.setEstado(EstadoProyecto.RECHAZADO_POR_COMITE);
        proyecto.setEtapa(new EtapaRechazado());
    }
}
