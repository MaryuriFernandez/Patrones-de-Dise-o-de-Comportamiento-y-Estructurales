package co.edu.unicauca.DesignPatterns.domain.facade;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;

public class EvaluationSystem {
    public boolean evaluate(Project project) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Evaluando proyecto: " + project.getTitulo());
        System.out.println("del estudiante: " + project.getEstudiante1().getFullName());

        boolean approved = Math.random() > 0.2;
        if (approved) {
            System.out.println("Proyecto aprovado");
        } else {
            System.out.println("Proyecto no aprovado.");
        }
        System.out.println("---------------------------------------------------------------------");
        return approved;
    }
}
