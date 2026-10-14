package es.uib.prgava.tema2.ejercicios;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.1.4. */
class CruceEjercicioTest {

    private static final LongUnaryOperator LINEAL = n -> 100 * n;
    private static final LongUnaryOperator CUADRATICO = n -> n * n;

    @Test
    void elLinealGanaAlCuadraticoDesdeElSiguienteAlEmpate() {
        assertEquals(101, CruceEjercicio.primerNDondeGana(LINEAL, CUADRATICO, 100_000));
    }

    @Test
    void conLaConstanteMilElCruceSeMueveYElGanadorNo() {
        assertEquals(1001, CruceEjercicio.primerNDondeGana(n -> 1000 * n, CUADRATICO, 100_000));
    }

    @Test
    void elCuadraticoGanaDesdeElPrincipio() {
        assertEquals(1, CruceEjercicio.primerNDondeGana(CUADRATICO, LINEAL, 100_000));
        assertEquals(1, CruceEjercicio.primerNDondeGana(n -> n, n -> 2 * n, 100_000));
    }

    @Test
    void siNoGanaNuncaDevuelveMenosUno() {
        assertEquals(-1, CruceEjercicio.primerNDondeGana(n -> 2 * n, n -> n, 100_000));
        assertEquals(-1, CruceEjercicio.primerNDondeGana(n -> n, n -> n, 100_000));
    }

    @Test
    void elLimiteSeRespeta() {
        assertEquals(-1, CruceEjercicio.primerNDondeGana(LINEAL, CUADRATICO, 100));
        assertEquals(101, CruceEjercicio.primerNDondeGana(LINEAL, CUADRATICO, 101));
    }

    @Test
    void losArgumentosInvalidosSeRechazan() {
        assertThrows(IllegalArgumentException.class,
                () -> CruceEjercicio.primerNDondeGana(LINEAL, CUADRATICO, 0));
        assertThrows(IllegalArgumentException.class,
                () -> CruceEjercicio.primerNDondeGana(LINEAL, CUADRATICO, -5));
        assertThrows(IllegalArgumentException.class,
                () -> CruceEjercicio.primerNDondeGana(null, CUADRATICO, 10));
        assertThrows(IllegalArgumentException.class,
                () -> CruceEjercicio.primerNDondeGana(LINEAL, null, 10));
    }
}
