package co.edu.unicauca.DesignPatterns.domain.entities;

import co.edu.unicauca.DesignPatterns.domain.state.EtapaInicio;
import co.edu.unicauca.DesignPatterns.domain.state.EtapaProyecto;

public class ProyectoDeGrado {
    private EstadoProyecto estado;
    private EtapaProyecto etapa;
    private int intentosCorreccion = 0;

    public ProyectoDeGrado() {
        estado = EstadoProyecto.PRESENTADO_AL_COORDINADOR;
        this.etapa = new EtapaInicio(); // Estado inicial
    }

    public void setEtapa(EtapaProyecto etapa) {
        this.etapa = etapa;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public EtapaProyecto getEtapa() {
        return etapa;
    }

    public int getIntentosCorreccion() {
        return intentosCorreccion;
    }

    public void incrementarIntentos() {
        intentosCorreccion++;
    }

    public void reiniciarIntentos() {
        intentosCorreccion=0;
    }

    // Métodos delegados
    public void presentar() { etapa.presentar(this); }
    public void corregir() { etapa.corregir(this); }
    public void aprobar() { etapa.aprobar(this); }
    public void rechazar() { etapa.rechazar(this); }
}