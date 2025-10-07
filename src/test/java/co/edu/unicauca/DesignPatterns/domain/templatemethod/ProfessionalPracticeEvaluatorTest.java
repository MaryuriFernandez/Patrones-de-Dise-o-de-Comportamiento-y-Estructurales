package co.edu.unicauca.DesignPatterns.domain.templatemethod;

import co.edu.unicauca.DesignPatterns.domain.entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessionalPracticeEvaluatorTest {

    private User estudiante() { return new User(null, "Est 1", "e1@uni.edu", Rol.ESTUDIANTE); }
    private User docente() { return new User(null, "Dir", "dir@uni.edu", Rol.DOCENTE); }

    /** Debe aprobar: práctica con título, desc, objetivo general y 1+ específicos. */
    @Test
    void apruebaPracticaConDatosMinimos() {
        Project p = new Project(
                "Seguimiento PP", "Sistema para control de prácticas.",
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante(), docente(), "Implementar sistema básico"
        );
        p.agregarObjetivoEspecifico("Registrar avances");
        new ProfessionalPracticeEvaluator().evaluate(p);
        assertTrue(p.isAprobado());
        assertNotNull(p.getFechaUltimaRevision());
    }

    /** Debe rechazar: práctica con dos estudiantes. */
    @Test
    void rechazaPracticaConDosEstudiantes() {
        Project p = new Project(
                "PP con 2", "Desc válida.",
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante(), docente(), "Objetivo general"
        );
        assertThrows(IllegalStateException.class, () -> p.setEstudiante2(estudiante()));
    }

    /** Debe rechazar: práctica sin objetivos específicos. */
    @Test
    void rechazaPracticaSinObjetivosEspecificos() {
        Project p = new Project(
                "PP sin OE", "Desc válida.",
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante(), docente(), "Objetivo general"
        );
        new ProfessionalPracticeEvaluator().evaluate(p);
        assertFalse(p.isAprobado());
    }
}
