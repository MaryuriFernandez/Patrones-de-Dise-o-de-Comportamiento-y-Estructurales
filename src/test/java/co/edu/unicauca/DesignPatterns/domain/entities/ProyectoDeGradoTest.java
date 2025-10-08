package co.edu.unicauca.DesignPatterns.domain.entities;

import co.edu.unicauca.DesignPatterns.domain.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProyectoDeGradoTest {
    private ProyectoDeGrado proyecto;

    @BeforeEach
    void setUp() {
        proyecto = new ProyectoDeGrado();
    }

    @Test
    void testInicio() {
        // Estado inicial
        assertInstanceOf(EtapaInicio.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.PRESENTADO_AL_COORDINADOR, getEstado(proyecto));

        // De presentar pasa a evaluación de comité
        proyecto.presentar();

        assertInstanceOf(EtapaEnEvaluacionComite.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.EN_EVALUACION_COMITE, getEstado(proyecto));
    }

    @Test
    void testCorreccionesComiteHastaRechazo() {
        proyecto.presentar(); // pasa a comité

        // Se hacen 4 correcciones (más de 3)
        proyecto.corregir();
        proyecto.corregir();
        proyecto.corregir();
        proyecto.corregir();

        assertInstanceOf(EtapaRechazado.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.RECHAZADO_POR_COMITE, getEstado(proyecto));
    }

    @Test
    void testAprobacionComite() {
        proyecto.presentar(); // a comité
        proyecto.aprobar();   // comité aprueba

        assertInstanceOf(EtapaEscribiendoAnteproyecto.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.ESCRIBIENDO_ANTEPROYECTO, getEstado(proyecto));
    }

    @Test
    void testPresentarAnteproyecto() {
        pasarAEtapaEscribiendoAnteproyecto();

        proyecto.presentar(); // presentar anteproyecto

        assertInstanceOf(EtapaEnEvaluacionDepartamento.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.EVALUACION_DEPARTAMENTO, getEstado(proyecto));
    }

    @Test
    void testCorreccionesDepartamentoHastaRechazo() {
        pasarAEtapaEvaluacionDepartamento();

        // 4 correcciones seguidas
        proyecto.corregir();
        proyecto.corregir();
        proyecto.corregir();
        proyecto.corregir();

        assertInstanceOf(EtapaRechazado.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.EVALUADOR_RECHAZA, getEstado(proyecto));
    }

    @Test
    void testAprobacionDepartamento() {
        pasarAEtapaEvaluacionDepartamento();

        proyecto.aprobar();

        assertInstanceOf(EtapaAprobadoConsejo.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.EVALUADOR_ACEPTA, getEstado(proyecto));
    }

    @Test
    void testAprobacionConsejo() {
        pasarAEtapaAprobadoConsejo();

        proyecto.presentar();

        assertInstanceOf(EtapaEnDesarrollo.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.EN_DESARROLLO, getEstado(proyecto));
    }

    @Test
    void testPresentarADecanatura() {
        pasarAEtapaEnDesarrollo();

        proyecto.presentar();

        assertInstanceOf(EtapaPresentadoDecanatura.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.FINALIZADO_MONOGRAFIA, getEstado(proyecto));
    }

    @Test
    void testSustentacionPublica() {
        pasarAEtapaFinalizadoMonografia();

        proyecto.presentar();

        assertInstanceOf(EtapaSustentacionPublica.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.FECHA_SUSTENTACION_FIJADA, getEstado(proyecto));
    }

    @Test
    void testAprobarEnSustentacionFinalizaProyecto() {
        pasarAEtapaFechaSustentacion();

        proyecto.aprobar();

        assertInstanceOf(EtapaFinalizado.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.PROYECTO_APROBADO, getEstado(proyecto));
    }

    @Test
    void testRechazarEnSustentacionFinalizaRechazado() {
        pasarAEtapaFechaSustentacion();

        proyecto.rechazar();

        assertInstanceOf(EtapaRechazado.class, proyecto.getEtapa());
        assertEquals(EstadoProyecto.PROYECTO_RECHAZADO, getEstado(proyecto));
    }

    // -------- Saltos rápidos --------

    private EstadoProyecto getEstado(ProyectoDeGrado proyecto) {
        try {
            var campo = ProyectoDeGrado.class.getDeclaredField("estado");
            campo.setAccessible(true);
            return (EstadoProyecto) campo.get(proyecto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void pasarAEtapaEscribiendoAnteproyecto() {
        proyecto.presentar();
        proyecto.aprobar();
    }

    private void pasarAEtapaEvaluacionDepartamento() {
        pasarAEtapaEscribiendoAnteproyecto();
        proyecto.presentar();
    }
    private void pasarAEtapaAprobadoConsejo() {
        pasarAEtapaEvaluacionDepartamento();
        proyecto.aprobar();
    }

    private void pasarAEtapaEnDesarrollo() {
        pasarAEtapaAprobadoConsejo();
        proyecto.presentar();
    }

    private void pasarAEtapaFinalizadoMonografia() {
        pasarAEtapaEnDesarrollo();
        proyecto.presentar();
    }

    private void pasarAEtapaFechaSustentacion() {
        pasarAEtapaFinalizadoMonografia();
        proyecto.presentar();
    }
}
