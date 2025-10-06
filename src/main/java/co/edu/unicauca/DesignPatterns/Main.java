package co.edu.unicauca.DesignPatterns;

import co.edu.unicauca.DesignPatterns.decorator.PriorityProject;
import co.edu.unicauca.DesignPatterns.domain.adapter.CompanyDataProvider;
import co.edu.unicauca.DesignPatterns.domain.adapter.ExternalService;
import co.edu.unicauca.DesignPatterns.domain.adapter.ExternalServiceAdapter;
import co.edu.unicauca.DesignPatterns.domain.entities.*;
import co.edu.unicauca.DesignPatterns.domain.facade.PlatformFacade;
import co.edu.unicauca.DesignPatterns.domain.templatemethod.ProfessionalPracticeEvaluator;
import co.edu.unicauca.DesignPatterns.domain.templatemethod.ProjectEvaluator;
import co.edu.unicauca.DesignPatterns.domain.templatemethod.ResearchProjectEvaluator;

public class Main {

    /**
     * Punto de entrada: ejecutar demostraciones por patrón.
     */
    public static void main(String[] args) {
        demoTemplateMethod();   // Implementado
        demoAdapter();          // TODO
        demoState();            // TODO
        demoDecorator();        // Implementado
        demoFacade();           // Implementado
    }

    // -------------------------------------------------------------------------
    // TEMPLATE METHOD
    // Flujo común de evaluación con estrategias por modalidad.
    // -------------------------------------------------------------------------
    private static void demoTemplateMethod() {
        System.out.println("=== TEMPLATE METHOD ===");

        // Práctica Profesional
        Project practica = new Project(
                "Sistema de seguimiento de prácticas",
                "Aplicación para registrar avances semanales en empresa aliada.",
                Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                new User(null, "Estudiante Uno", "e1@uni.edu", Rol.ESTUDIANTE),
                new User(null, "Docente Director", "dir@uni.edu", Rol.DOCENTE),
                "Implementar un sistema funcional para seguimiento de prácticas."
        );
        practica.agregarObjetivoEspecifico("Registrar avances semanales");
        practica.agregarObjetivoEspecifico("Generar reportes mensuales");

        ProjectEvaluator evalPractica = new ProfessionalPracticeEvaluator();
        evalPractica.evaluate(practica);
        System.out.println("[PRACTICA] Aprobado: " + practica.isAprobado()
                + " | Última revisión: " + practica.getFechaUltimaRevision());

        // Investigación
        Project investigacion = new Project(
                "Análisis de rendimiento en redes IoT",
                "Estudio comparativo con metodología experimental para medir latencia y pérdida.",
                Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION,
                new User(null, "Estudiante Dos", "e2@uni.edu", Rol.ESTUDIANTE),
                new User(null, "Docente Investigador", "invest@uni.edu", Rol.DOCENTE),
                "Evaluar el impacto de configuraciones de red sobre latencia en IoT."
        );
        investigacion.setEstudiante2(new User(null, "Estudiante Tres", "e3@uni.edu", Rol.ESTUDIANTE)); // permitido
        investigacion.agregarObjetivoEspecifico("Definir protocolo de pruebas");
        investigacion.agregarObjetivoEspecifico("Medir latencia en escenarios controlados");

        ProjectEvaluator evalInvestigacion = new ResearchProjectEvaluator();
        evalInvestigacion.evaluate(investigacion);
        System.out.println("[INVESTIGACION] Aprobado: " + investigacion.isAprobado()
                + " | Última revisión: " + investigacion.getFechaUltimaRevision());

        System.out.println();
    }

    // -------------------------------------------------------------------------
    // ADAPTER
    // Integración de ExternalService (JSON) hacia CompanyDataProvider.
    // -------------------------------------------------------------------------
    private static void demoAdapter() {
        System.out.println("=== ADAPTER ===");
        CompanyDataProvider provider = new ExternalServiceAdapter(new ExternalService());
        Company company = provider.getCompany();
        System.out.println("Empresa integrada: " + company.name());
        System.out.println();
    }


