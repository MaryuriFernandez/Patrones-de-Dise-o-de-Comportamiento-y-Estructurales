package co.edu.unicauca.DesignPatterns.domain.state;

public interface EstadoProyecto {
    void presentar(ProyectoDeGrado proyecto);
    void corregir(ProyectoDeGrado proyecto);
    void aprobar(ProyectoDeGrado proyecto);
    void rechazar(ProyectoDeGrado proyecto);
}
