package co.edu.unicauca.DesignPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        Project proyecto = new Project(
                "Sistema de Facturación",
                "Desarrollo de un sistema para gestionar las ventas y clientes de una tienda."
        );

        System.out.println("****************************");
        System.out.println("    PROYECTO ORIGINAL   ");
        System.out.println("****************************");
        System.out.println("Título: " + proyecto.getTitle());
        System.out.println("Descripción: " + proyecto.getDescription());
        System.out.println();

        PriorityProject proyectoPrioritario = new PriorityProject(proyecto);

        System.out.println("**********************************************");
        System.out.println("     PROYECTO DECORADO (Alta Prioridad)     ");
        System.out.println("**********************************************");
        System.out.println("Título: " + proyectoPrioritario.getTitle());
        System.out.println("Descripción: " + proyectoPrioritario.getDescription());
    }
}
