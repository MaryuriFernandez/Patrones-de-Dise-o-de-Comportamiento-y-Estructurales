package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.EstadoProyecto;
import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public class EtapaEnEvaluacionDepartamento implements EtapaProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Ya fue presentado. Espera revisión del departamento.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        proyecto.incrementarIntentos();
        if (proyecto.getIntentosCorreccion() > 3) {
            System.out.println("Se superó el número máximo de correcciones. Anteproyecto rechazado.");
            proyecto.setEstado(EstadoProyecto.EVALUADOR_RECHAZA);
            proyecto.setEtapa(new EtapaRechazado());
        } else {
            System.out.println("Anteproyecto devuelto para corrección. Intento " + proyecto.getIntentosCorreccion());
            proyecto.setEstado(EstadoProyecto.EVALUADOR_PIDE_CORRECCIONES);
        }
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Anteproyecto aprobado por departamento. Enviado a Consejo de Facultad.");
        proyecto.setEstado(EstadoProyecto.EVALUADOR_ACEPTA);
        proyecto.setEtapa(new EtapaAprobadoConsejo());
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Anteproyecto rechazado por departamento.");
        proyecto.setEstado(EstadoProyecto.EVALUADOR_RECHAZA);
        proyecto.setEtapa(new EtapaRechazado());
    }
}
