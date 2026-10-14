package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.1.1. El mayor y el segundo mayor de un array, en un solo recorrido.
 *
 * <p>El modelo es {@code Conteos} del tema: el método devuelve su resultado, anuncia el recuento
 * con {@code Recuento} y —esto es propio de los ejercicios, porque las pruebas tienen que leer el
 * número— lo deja accesible en {@link #ultimasOperaciones()}.
 *
 * <p>Lo que se cuenta son <strong>iteraciones del cuerpo</strong> del bucle, no operaciones
 * elementales.
 */
public final class RecorridosEjercicio {

    private RecorridosEjercicio() { }

    // TODO 2.1.1: declara aquí el atributo de clase donde se guarda el último recuento.

    /**
     * El mayor y el segundo mayor elemento de {@code datos}, en ese orden.
     *
     * <p>El segundo mayor cuenta las repeticiones: en {@code {3, 17, 9, 17, 2}} el mayor es 17 y
     * el segundo mayor también.
     *
     * @param datos array de al menos dos elementos
     * @return un array de dos posiciones, {@code {maximo, segundo}}
     * @throws IllegalArgumentException si {@code datos} es {@code null} o tiene menos de dos
     *         elementos
     */
    public static int[] maximoYSegundo(int[] datos) {
        // TODO 2.1.1: valida, recorre una sola vez llevando maximo y segundo, cuenta las
        // iteraciones, anuncialas con Recuento.anunciar("maximoYSegundo", n, operaciones, "n")
        // y guardalas antes de devolver el resultado.
        throw new UnsupportedOperationException("TODO 2.1.1: RecorridosEjercicio.maximoYSegundo");
    }

    /** Iteraciones que ejecutó la última llamada a {@link #maximoYSegundo(int[])}. */
    public static long ultimasOperaciones() {
        // TODO 2.1.1
        throw new UnsupportedOperationException("TODO 2.1.1: RecorridosEjercicio.ultimasOperaciones");
    }
}
