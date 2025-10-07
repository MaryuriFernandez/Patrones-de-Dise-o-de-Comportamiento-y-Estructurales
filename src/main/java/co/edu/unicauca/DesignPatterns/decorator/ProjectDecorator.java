package co.edu.unicauca.DesignPatterns.decorator;
import co.edu.unicauca.DesignPatterns.domain.entities.Project;

public abstract class ProjectDecorator extends Project{
    protected final Project project;

    public ProjectDecorator(Project project) {
        super(project.getTitulo(), project.getDescripcion(), project.getPrograma(),
                project.getTipoTrabajoGrado(), project.getEstudiante1(),
                project.getDirector(), project.getObjetivoGeneral());
        this.project = project;
    }
    
    @Override
    public abstract String getDescripcion();
    
}
