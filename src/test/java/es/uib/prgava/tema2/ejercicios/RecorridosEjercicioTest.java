package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 2.1.1. */
class RecorridosEjercicioTest {

    @Test
    void elSegundoMayorCuentaLasRepeticiones() {
        assertArrayEquals(new int[] {17, 17}, RecorridosEjercicio.maximoYSegundo(new int[] {3, 17, 9, 17, 2}));
        assertArrayEquals(new int[] {5, 5}, RecorridosEjercicio.maximoYSegundo(new int[] {5, 5}));
    }

    @Test
    void daIgualDondeEsteElMaximo() {
        assertArrayEquals(new int[] {17, 9}, RecorridosEjercicio.maximoYSegundo(new int[] {3, 17, 9}));
        assertArrayEquals(new int[] {17, 9}, RecorridosEjercicio.maximoYSegundo(new int[] {17, 9, 3}));
        assertArrayEquals(new int[] {17, 9}, RecorridosEjercicio.maximoYSegundo(new int[] {3, 9, 17}));
        assertArrayEquals(new int[] {9, 3}, RecorridosEjercicio.maximoYSegundo(new int[] {3, 9}));
    }

    @Test
    void tambienConNegativos() {
        assertArrayEquals(new int[] {-3, -7}, RecorridosEjercicio.maximoYSegundo(new int[] {-7, -20, -3}));
    }

    @Test
    void unArrayCortoONuloEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> RecorridosEjercicio.maximoYSegundo(null));
        assertThrows(IllegalArgumentException.class, () -> RecorridosEjercicio.maximoYSegundo(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> RecorridosEjercicio.maximoYSegundo(new int[] {7}));
    }

    /** Esta es la que falla si recorres el array dos veces. */
    @Test
    void unSoloRecorrido() {
        for (int n : new int[] {2, 3, 10, 1000}) {
            int[] datos = new int[n];
            for (int i = 0; i < n; i++) {
                datos[i] = (i * 37) % n;
            }
            RecorridosEjercicio.maximoYSegundo(datos);
            assertEquals(n, RecorridosEjercicio.ultimasOperaciones(),
                    "con n = " + n + " el cuerpo del bucle debe ejecutarse n veces");
        }
    }
}
