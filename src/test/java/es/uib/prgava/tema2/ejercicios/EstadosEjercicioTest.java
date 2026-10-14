package es.uib.prgava.tema2.ejercicios;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import es.uib.prgava.tema1.monitor.Estado;
import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;
import es.uib.prgava.tema1.monitor.ServicioTcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Ejercicio 2.1.2. */
class EstadosEjercicioTest {

    private static final Servicio WEB = new ServicioTcp("web01", 80);
    private static final Instant I0 = Instant.parse("2026-01-01T00:00:00Z");

    private static Resultado con(Estado estado, int segundos) {
        return new Resultado(WEB, I0.plusSeconds(segundos), estado,
                estado == Estado.CAIDO ? Duration.ZERO : Duration.ofMillis(40));
    }

    @Test
    void clasificaCadaEstadoEnSuCasilla() {
        var historial = List.of(
                con(Estado.ACTIVO, 0),
                con(Estado.CAIDO, 60),
                con(Estado.CAIDO, 120),
                con(Estado.DEGRADADO, 180));
        assertArrayEquals(new long[] {1, 1, 2}, EstadosEjercicio.porEstado(historial));
    }

    @Test
    void unHistorialDeUnSoloEstado() {
        var historial = List.of(con(Estado.ACTIVO, 0), con(Estado.ACTIVO, 60), con(Estado.ACTIVO, 120));
        assertArrayEquals(new long[] {3, 0, 0}, EstadosEjercicio.porEstado(historial));
    }

    @Test
    void elHistorialVacioDaCerosYCeroOperaciones() {
        assertArrayEquals(new long[] {0, 0, 0}, EstadosEjercicio.porEstado(List.of()));
        assertEquals(0, EstadosEjercicio.ultimasOperaciones());
    }

    @Test
    void elArrayTieneUnaPosicionPorValorDelEnum() {
        assertEquals(Estado.values().length, EstadosEjercicio.porEstado(List.of(con(Estado.ACTIVO, 0))).length);
    }

    @Test
    void elRecuentoEsTresVecesElTamano() {
        for (int n : new int[] {1, 4, 100, 1000}) {
            var historial = new ArrayList<Resultado>();
            for (int i = 0; i < n; i++) {
                historial.add(con(Estado.values()[i % Estado.values().length], i));
            }
            EstadosEjercicio.porEstado(historial);
            assertEquals(3L * n, EstadosEjercicio.ultimasOperaciones(),
                    "con n = " + n + " el cuerpo interior debe ejecutarse 3n veces");
        }
    }
}
