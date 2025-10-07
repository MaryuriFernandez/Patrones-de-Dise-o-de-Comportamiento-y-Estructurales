package co.edu.unicauca.DesignPatterns.domain.state;

public class ProyectoDeGrado {
    private EstadoProyecto estado;
    private int intentosCorreccion = 0;

    public ProyectoDeGrado() {
        this.estado = new EstadoInicio(); // Estado inicial
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public EstadoProyecto getEstado() {
        return estado;
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
    public void presentar() { estado.presentar(this); }
    public void corregir() { estado.corregir(this); }
    public void aprobar() { estado.aprobar(this); }
    public void rechazar() { estado.rechazar(this); }
}