    // -------------------------------------------------------------------------
    // STATE
    // Gestión de estados del proceso académico.
    // -------------------------------------------------------------------------
    private static void demoState() {
        System.out.println("=== STATE ===");
        // TODO
        System.out.println("(pendiente de integrar)");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // DECORATOR
    // Extender responsabilidades de Project sin modificar su clase.
    // -------------------------------------------------------------------------
    private static void demoDecorator() {
        System.out.println("=== DECORATOR ===");
        User estudiante = new User(null, "Maryuri Fernandez Salazar", "maryurifernandez@unicauca.edu.co", Rol.ESTUDIANTE);
        User director = new User(null, "Libardo Pantoja Yepez", "libardoPantoja@unicauca.edu.co", Rol.DOCENTE);

        Project proyecto = new Project(
                "Sistema de Facturacion",
                "Desarrollo de un sistema para gestionar las ventas y clientes de una tienda.",
                Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante,
                director,
                "facilitar a vendedores su trabajo"
        );

        System.out.println("****************************");
        System.out.println("    PROYECTO ORIGINAL   ");
        System.out.println("****************************");
        System.out.println("Titulo: " + proyecto.getTitulo());
        System.out.println("Descripcion: " + proyecto.getDescripcion());
        System.out.println("Programa: " + proyecto.getPrograma());
        System.out.println("Tipo de trabajo de grado: " + proyecto.getTipoTrabajoGrado());
        System.out.println("Estudiante: " + proyecto.getEstudiante1().getFullName());
        System.out.println("Director: " + proyecto.getDirector().getFullName());
        System.out.println("Objetivo general: " + proyecto.getObjetivoGeneral());
        System.out.println();

        PriorityProject proyectoPrioritario = new PriorityProject(proyecto);

        System.out.println("**********************************************");
        System.out.println("     PROYECTO DECORADO (Alta Prioridad)     ");
        System.out.println("**********************************************");
        System.out.println("Titulo: " + proyectoPrioritario.getTitulo());
        System.out.println("Descripcion: " + proyectoPrioritario.getDescripcion());
        System.out.println("Programa: " + proyectoPrioritario.getPrograma());
        System.out.println("Tipo de trabajo de grado: " + proyectoPrioritario.getTipoTrabajoGrado());
        System.out.println("Estudiante: " + proyectoPrioritario.getEstudiante1().getFullName());
        System.out.println("Director: " + proyectoPrioritario.getDirector().getFullName());
        System.out.println("Objetivo general: " + proyectoPrioritario.getObjetivoGeneral());
        System.out.println("\n\n");
    }

    // -------------------------------------------------------------------------
    // FACADE
    // Fachada para orquestar subsistemas de evaluación/asignación.
    // -------------------------------------------------------------------------
    private static void demoFacade() {
        System.out.println("=== FACADE ===");

        PlatformFacade platform = new PlatformFacade();

        User estudiante1 = new User(null, "Laura Molano", "lauramolano@unicauca.edu.co", Rol.ESTUDIANTE);
        User director1 = new User(null, "Erwin Meza Vega", "erwin@unicauca.edu.co", Rol.DOCENTE);
        Project proyecto1 = new Project(
                "Sistema de Gestión Académica",
                "Desarrollo de un sistema para gestionar las notas de los estudiantes.",
                Programa.INGENIERIA_DE_SISTEMAS,
                TipoTrabajoGrado.PRACTICA_PROFESIONAL,
                estudiante1,
                director1,
                "facilitar a docentes la gestion de notas de sus estudiantes"
        );
        User estudiante2 = new User(null, "Juan Ortega", "jortega@unicauca.edu.co", Rol.ESTUDIANTE);
        User director2 = new User(null, "Pablo Mage", "pablo@unicauca.edu.co", Rol.DOCENTE);
        Project proyecto2 = new Project(
                "Análisis comparativo de metodologías de desarrollo",
                "Evaluación de diferentes enfoques para crear y gestionar sistemas de información, identificando sus fortalezas y debilidades.",
                Programa.AUTOMATICA_INDUSTRIAL,
                TipoTrabajoGrado.PROYECTO_DE_INVESTIGACION,
                estudiante2,
                director2,
                "determinar cuál es la metodología más adecuada para un propósito específico"
        );
        System.out.println("***************************************");
        System.out.println("GESTIONANDO UN PROYECTO DE GRADO...");
        System.out.println("***************************************");
        platform.manageProject(proyecto1);

        System.out.println("\n***************************************");
        System.out.println("GESTIONANDO UN PROYECTO DE GRADO...");
        System.out.println("***************************************");
        platform.manageProject(proyecto2);
        System.out.println();
    }
}
