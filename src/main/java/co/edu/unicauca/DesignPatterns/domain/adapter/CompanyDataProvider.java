package co.edu.unicauca.DesignPatterns.domain.adapter;

import co.edu.unicauca.DesignPatterns.domain.entities.Company;

/** Interfaz esperada por el sistema interno. */
public interface CompanyDataProvider {

    /** Retorna la empresa en el formato del dominio. */
    Company getCompany();
}
