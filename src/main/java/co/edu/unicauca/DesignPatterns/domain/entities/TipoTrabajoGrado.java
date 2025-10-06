package co.edu.unicauca.DesignPatterns.domain.entities;

/** Modalidades del trabajo de grado. */
public enum TipoTrabajoGrado {
    PRACTICA_PROFESIONAL("Práctica Profesional"),
    PROYECTO_DE_INVESTIGACION("Proyecto de Investigación");

    private final String nombre;
    TipoTrabajoGrado(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    @Override public String toString() { return nombre; }
}
