package co.edu.unicauca.DesignPatterns.decorator;

public abstract class ProjectDecorator extends Project{
    protected final Project project;

    public ProjectDecorator(Project project) {
        super(project.getTitle(), project.getDescription());
        this.project = project;
    }

    @Override
    public String getTitle() {
        return project.getTitle();
    }

    @Override
    public void setTitle(String title) {
        project.setTitle(title);
    }

    @Override
    public String getDescription() {
        return project.getDescription();
    }

    @Override
    public void setDescription(String description) {
        project.setDescription(description);
    }
}
