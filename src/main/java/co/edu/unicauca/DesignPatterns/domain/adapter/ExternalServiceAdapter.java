package co.edu.unicauca.DesignPatterns.domain.adapter;

import co.edu.unicauca.DesignPatterns.domain.entities.Company;
import org.json.JSONObject;

/** Adaptador: convierte el JSON del servicio externo a Company. */
public class ExternalServiceAdapter implements CompanyDataProvider {

    private final ExternalService service;

    public ExternalServiceAdapter(ExternalService service) {
        this.service = service;
    }

    @Override
    public Company getCompany() {
        String json = service.getCompanyData();
        try {
            JSONObject obj = new JSONObject(json);
            String name = obj.getString("name");
            return new Company(name);
        } catch (Exception e) {
            throw new IllegalStateException("JSON inválido desde ExternalService", e);
        }
    }
}
