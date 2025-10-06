package co.edu.unicauca.DesignPatterns.decorator;

public class PriorityProject extends ProjectDecorator{

    public PriorityProject(Project project) {
        super(project);
    }

    @Override
    public String getDescription() {
        return project.getTitle() + " [High Priority]";
    }
}
