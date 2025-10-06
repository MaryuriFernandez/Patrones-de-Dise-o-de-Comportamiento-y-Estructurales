package co.edu.unicauca.DesignPatterns;

import co.edu.unicauca.DesignPatterns.domain.adapter.CompanyDataProvider;
import co.edu.unicauca.DesignPatterns.domain.adapter.ExternalService;
import co.edu.unicauca.DesignPatterns.domain.adapter.ExternalServiceAdapter;
import co.edu.unicauca.DesignPatterns.domain.entities.*;
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
        demoDecorator();        // TODO
        demoFacade();           // TODO
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
        // TODO
        System.out.println("(pendiente de integrar)");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // FACADE
    // Fachada para orquestar subsistemas de evaluación/asignación.
    // -------------------------------------------------------------------------
    private static void demoFacade() {
        System.out.println("=== FACADE ===");
        // TODO
        System.out.println("(pendiente de integrar)");
        System.out.println();
    }
}
