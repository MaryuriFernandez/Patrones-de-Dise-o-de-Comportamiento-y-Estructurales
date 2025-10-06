package co.edu.unicauca.DesignPatterns.domain.templatemethod;

import co.edu.unicauca.DesignPatterns.domain.entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResearchProjectEvaluatorTest {

    private User estudiante() { return new User(null, "Est", "e@uni.edu", Rol.ESTUDIANTE); }
    private User estudiante2() { return new User(null, "Est2", "e2@uni.edu", Rol.ESTUDIANTE); }
    private User docente() { return new User(null, "Dir", "dir@uni.edu", Rol.DOCENTE); }

    /** Debe aprobar: investigación con metodología y ≥2 objetivos específicos. */
    @Test
    void apruebaInvestigacionConMetodologiaY2Objetivos() {
        Project p = new Project(
                "Rendimiento IoT",
                "Estudio con metodología experimental para medir latencia.",
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION,
                estudiante(), docente(), "Evaluar desempeño en IoT"
        );
        p.setEstudiante2(estudiante2()); // válido en investigación
        p.agregarObjetivoEspecifico("Definir protocolo");
        p.agregarObjetivoEspecifico("Medir latencia");
        new ResearchProjectEvaluator().evaluate(p);
        assertTrue(p.isAprobado());
        assertNotNull(p.getFechaUltimaRevision());
    }

    /** Debe rechazar: investigación sin indicios de metodología. */
    @Test
    void rechazaInvestigacionSinMetodologia() {
        Project p = new Project(
                "Rendimiento IoT",
                "Estudio comparativo con pruebas de red.", // sin 'metodolog'
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION,
                estudiante(), docente(), "Analizar desempeño"
        );
        p.agregarObjetivoEspecifico("Definir protocolo");
        p.agregarObjetivoEspecifico("Medir latencia");
        new ResearchProjectEvaluator().evaluate(p);
        assertFalse(p.isAprobado());
    }

    /** Debe rechazar: investigación con <2 objetivos específicos. */
    @Test
    void rechazaInvestigacionConMenosDeDosObjetivos() {
        Project p = new Project(
                "Rendimiento IoT",
                "Con metodología descriptiva básica.",
                Programa.INGENIERIA_DE_SISTEMAS, TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION,
                estudiante(), docente(), "Analizar desempeño"
        );
        p.agregarObjetivoEspecifico("Definir protocolo");
        new ResearchProjectEvaluator().evaluate(p);
        assertFalse(p.isAprobado());
    }
}
