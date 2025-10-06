package co.edu.unicauca.DesignPatterns.domain.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectDomainTest {

    private User est() { return new User(null, "Est", "e@uni.edu", Rol.ESTUDIANTE); }
    private User est2() { return new User(null, "Est2", "e2@uni.edu", Rol.ESTUDIANTE); }
    private User dir() { return new User(null, "Dir", "d@uni.edu", Rol.DOCENTE); }

    /** Debe permitir 2 estudiantes solo en investigación. */
    @Test
    void cardinalidadEstudiantesPorModalidad() {
        Project inv = new Project("T", "D con metodología.", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION, est(), dir(), "OG");
        assertDoesNotThrow(() -> inv.setEstudiante2(est2()));

        Project pp = new Project("T", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, est(), dir(), "OG");
        assertThrows(IllegalStateException.class, () -> pp.setEstudiante2(est2()));
    }

    /** Debe limitar objetivos específicos a 4. */
    @Test
    void maximoCuatroObjetivosEspecificos() {
        Project p = new Project("T", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, est(), dir(), "OG");
        p.agregarObjetivoEspecifico("O1");
        p.agregarObjetivoEspecifico("O2");
        p.agregarObjetivoEspecifico("O3");
        p.agregarObjetivoEspecifico("O4");
        assertThrows(IllegalStateException.class, () -> p.agregarObjetivoEspecifico("O5"));
    }

    /** Debe exigir título, objetivo general, estudiante1 y director. */
    @Test
    void validacionesBasicasObligatorias() {
        assertThrows(IllegalArgumentException.class, () ->
            new Project("", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, est(), dir(), "OG"));
        assertThrows(IllegalArgumentException.class, () ->
            new Project("T", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, null, dir(), "OG"));
        assertThrows(IllegalArgumentException.class, () ->
            new Project("T", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, est(), null, "OG"));
        assertThrows(IllegalArgumentException.class, () ->
            new Project("T", "D", Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL, est(), dir(), ""));
    }
}
