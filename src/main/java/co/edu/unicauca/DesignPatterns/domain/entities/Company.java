package co.edu.unicauca.DesignPatterns.domain.entities;

import java.util.Objects;

/**
 * Entidad usada por el sistema interno para integración vía Adapter.
 */
public record Company(String name) {

    @Override
    public boolean equals(Object o) {
        return (o instanceof Company c) && Objects.equals(name, c.name);
    }

    @Override
    public String toString() {
        return "Company{name='" + name + "'}";
    }
}
