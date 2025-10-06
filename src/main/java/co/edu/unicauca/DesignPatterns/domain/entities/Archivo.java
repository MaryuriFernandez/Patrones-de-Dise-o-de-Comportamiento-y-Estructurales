package co.edu.unicauca.DesignPatterns.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/** Archivo asociado a un Project. */
public class Archivo {
    private final UUID id;
    private final Project project;
    private final TipoArchivo tipo;
    private final String nombre;
    private EstadoArchivo estado;
    private final LocalDateTime createdAt;

    public Archivo(Project project, TipoArchivo tipo, String nombre) {
        this.id = UUID.randomUUID();
        this.project = project;
        this.tipo = tipo;
        this.nombre = nombre;
        this.estado = EstadoArchivo.ENVIADO;
        this.createdAt = LocalDateTime.now();
        validate();
    }

    public UUID getId() { return id; }
    public Project getProject() { return project; }
    public TipoArchivo getTipo() { return tipo; }
    public String getNombre() { return nombre; }
    public EstadoArchivo getEstado() { return estado; }
    public void setEstado(EstadoArchivo estado) { this.estado = estado; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    private void validate() {
        if (project == null) throw new IllegalArgumentException("Project requerido");
        if (tipo == null) throw new IllegalArgumentException("TipoArchivo requerido");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
    }

    @Override public boolean equals(Object o){ return (o instanceof Archivo a) && id.equals(a.id); }
    @Override public int hashCode(){ return Objects.hash(id); }
}
