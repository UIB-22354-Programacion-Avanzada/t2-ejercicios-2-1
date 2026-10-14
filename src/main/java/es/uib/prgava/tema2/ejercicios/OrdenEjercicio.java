package es.uib.prgava.tema2.ejercicios;

import java.util.List;

import es.uib.prgava.tema1.monitor.Resultado;

/**
 * Ejercicio 2.1.8. Agrupar los resultados por servicio sin perder el orden cronológico.
 *
 * <p>Los dos métodos tienen que devolver exactamente la misma lista: uno ordenando dos veces por
 * un criterio y el otro una sola vez por un criterio compuesto. Que coincidan es consecuencia de
 * que la ordenación de objetos en Java es estable.
 */
public final class OrdenEjercicio {

    private OrdenEjercicio() { }

    /**
     * Ordenado por servicio y, dentro de cada servicio, de más antiguo a más reciente, con dos
     * ordenaciones de un solo criterio.
     *
     * @param resultados no se modifica
     * @return una lista nueva e inmutable
     */
    public static List<Resultado> conDosPasadas(List<Resultado> resultados) {
        // TODO 2.1.8: copia la lista, ordena primero por instante y despues por nombre del
        // servicio, y devuelve la copia como lista inmutable. El orden de las dos pasadas es el
        // que hace que funcione.
        throw new UnsupportedOperationException("TODO 2.1.8: OrdenEjercicio.conDosPasadas");
    }

    /**
     * El mismo resultado que {@link #conDosPasadas(List)} con un único {@code sort}.
     *
     * @param resultados no se modifica
     * @return una lista nueva e inmutable
     */
    public static List<Resultado> conUnComparador(List<Resultado> resultados) {
        // TODO 2.1.8: un solo sort, componiendo con Comparator.comparing y thenComparing. El
        // servicio se compara por su nombre().
        throw new UnsupportedOperationException("TODO 2.1.8: OrdenEjercicio.conUnComparador");
    }

    // TODO 2.1.8: escribe aqui, en comentario, que propiedad de la ordenacion de Java hace que los
    // dos metodos devuelvan la misma lista, y que pasaria si no la tuviera.
}
