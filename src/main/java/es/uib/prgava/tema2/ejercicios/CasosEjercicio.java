package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.1.5. Peor caso, mejor caso y caso medio de la búsqueda lineal, medidos.
 *
 * <p>Los tres casos son tres resúmenes distintos del conjunto de costes de las entradas de un
 * tamaño dado, y aquí se calculan recorriendo las entradas de verdad en lugar de citar la fórmula.
 * La hipótesis del caso medio —el elemento está y todas las posiciones son igual de probables— es
 * parte del resultado, y se traduce en promediar las n búsquedas posibles.
 *
 * <p>Para un tamaño n se usa siempre el array {0, 1, 2, …, n−1}, donde el elemento de valor i está
 * en la posición i.
 */
public final class CasosEjercicio {

    private CasosEjercicio() { }

    /**
     * Comparaciones que hace una búsqueda lineal de {@code buscado} en {@code datos}.
     *
     * <p>A diferencia de {@code Busquedas.lineal}, que imprime su recuento, este método lo
     * devuelve: es lo que permite que los tres resúmenes se calculen con él.
     *
     * @return cuántas comparaciones se han hecho hasta encontrar el elemento o agotar el array
     */
    private static long comparaciones(int[] datos, int buscado) {
        // TODO 2.1.5
        throw new UnsupportedOperationException("TODO 2.1.5: CasosEjercicio.comparaciones");
    }

    /** El array {0, 1, …, n−1}. */
    private static int[] crecientes(int n) {
        // TODO 2.1.5
        throw new UnsupportedOperationException("TODO 2.1.5: CasosEjercicio.crecientes");
    }

    /**
     * El máximo de los costes: buscar un elemento que no está.
     *
     * @throws IllegalArgumentException si {@code n} es menor que 1
     */
    public static long peorCaso(int n) {
        // TODO 2.1.5
        throw new UnsupportedOperationException("TODO 2.1.5: CasosEjercicio.peorCaso");
    }

    /**
     * El mínimo de los costes: buscar el elemento de la primera posición.
     *
     * @throws IllegalArgumentException si {@code n} es menor que 1
     */
    public static long mejorCaso(int n) {
        // TODO 2.1.5
        throw new UnsupportedOperationException("TODO 2.1.5: CasosEjercicio.mejorCaso");
    }

    /**
     * La media de los costes de buscar cada uno de los n elementos presentes.
     *
     * @throws IllegalArgumentException si {@code n} es menor que 1
     */
    public static double casoMedio(int n) {
        // TODO 2.1.5
        throw new UnsupportedOperationException("TODO 2.1.5: CasosEjercicio.casoMedio");
    }
}
