package co.edu.unicauca.DesignPatterns.domain.facade;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;

public class EvaluatorsAssignment {
    public boolean assign(Project project) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Asignando evaluadores para el proyecto: " + project.getTitulo());
        boolean assigned = Math.random() > 0.3;
        if (assigned) {
            System.out.println("Evaluadores asignados exitosamente.");
        } else {
            System.out.println("No hay evaluadores disponibles para este proyecto.");
        }
        System.out.println("---------------------------------------------------------------------");
        return assigned;
    }
}
