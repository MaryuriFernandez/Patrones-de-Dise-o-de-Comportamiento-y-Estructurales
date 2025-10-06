package co.edu.unicauca.DesignPatterns.domain.templatemethod;

import co.edu.unicauca.DesignPatterns.domain.entities.Project;
import co.edu.unicauca.DesignPatterns.domain.entities.TipoTrabajoGrado;

/** Estrategia de evaluación para Proyecto de Investigación. */
public class ResearchProjectEvaluator extends ProjectEvaluator {

    private boolean problemaOk;
    private boolean objetivosOk;
    private boolean alcanceOk;

    /** Reinicia el estado interno antes de cada evaluación. */
    @Override
    protected void onStart() {
        problemaOk = false;
        objetivosOk = false;
        alcanceOk = false;
    }

    /** Evalúa formulación del problema y presencia de base metodológica. */
    @Override
    protected void reviewProblem(Project proyecto) {
        boolean tituloDesc = notBlank(proyecto.getTitulo()) && notBlank(proyecto.getDescripcion());
        boolean tieneMetodologia = containsIgnoreCase(proyecto.getDescripcion(), "metodolog");
        problemaOk = tituloDesc && tieneMetodologia;
    }

    /** Verifica objetivo general y suficiencia de objetivos específicos. */
    @Override
    protected void reviewGoals(Project proyecto) {
        boolean general = notBlank(proyecto.getObjetivoGeneral());
        // Para investigación se exige al menos 2 objetivos específicos
        boolean suficientes = proyecto.getObjetivosEspecificos().size() >= 2;
        objetivosOk = general && suficientes;
    }

    /** Comprueba modalidad correcta, director y cardinalidad de estudiantes. */
    @Override
    protected void reviewScope(Project proyecto) {
        boolean modalidad = proyecto.getTipoTrabajoGrado() == TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION;
        boolean unoODosEstudiantes =
                proyecto.getEstudiante1() != null; // siempre hay 1
                // estudiante2 puede ser null o no; ambas válidas en investigación
        boolean director = proyecto.getDirector() != null;
        alcanceOk = modalidad && unoODosEstudiantes && director;
    }

    /** Decide la aprobación o rechazo del proyecto. */
    @Override
    protected void makeDecision(Project proyecto) {
        if (problemaOk && objetivosOk && alcanceOk)
            proyecto.aprobar();
        else
            proyecto.rechazar();
    }

    /** Verifica que una cadena no sea nula ni vacía. */
    private static boolean notBlank(String s) {
        return s != null && !s.isBlank();
    }

    /** Búsqueda simple, insensible a mayúsculas. */
    private static boolean containsIgnoreCase(String text, String needle) {
        if (text == null || needle == null) return false;
        return text.toLowerCase().contains(needle.toLowerCase());
    }
}