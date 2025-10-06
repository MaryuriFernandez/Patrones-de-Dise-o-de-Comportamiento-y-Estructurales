package co.edu.unicauca.DesignPatterns.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/** Entidad central para la evaluación y gestión de proyectos de grado. */
public class Project {

    private final UUID id;
    private final LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaRevision;

    private String titulo;
    private String descripcion;
    private Programa programa;
    private TipoTrabajoGrado tipoTrabajoGrado;

    // Participantes
    private User estudiante1;
    private User estudiante2; // opcional, solo para investigación
    private User director;
    private User codirector1;
    private User codirector2;

    // Objetivos
    private String objetivoGeneral;
    private final List<String> objetivosEspecificos = new ArrayList<>();

    // Estado del proceso
    private boolean aprobado;

    public Project(String titulo,
                   String descripcion,
                   Programa programa,
                   TipoTrabajoGrado tipoTrabajoGrado,
                   User estudiante1,
                   User director,
                   String objetivoGeneral) {

        this.id = UUID.randomUUID();
        this.fechaCreacion = LocalDateTime.now();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.programa = programa;
        this.tipoTrabajoGrado = tipoTrabajoGrado;
        this.estudiante1 = estudiante1;
        this.director = director;
        this.objetivoGeneral = objetivoGeneral;
        validar();
    }

    // Getters y setters principales
    public UUID getId() { return id; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaUltimaRevision() { return fechaUltimaRevision; }
    public void setFechaUltimaRevision(LocalDateTime fechaUltimaRevision) { this.fechaUltimaRevision = fechaUltimaRevision; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Programa getPrograma() { return programa; }
    public void setPrograma(Programa programa) { this.programa = programa; }

    public TipoTrabajoGrado getTipoTrabajoGrado() { return tipoTrabajoGrado; }
    public void setTipoTrabajoGrado(TipoTrabajoGrado tipoTrabajoGrado) {
        this.tipoTrabajoGrado = tipoTrabajoGrado;
        validar();
    }

    public User getEstudiante1() { return estudiante1; }
    public void setEstudiante1(User estudiante1) { this.estudiante1 = estudiante1; validar(); }

    public User getEstudiante2() { return estudiante2; }
    public void setEstudiante2(User estudiante2) { this.estudiante2 = estudiante2; validar(); }

    public User getDirector() { return director; }
    public void setDirector(User director) { this.director = director; validar(); }

    public User getCodirector1() { return codirector1; }
    public void setCodirector1(User codirector1) { this.codirector1 = codirector1; }

    public User getCodirector2() { return codirector2; }
    public void setCodirector2(User codirector2) { this.codirector2 = codirector2; }

    public String getObjetivoGeneral() { return objetivoGeneral; }
    public void setObjetivoGeneral(String objetivoGeneral) { this.objetivoGeneral = objetivoGeneral; }

    public List<String> getObjetivosEspecificos() { return List.copyOf(objetivosEspecificos); }

    /** Agrega un nuevo objetivo específico (máximo 4 permitidos). */
    public void agregarObjetivoEspecifico(String objetivo) {
        if (objetivo == null || objetivo.isBlank())
            throw new IllegalArgumentException("El objetivo específico es obligatorio.");
        if (objetivosEspecificos.size() >= 4)
            throw new IllegalStateException("Máximo 4 objetivos específicos permitidos.");
        objetivosEspecificos.add(objetivo);
    }

    /** Elimina todos los objetivos específicos registrados. */
    public void limpiarObjetivosEspecificos() {
        objetivosEspecificos.clear();
    }

    public boolean isAprobado() { return aprobado; }
    public void setAprobado(boolean aprobado) { this.aprobado = aprobado; }

    /** Marca el proyecto como aprobado. */
    public void aprobar() { this.aprobado = true; }

    /** Marca el proyecto como no aprobado. */
    public void rechazar() { this.aprobado = false; }

    /** Actualiza la fecha de la última revisión del proyecto. */
    public void actualizarRevision() { this.fechaUltimaRevision = LocalDateTime.now(); }

    /** Devuelve una etiqueta identificadora del proyecto. */
    public String etiqueta() {
        return (titulo == null || titulo.isBlank()) ? "Proyecto sin título" : titulo;
    }

    /** Valida las reglas e invariantes del dominio. */
    private void validar() {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("El título es obligatorio.");
        if (tipoTrabajoGrado == null) throw new IllegalArgumentException("El tipo de trabajo de grado es obligatorio.");
        if (estudiante1 == null) throw new IllegalArgumentException("Debe existir al menos un estudiante.");
        if (director == null) throw new IllegalArgumentException("El director es obligatorio.");
        if (objetivoGeneral == null || objetivoGeneral.isBlank()) throw new IllegalArgumentException("El objetivo general es obligatorio.");

        if (codirector1 != null && codirector1.equals(codirector2))
            throw new IllegalStateException("Los codirectores deben ser diferentes.");

        if (objetivosEspecificos.size() > 4)
            throw new IllegalStateException("Máximo 4 objetivos específicos permitidos.");

        // Reglas específicas por modalidad
        switch (tipoTrabajoGrado) {
            case PROYECTO_DE_INVESTIGACION -> {
                // Puede tener uno o dos estudiantes.
                // No se requiere validación adicional.
            }
            case PRACTICA_PROFESIONAL -> {
                if (estudiante2 != null)
                    throw new IllegalStateException("Esta modalidad permite solo un estudiante.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Project p) && id.equals(p.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Proyecto{id=" + id + ", título='" + titulo + "', aprobado=" + aprobado + "}";
    }
}
