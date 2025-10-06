package co.edu.unicauca.DesignPatterns.domain.entities;

/** Programas académicos disponibles. */
public enum Programa {
    INGENIERIA_DE_SISTEMAS("Ingeniería de Sistemas"),
    INGENIERIA_ELECTRONICA_Y_TELECOMUNICACIONES("Ingeniería Electrónica y Telecomunicaciones"),
    AUTOMATICA_INDUSTRIAL("Automática Industrial"),
    TECNOLOGIA_EN_TELEMATICA("Tecnología en Telemática");

    private final String nombre;
    Programa(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    @Override public String toString() { return nombre; }
}
