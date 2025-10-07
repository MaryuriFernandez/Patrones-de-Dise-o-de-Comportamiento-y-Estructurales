package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.EstadoProyecto;
import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public class EtapaSustentacionPublica implements EtapaProyecto {
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
        proyecto.setEstado(EstadoProyecto.PROYECTO_APROBADO);
        proyecto.setEtapa(new EtapaFinalizado());
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto rechazado en sustentación.");
        proyecto.setEstado(EstadoProyecto.PROYECTO_RECHAZADO);
        proyecto.setEtapa(new EtapaRechazado());
    }
}
