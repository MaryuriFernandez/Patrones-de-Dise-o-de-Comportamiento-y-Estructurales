package co.edu.unicauca.DesignPatterns.domain.templatemethod;

import co.edu.unicauca.DesignPatterns.domain.entities.Project;
import co.edu.unicauca.DesignPatterns.domain.entities.TipoTrabajoGrado;

/** Estrategia de evaluación para Práctica Profesional. */
public class ProfessionalPracticeEvaluator extends ProjectEvaluator {

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

    /** Evalúa la claridad del problema y la descripción del proyecto. */
    @Override
    protected void reviewProblem(Project proyecto) {
        problemaOk = notBlank(proyecto.getTitulo()) && notBlank(proyecto.getDescripcion());
    }

    /** Verifica la coherencia y existencia de los objetivos definidos. */
    @Override
    protected void reviewGoals(Project proyecto) {
        boolean general = notBlank(proyecto.getObjetivoGeneral());
        boolean alMenosUno = !proyecto.getObjetivosEspecificos().isEmpty();
        objetivosOk = general && alMenosUno;
    }

    /** Comprueba que la modalidad y los participantes sean válidos. */
    @Override
    protected void reviewScope(Project proyecto) {
        boolean modalidad = proyecto.getTipoTrabajoGrado() == TipoTrabajoGrado.PRACTICA_PROFESIONAL;
        boolean unEstudiante = proyecto.getEstudiante1() != null && proyecto.getEstudiante2() == null;
        boolean director = proyecto.getDirector() != null;
        alcanceOk = modalidad && unEstudiante && director;
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
}
