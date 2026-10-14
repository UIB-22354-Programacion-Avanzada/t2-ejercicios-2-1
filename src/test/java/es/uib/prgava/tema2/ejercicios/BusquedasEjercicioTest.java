package es.uib.prgava.tema2.ejercicios;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Ejercicio 2.1.7. */
class BusquedasEjercicioTest {

    private static final int[] PUERTOS = {22, 53, 80, 443, 8080};

    @Test
    void cuandoElElementoEstaDevuelveSuPosicion() {
        assertEquals(0, BusquedasEjercicio.binariaConInsercion(PUERTOS, 22));
        assertEquals(3, BusquedasEjercicio.binariaConInsercion(PUERTOS, 443));
        assertEquals(4, BusquedasEjercicio.binariaConInsercion(PUERTOS, 8080));
    }

    @Test
    void cuandoNoEstaDevuelveElPuntoDeInsercionCodificado() {
        assertEquals(-5, BusquedasEjercicio.binariaConInsercion(PUERTOS, 1024));
        assertEquals(-4, BusquedasEjercicio.binariaConInsercion(PUERTOS, 100));
        assertEquals(-1, BusquedasEjercicio.binariaConInsercion(PUERTOS, 10));
        assertEquals(-6, BusquedasEjercicio.binariaConInsercion(PUERTOS, 99_999));
    }

    @Test
    void losCasosDegenerados() {
        assertEquals(-1, BusquedasEjercicio.binariaConInsercion(new int[] {}, 7));
        assertEquals(0, BusquedasEjercicio.binariaConInsercion(new int[] {7}, 7));
        assertEquals(-1, BusquedasEjercicio.binariaConInsercion(new int[] {7}, 3));
        assertEquals(-2, BusquedasEjercicio.binariaConInsercion(new int[] {7}, 9));
    }

    /** La prueba que de verdad decide: la biblioteca como oráculo, veinte mil veces. */
    @Test
    void coincideConArraysBinarySearch() {
        var azar = new Random(42);
        for (int caso = 0; caso < 20_000; caso++) {
            int[] datos = new int[azar.nextInt(12)];
            for (int i = 0; i < datos.length; i++) {
                datos[i] = azar.nextInt(30);
            }
            Arrays.sort(datos);
            int buscado = azar.nextInt(32) - 1;
            assertEquals(Arrays.binarySearch(datos, buscado),
                    BusquedasEjercicio.binariaConInsercion(datos, buscado),
                    "buscando " + buscado + " en " + Arrays.toString(datos));
        }
    }
}
