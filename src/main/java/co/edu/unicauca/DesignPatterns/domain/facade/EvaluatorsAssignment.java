package co.edu.unicauca.DesignPatterns.domain.facade;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;

public class EvaluatorsAssignment {
    public boolean assign(Project project) {
        System.out.println("Asignando evaluadores para el proyecto: " + project.getTitulo());
        boolean assigned = Math.random() > 0.4;
        System.out.println("---------------------------------------------------------------------");
        return assigned;
    }
}
