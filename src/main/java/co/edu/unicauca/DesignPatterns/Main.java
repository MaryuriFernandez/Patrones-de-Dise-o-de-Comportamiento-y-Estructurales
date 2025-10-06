package co.edu.unicauca.DesignPatterns;

import co.edu.unicauca.DesignPatterns.domain.state.ProyectoDeGrado;

public class Main {
    public static void main(String[] args) {
        // ------- PATRON DE ESTADOS ------

        ProyectoDeGrado proyecto = new ProyectoDeGrado();

        proyecto.presentar(); // Formato A diligenciado
        proyecto.corregir();  // Corrección formato A no.1
        proyecto.corregir();  // Corrección formato A no.2
        proyecto.corregir();  // Corrección formato A no.3
        proyecto.aprobar();   // Comité acepta
        proyecto.presentar(); // Presenta anteproyecto
        proyecto.corregir();  // Corrección anteproyecto no.1
        proyecto.corregir();  // Corrección anteproyecto no.2
        proyecto.corregir();  // Corrección anteproyecto no.3
        proyecto.aprobar();   // Aprobado por departamento
        proyecto.presentar(); // Entra a desarrollo
        proyecto.presentar(); // Presenta monografía
        proyecto.presentar(); // Fija fecha
        proyecto.aprobar();   // Sustentación aprobada

        // ------- PATRON DE ESTADOS ------
    }
}