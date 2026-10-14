package es.uib.prgava.tema2.ejercicios;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.uib.prgava.tema1.monitor.Estado;
import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;
import es.uib.prgava.tema1.monitor.ServicioTcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.1.8. */
class OrdenEjercicioTest {

    private static final Servicio WEB = new ServicioTcp("web", 80);
    private static final Servicio DNS = new ServicioTcp("dns", 53);
    private static final Servicio TCP = new ServicioTcp("tcp", 22);
    private static final Instant I0 = Instant.ofEpochSecond(0);

    private static Resultado r(Servicio servicio, int segundos) {
        return new Resultado(servicio, I0.plusSeconds(segundos), Estado.ACTIVO, Duration.ZERO);
    }

    private static String etiquetas(List<Resultado> lista) {
        var sb = new StringBuilder();
        for (var resultado : lista) {
            sb.append(resultado.servicio().nombre()).append('@').append(resultado.instante().getEpochSecond()).append(' ');
        }
        return sb.toString().strip();
    }

    private static final List<Resultado> ENTRADA = List.of(
            r(WEB, 30), r(DNS, 10), r(WEB, 10), r(TCP, 20), r(DNS, 30), r(WEB, 20));

    private static final String ESPERADO = "dns:53@10 dns:53@30 tcp:22@20 web:80@10 web:80@20 web:80@30";

    @Test
    void dosPasadasAgrupanPorServicioYConservanElOrdenCronologico() {
        assertEquals(ESPERADO, etiquetas(OrdenEjercicio.conDosPasadas(ENTRADA)));
    }

    @Test
    void elComparadorCompuestoDaLoMismo() {
        assertEquals(ESPERADO, etiquetas(OrdenEjercicio.conUnComparador(ENTRADA)));
    }

    @Test
    void conInstantesRepetidos() {
        var entrada = List.of(r(WEB, 10), r(DNS, 10), r(WEB, 10), r(DNS, 5));
        assertEquals("dns:53@5 dns:53@10 web:80@10 web:80@10", etiquetas(OrdenEjercicio.conDosPasadas(entrada)));
        assertEquals(OrdenEjercicio.conDosPasadas(entrada), OrdenEjercicio.conUnComparador(entrada));
    }

    @Test
    void laEntradaNoSeModificaYLaSalidaEsInmutable() {
        var entrada = new ArrayList<>(ENTRADA);
        var copiaDeLaEntrada = List.copyOf(entrada);
        var salida = OrdenEjercicio.conDosPasadas(entrada);
        assertEquals(copiaDeLaEntrada, entrada, "la lista que llega no se toca");
        assertThrows(UnsupportedOperationException.class, () -> salida.add(r(WEB, 99)));
    }

    @Test
    void losDosMetodosCoincidenSobreListasAlAzar() {
        var azar = new Random(7);
        var servicios = List.of(WEB, DNS, TCP);
        for (int caso = 0; caso < 200; caso++) {
            var entrada = new ArrayList<Resultado>();
            int n = azar.nextInt(30);
            for (int i = 0; i < n; i++) {
                entrada.add(r(servicios.get(azar.nextInt(servicios.size())), azar.nextInt(10)));
            }
            assertEquals(OrdenEjercicio.conDosPasadas(entrada), OrdenEjercicio.conUnComparador(entrada));
        }
    }

    @Test
    void laListaVacia() {
        assertEquals(List.of(), OrdenEjercicio.conDosPasadas(List.of()));
        assertEquals(List.of(), OrdenEjercicio.conUnComparador(List.of()));
    }
}
