package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ejercicio 2.1.3.
 *
 * <p>Estas pruebas no comprueban que hayas dado unos números concretos, sino que los tuyos
 * cumplen la definición.
 */
class CotasEjercicioTest {

    private static final long HASTA = 100_000L;

    @Test
    void laFuncionEsLaDelEnunciado() {
        assertEquals(200, CotasEjercicio.f(0));
        assertEquals(253, CotasEjercicio.f(1));
        assertEquals(11_277, CotasEjercicio.f(53));
        assertEquals(11_648, CotasEjercicio.f(54));
        assertEquals(30_005_000_200L, CotasEjercicio.f(100_000));
    }

    @Test
    void laCotaSuperiorSeCumpleConTusTestigos() {
        long c = CotasEjercicio.constanteCSuperior();
        long n0 = CotasEjercicio.n0Superior();
        assertTrue(c > 0, "la constante c tiene que ser positiva");
        assertTrue(n0 >= 0, "n0 no puede ser negativo");
        for (long n = n0; n <= HASTA; n++) {
            assertTrue(CotasEjercicio.f(n) <= c * n * n,
                    "con c = " + c + " falla en n = " + n + ": f(n) = " + CotasEjercicio.f(n)
                            + " y c*n^2 = " + c * n * n);
        }
    }

    @Test
    void tuN0EsElMinimoParaTuC() {
        long c = CotasEjercicio.constanteCSuperior();
        long n0 = CotasEjercicio.n0Superior();
        assertTrue(n0 >= 1, "con esta función ningún n0 válido puede ser 0");
        long anterior = n0 - 1;
        assertTrue(CotasEjercicio.f(anterior) > c * anterior * anterior,
                "si la desigualdad ya se cumple en " + anterior + ", tu n0 no es el mínimo para c = " + c);
    }

    @Test
    void laCotaInferiorSeCumpleConTusTestigos() {
        long c = CotasEjercicio.constanteCInferior();
        long n0 = CotasEjercicio.n0Inferior();
        assertTrue(c > 0, "la constante c tiene que ser positiva");
        assertTrue(n0 >= 0, "n0 no puede ser negativo");
        for (long n = n0; n <= HASTA; n++) {
            assertTrue(CotasEjercicio.f(n) >= c * n * n,
                    "con c = " + c + " falla en n = " + n + ": f(n) = " + CotasEjercicio.f(n)
                            + " y c*n^2 = " + c * n * n);
        }
    }
}
