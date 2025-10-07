package co.edu.unicauca.DesignPatterns.decorator;

import co.edu.unicauca.DesignPatterns.domain.entities.Programa;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;
import co.edu.unicauca.DesignPatterns.domain.entities.Rol;
import co.edu.unicauca.DesignPatterns.domain.entities.TipoTrabajoGrado;
import co.edu.unicauca.DesignPatterns.domain.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maryuri
 */
public class PriorityProjectTest {
   private User estudiante() {
        return new User(null, "Maryuri Fernandez Salazar", "maryurifernandez@unicauca.edu.co", Rol.ESTUDIANTE);
    }

    private User director() {
        return new User(null, "Libardo Pantoja Yepez", "libardoPantoja@unicauca.edu.co", Rol.DOCENTE);
    }

    private Project proyectoBase() {
        return new Project(
                "Sistema de Facturación",
                "Desarrollo de un sistema para gestionar las ventas y clientes de una tienda.",
                Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante(),
                director(),
                "Facilitar a los vendedores su trabajo"
        );
    }

    /** 
     * Debe conservar todos los datos del proyecto original (título, programa, tipo, estudiante, director, objetivo).
     */
    @Test
    void conservaDatosDelProyectoOriginal() {
        Project original = proyectoBase();
        PriorityProject decorado = new PriorityProject(original);

        assertEquals(original.getTitulo(), decorado.getTitulo());
        assertEquals(original.getPrograma(), decorado.getPrograma());
        assertEquals(original.getTipoTrabajoGrado(), decorado.getTipoTrabajoGrado());
        assertEquals(original.getEstudiante1(), decorado.getEstudiante1());
        assertEquals(original.getDirector(), decorado.getDirector());
        assertEquals(original.getObjetivoGeneral(), decorado.getObjetivoGeneral());
    }

    /** 
     * Debe modificar la descripción agregando el sufijo "[High Priority]".
     */
    @Test
    void modificaDescripcionConEtiquetaDePrioridad() {
        Project original = proyectoBase();
        PriorityProject decorado = new PriorityProject(original);

        String descripcionEsperada = original.getTitulo() + " [High Priority]";
        assertEquals(descripcionEsperada, decorado.getDescripcion());
    }

    /**
     * Debe lanzar excepción si se intenta decorar un proyecto nulo.
     */
    @Test
    void noPermiteProyectoNuloEnElConstructor() {
        assertThrows(NullPointerException.class, () -> new PriorityProject(null));
    }
    
}
