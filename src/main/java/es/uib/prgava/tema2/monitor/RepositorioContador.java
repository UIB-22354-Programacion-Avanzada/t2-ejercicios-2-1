package es.uib.prgava.tema2.monitor;

import java.util.List;
import java.util.Set;

import es.uib.prgava.tema1.monitor.RepositorioResultados;
import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;

/**
 * Ejercicio 2.1.9. El repositorio del Tema 1, contando las comparaciones de {@code historial}.
 *
 * <p>Hace exactamente lo mismo que {@code RepositorioEnMemoria}: guarda los resultados en una
 * lista y, para responder el historial de un servicio, recorre todos los resultados comparando el
 * servicio de cada uno. Lo único que añade es el recuento, y con él se reproduce la columna de
 * comparaciones de la tabla de 2.1.6 sin depender de la máquina.
 */
public final class RepositorioContador implements RepositorioResultados {

    // TODO 2.1.9: declara aqui la lista de resultados y el contador de comparaciones.

    @Override
    public void guardar(Resultado resultado) {
        // TODO 2.1.9: no cuenta nada.
        throw new UnsupportedOperationException("TODO 2.1.9: RepositorioContador.guardar");
    }

    /**
     * Historial de un servicio, del más antiguo al más reciente.
     *
     * <p>Suma al contador una comparación por cada resultado examinado, es decir una por cada
     * vuelta del bucle, acumuladas entre llamadas.
     */
    @Override
    public List<Resultado> historial(Servicio servicio) {
        // TODO 2.1.9
        throw new UnsupportedOperationException("TODO 2.1.9: RepositorioContador.historial");
    }

    @Override
    public Set<Servicio> servicios() {
        // TODO 2.1.9: no cuenta nada.
        throw new UnsupportedOperationException("TODO 2.1.9: RepositorioContador.servicios");
    }

    /** Comparaciones acumuladas por todas las llamadas a {@link #historial(Servicio)}. */
    public long comparaciones() {
        // TODO 2.1.9
        throw new UnsupportedOperationException("TODO 2.1.9: RepositorioContador.comparaciones");
    }

    /**
     * Reproduce una ejecución del monitor y devuelve las comparaciones que ha costado.
     *
     * <p>En cada ronda, y para cada servicio, se guarda un resultado y después se consulta su
     * historial, que es el orden del bucle de {@code Monitor.comprobar}. No hacen falta ni la
     * sonda ni la política: lo que se mide es el repositorio.
     *
     * @param rondas número de rondas, al menos 1
     * @param servicios número de servicios distintos, al menos 1
     * @throws IllegalArgumentException si alguno es menor que 1
     */
    public static long comparacionesDeUnaEjecucion(int rondas, int servicios) {
        // TODO 2.1.9: crea un RepositorioContador, construye los servicios —te sirve
        // new ServicioTcp("s" + i, 9000 + i)— y haz las rondas.
        throw new UnsupportedOperationException("TODO 2.1.9: RepositorioContador.comparacionesDeUnaEjecucion");
    }

    // TODO 2.1.9: escribe aqui, en comentario, la forma cerrada de 1 + 2 + ... + N, con
    // N = rondas * servicios, y de donde sale el O(r^2 s^2) del tema.
}
