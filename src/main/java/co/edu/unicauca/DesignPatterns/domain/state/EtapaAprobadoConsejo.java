package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.EstadoProyecto;
import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public class EtapaAprobadoConsejo implements EtapaProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto aprobado por Consejo, se emite la resolución. Inicia desarrollo.");
        proyecto.setEstado(EstadoProyecto.EN_DESARROLLO);
        proyecto.setEtapa(new EtapaEnDesarrollo());
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
