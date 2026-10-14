package es.uib.prgava.tema2.monitor;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import es.uib.prgava.tema1.monitor.Estado;
import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;
import es.uib.prgava.tema1.monitor.ServicioTcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.1.9. */
class RepositorioContadorTest {

    private static final Servicio WEB = new ServicioTcp("web", 80);
    private static final Servicio DNS = new ServicioTcp("dns", 53);
    private static final Instant I0 = Instant.parse("2026-01-01T00:00:00Z");

    private static Resultado r(Servicio servicio, int segundos) {
        return new Resultado(servicio, I0.plusSeconds(segundos), Estado.ACTIVO, Duration.ofMillis(10));
    }

    @Test
    void sigueCumpliendoElContratoDelRepositorio() {
        var repo = new RepositorioContador();
        repo.guardar(r(WEB, 0));
        repo.guardar(r(DNS, 10));
        repo.guardar(r(WEB, 20));

        assertEquals(List.of(r(WEB, 0), r(WEB, 20)), repo.historial(WEB));
        assertEquals(List.of(r(DNS, 10)), repo.historial(DNS));
        assertEquals(Set.of(WEB, DNS), repo.servicios());
    }

    @Test
    void elHistorialDeUnServicioDesconocidoEstaVacio() {
        var repo = new RepositorioContador();
        repo.guardar(r(WEB, 0));
        assertEquals(List.of(), repo.historial(DNS));
    }

    @Test
    void cuentaUnaComparacionPorResultadoExaminado() {
        var repo = new RepositorioContador();
        repo.guardar(r(WEB, 0));
        repo.guardar(r(DNS, 10));
        repo.guardar(r(WEB, 20));
        assertEquals(0, repo.comparaciones(), "guardar no cuenta");

        repo.historial(WEB);
        assertEquals(3, repo.comparaciones());
        repo.historial(DNS);
        assertEquals(6, repo.comparaciones(), "el contador acumula entre llamadas");
        repo.servicios();
        assertEquals(6, repo.comparaciones(), "servicios no cuenta");
    }

    @Test
    void unaEjecucionCuestaLaSumaDeUnoHastaN() {
        assertEquals(21, RepositorioContador.comparacionesDeUnaEjecucion(2, 3));
        assertEquals(210, RepositorioContador.comparacionesDeUnaEjecucion(5, 4));
        assertEquals(1, RepositorioContador.comparacionesDeUnaEjecucion(1, 1));
    }

    /** Las dos primeras filas de la tabla de 2.1.6, con veinte servicios. */
    @Test
    void reproduceLaTablaDelTema() {
        assertEquals(2_001_000, RepositorioContador.comparacionesDeUnaEjecucion(100, 20));
        assertEquals(8_002_000, RepositorioContador.comparacionesDeUnaEjecucion(200, 20));
    }

    @Test
    void alDuplicarLasRondasElTrabajoSeMultiplicaPorCuatro() {
        long cien = RepositorioContador.comparacionesDeUnaEjecucion(100, 20);
        long doscientas = RepositorioContador.comparacionesDeUnaEjecucion(200, 20);
        assertEquals(4.0, (double) doscientas / cien, 0.01);
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        assertThrows(IllegalArgumentException.class,
                () -> RepositorioContador.comparacionesDeUnaEjecucion(0, 3));
        assertThrows(IllegalArgumentException.class,
                () -> RepositorioContador.comparacionesDeUnaEjecucion(3, 0));
    }
}
