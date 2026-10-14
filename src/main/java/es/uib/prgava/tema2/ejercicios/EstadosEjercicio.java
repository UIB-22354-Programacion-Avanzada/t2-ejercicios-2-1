package es.uib.prgava.tema2.ejercicios;

import java.util.List;

import es.uib.prgava.tema1.monitor.Resultado;

/**
 * Ejercicio 2.1.2. Cuántos resultados hay de cada {@code Estado}, con dos bucles anidados que no
 * son cuadráticos.
 *
 * <p>El bucle interior recorre los valores del enum, que son una constante del programa y no el
 * tamaño de la entrada: de ahí que el recuento sea {@code 3n} y la clase de crecimiento, lineal.
 */
public final class EstadosEjercicio {

    private EstadosEjercicio() { }

    // TODO 2.1.2: declara aquí el atributo de clase donde se guarda el último recuento.

    /**
     * Cuántos resultados hay de cada estado, en un array indexado por {@code Estado.ordinal()}.
     *
     * @param historial resultados que hay que clasificar; puede estar vacío
     * @return un array de {@code Estado.values().length} posiciones
     */
    public static long[] porEstado(List<Resultado> historial) {
        // TODO 2.1.2: dos bucles anidados, el exterior sobre el historial y el interior sobre
        // Estado.values(), sin break. Cuenta las iteraciones del cuerpo interior, anuncialas con
        // Recuento.anunciar("porEstado", historial.size(), operaciones, "3n") y guardalas.
        throw new UnsupportedOperationException("TODO 2.1.2: EstadosEjercicio.porEstado");
    }

    /** Iteraciones que ejecutó la última llamada a {@link #porEstado(List)}. */
    public static long ultimasOperaciones() {
        // TODO 2.1.2
        throw new UnsupportedOperationException("TODO 2.1.2: EstadosEjercicio.ultimasOperaciones");
    }

    // TODO 2.1.2: escribe aquí, en dos lineas de comentario, a que clase de crecimiento pertenece
    // porEstado y por que, usando la formula del recuento como argumento.
}
