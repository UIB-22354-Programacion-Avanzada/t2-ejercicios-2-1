package es.uib.prgava.tema2.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 2.1.6. */
class ArrayCrecienteTest {

    private static ArrayCreciente conN(int n, int capacidadInicial, java.util.function.IntUnaryOperator crecimiento) {
        var almacen = new ArrayCreciente(capacidadInicial, crecimiento);
        for (int i = 0; i < n; i++) {
            almacen.anadir(i);
        }
        return almacen;
    }

    @Test
    void losElementosSeRecuperanEnOrdenDespuesDeCrecer() {
        var almacen = conN(1000, 1, c -> 2 * c);
        assertEquals(1000, almacen.tamano());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, almacen.get(i));
        }
    }

    @Test
    void laCapacidadCreceSegunLaEstrategia() {
        var almacen = conN(1000, 1, c -> 2 * c);
        assertEquals(1024, almacen.capacidad());
        assertEquals(1000, almacen.tamano());
    }

    @Test
    void getValidaContraElTamanoYNoContraLaCapacidad() {
        var almacen = conN(3, 16, c -> 2 * c);
        assertEquals(16, almacen.capacidad());
        assertEquals(3, almacen.tamano());
        assertThrows(IndexOutOfBoundsException.class, () -> almacen.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> almacen.get(-1));
    }

    /** Duplicando, el total copiado es menos de dos por elemento: de ahí el coste amortizado. */
    @Test
    void duplicandoLasCopiasSonMenosDeDosPorElemento() {
        for (int n : new int[] {10, 100, 1000, 100_000}) {
            long copias = conN(n, 1, c -> 2 * c).copiasRealizadas();
            assertTrue(copias < 2L * n,
                    "con n = " + n + " duplicando se han copiado " + copias + " elementos, y deberian ser menos de " + 2L * n);
        }
    }

    /** Creciendo de diez en diez, el total copiado es del orden de n², y se nota. */
    @Test
    void creciendoDeDiezEnDiezLasCopiasSonCuadraticas() {
        for (int n : new int[] {1000, 100_000}) {
            long copias = conN(n, 10, c -> c + 10).copiasRealizadas();
            assertTrue(copias > (long) n * n / 25,
                    "con n = " + n + " creciendo de diez en diez se han copiado " + copias
                            + " elementos, y deberian ser mas de " + (long) n * n / 25);
        }
    }

    @Test
    void sinCrecimientosNoSeCopiaNada() {
        assertEquals(0, conN(10, 16, c -> 2 * c).copiasRealizadas());
    }

    @Test
    void unaEstrategiaQueNoCreceSeRechazaCuandoTocaCrecer() {
        var almacen = new ArrayCreciente(2, c -> c);
        almacen.anadir(1);
        almacen.anadir(2);
        assertThrows(IllegalStateException.class, () -> almacen.anadir(3));
    }

    @Test
    void losArgumentosInvalidosDelConstructorSeRechazan() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayCreciente(0, c -> 2 * c));
        assertThrows(IllegalArgumentException.class, () -> new ArrayCreciente(-4, c -> 2 * c));
        assertThrows(NullPointerException.class, () -> new ArrayCreciente(4, null));
    }
}
