package co.edu.unicauca.DesignPatterns.domain.facade;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;

public class PlatformFacade {

    private EvaluationSystem evaluation;
    private EvaluatorsAssignment assignment;

    public PlatformFacade() {
        this.evaluation = new EvaluationSystem();
        this.assignment = new EvaluatorsAssignment();
    }

    public void manageProject(Project project) {
        if (evaluation.evaluate(project)) {
            if (assignment.assign(project)) {
                System.out.println("Project successfully evaluated and assigned.");
            } else {
                System.out.println("Project approved but no evaluators available.");
            }
        } else {
            System.out.println("Project evaluation failed.");
        }
    }
}
