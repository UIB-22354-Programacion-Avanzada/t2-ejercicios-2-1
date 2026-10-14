package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.1.7. Búsqueda binaria con el contrato de la biblioteca.
 *
 * <p>La {@code binaria} del tema devuelve −1 cuando el elemento no está. Aquí se escribe la
 * versión de {@code java.util.Arrays.binarySearch}, que en ese caso devuelve el punto de inserción
 * codificado y es bastante más útil.
 */
public final class BusquedasEjercicio {

    private BusquedasEjercicio() { }

    /**
     * Posición de {@code buscado} en {@code datos}, o el punto de inserción codificado.
     *
     * <p>Si el elemento está, devuelve su posición. Si no está, devuelve
     * −(punto de inserción) − 1, donde el punto de inserción es el índice en el que habría que
     * insertarlo para mantener el orden. <strong>Con esta codificación, −1 significa «no está, y
     * va en la posición 0»</strong>, y ya no significa «no está» sin más.
     *
     * @param datos array <strong>ordenado</strong> de forma creciente; el método no lo comprueba,
     *        y con un array desordenado devuelve cualquier cosa sin avisar
     */
    public static int binariaConInsercion(int[] datos, int buscado) {
        // TODO 2.1.7: el esquema de la binaria del tema, con el punto medio calculado como
        // izquierda + (derecha - izquierda) / 2, y el valor de retorno de la biblioteca cuando el
        // bucle termina sin encontrar nada.
        throw new UnsupportedOperationException("TODO 2.1.7: BusquedasEjercicio.binariaConInsercion");
    }
}
