package co.edu.unicauca.DesignPatterns.domain.adapter;

import co.edu.unicauca.DesignPatterns.domain.entities.Company;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExternalServiceAdapterTest {

    @Test
    void adaptaJsonACompany() {
        CompanyDataProvider provider = new ExternalServiceAdapter(new ExternalService());
        Company c = provider.getCompany();
        assertEquals("Empaques del Cauca", c.name());
    }

    @Test
    void fallaConJsonInvalido() {
        ExternalService bad = new ExternalService() {
            @Override public String getCompanyData() { return "{mal_json}"; }
        };
        CompanyDataProvider provider = new ExternalServiceAdapter(bad);
        assertThrows(IllegalStateException.class, provider::getCompany);
    }
}
