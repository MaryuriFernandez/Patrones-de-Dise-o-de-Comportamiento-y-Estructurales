package co.edu.unicauca.DesignPatterns.domain.templatemethod;

import co.edu.unicauca.DesignPatterns.domain.entities.Project;

/** Define el flujo común de evaluación de proyectos de grado. */
public abstract class ProjectEvaluator {

    /** Secuencia fija del proceso de evaluación. */
    public final void evaluate(Project proyecto) {
        onStart();                  // limpia estado interno del evaluador
        reviewProblem(proyecto);
        reviewGoals(proyecto);
        reviewScope(proyecto);
        makeDecision(proyecto);
        proyecto.actualizarRevision(); // marca fecha de revisión
    }

    /** Hook para inicialización del ciclo de evaluación. */
    protected void onStart() {}

    protected abstract void reviewProblem(Project proyecto);
    protected abstract void reviewGoals(Project proyecto);
    protected abstract void reviewScope(Project proyecto);
    protected abstract void makeDecision(Project proyecto);
}
