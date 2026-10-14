package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 2.1.5. */
class CasosEjercicioTest {

    @Test
    void elPeorCasoEsRecorrerloTodo() {
        for (int n : new int[] {1, 5, 100, 1000}) {
            assertEquals(n, CasosEjercicio.peorCaso(n), "peor caso con n = " + n);
        }
    }

    @Test
    void elMejorCasoEsUnaComparacion() {
        for (int n : new int[] {1, 5, 100, 1000}) {
            assertEquals(1, CasosEjercicio.mejorCaso(n), "mejor caso con n = " + n);
        }
    }

    /** El caso medio es (n+1)/2, no n/2: con n = 5 son 3,0 comparaciones y no 2,5. */
    @Test
    void elCasoMedioEsLaMediaDeLasNBusquedas() {
        for (int n : new int[] {1, 2, 5, 100, 1000}) {
            assertEquals((n + 1) / 2.0, CasosEjercicio.casoMedio(n), 1e-9, "caso medio con n = " + n);
        }
    }

    @Test
    void losTresResumenesSeOrdenanComoDebe() {
        int n = 50;
        assertEquals(1, CasosEjercicio.mejorCaso(n));
        assertEquals(n, CasosEjercicio.peorCaso(n));
        double medio = CasosEjercicio.casoMedio(n);
        assertTrue(medio > CasosEjercicio.mejorCaso(n) && medio < CasosEjercicio.peorCaso(n),
                "el caso medio tiene que quedar entre el mejor y el peor");
    }

    @Test
    void unTamanoInvalidoEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> CasosEjercicio.peorCaso(0));
        assertThrows(IllegalArgumentException.class, () -> CasosEjercicio.mejorCaso(0));
        assertThrows(IllegalArgumentException.class, () -> CasosEjercicio.casoMedio(0));
        assertThrows(IllegalArgumentException.class, () -> CasosEjercicio.peorCaso(-3));
    }
}
