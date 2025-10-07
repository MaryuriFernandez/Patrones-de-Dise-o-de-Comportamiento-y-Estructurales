package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public class EtapaRechazado implements EtapaProyecto {
    @Override
    public void presentar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto rechazado. No puede continuar.");
    }

    @Override
    public void corregir(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto rechazado. Reinicie el proceso si desea continuar.");
    }

    @Override
    public void aprobar(ProyectoDeGrado proyecto) {
        System.out.println("Proyecto rechazado. No se puede aprobar.");
    }

    @Override
    public void rechazar(ProyectoDeGrado proyecto) {
        System.out.println("Ya está rechazado.");
    }
}
