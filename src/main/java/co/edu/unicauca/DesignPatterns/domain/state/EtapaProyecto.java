package co.edu.unicauca.DesignPatterns.domain.state;

import co.edu.unicauca.DesignPatterns.domain.entities.ProyectoDeGrado;

public interface EtapaProyecto {
    void presentar(ProyectoDeGrado proyecto);
    void corregir(ProyectoDeGrado proyecto);
    void aprobar(ProyectoDeGrado proyecto);
    void rechazar(ProyectoDeGrado proyecto);

}
