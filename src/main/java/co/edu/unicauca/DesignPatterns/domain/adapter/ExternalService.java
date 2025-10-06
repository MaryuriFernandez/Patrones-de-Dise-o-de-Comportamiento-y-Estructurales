package co.edu.unicauca.DesignPatterns.domain.adapter;

/** Servicio externo incompatible que retorna datos en JSON. */
public class ExternalService {

    /** Retorna una empresa en formato JSON. */
    public String getCompanyData() {
        return "{\"name\":\"Empaques del Cauca\"}";
    }
}
