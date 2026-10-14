package es.uib.prgava.tema2.ejercicios;

/**
 * Ejercicio 2.1.3. Los testigos de una cota para f(n) = 3n² + 50n + 200.
 *
 * <p>Una cota asintótica no es una impresión: es una afirmación con testigos. Para la cota
 * superior hay que exhibir {@code c} y {@code n0} con f(n) ≤ c·n² para todo n ≥ n0, y para la
 * inferior, {@code c} y {@code n0} con f(n) ≥ c·n². Lo que se entrega aquí son esos cuatro
 * números, y las pruebas comprueban que cumplen la definición.
 */
public final class CotasEjercicio {

    private CotasEjercicio() { }

    /**
     * La función del enunciado, f(n) = 3n² + 50n + 200.
     *
     * @param n tamaño de la entrada, no negativo
     */
    public static long f(long n) {
        // TODO 2.1.3
        throw new UnsupportedOperationException("TODO 2.1.3: CotasEjercicio.f");
    }

    /** La constante c de la cota superior: f(n) ≤ c·n² para todo n ≥ n0Superior(). */
    public static long constanteCSuperior() {
        // TODO 2.1.3
        throw new UnsupportedOperationException("TODO 2.1.3: CotasEjercicio.constanteCSuperior");
    }

    /** El n0 mínimo para la c que has elegido en {@link #constanteCSuperior()}. */
    public static long n0Superior() {
        // TODO 2.1.3
        throw new UnsupportedOperationException("TODO 2.1.3: CotasEjercicio.n0Superior");
    }

    /** La constante c de la cota inferior: f(n) ≥ c·n² para todo n ≥ n0Inferior(). */
    public static long constanteCInferior() {
        // TODO 2.1.3
        throw new UnsupportedOperationException("TODO 2.1.3: CotasEjercicio.constanteCInferior");
    }

    /** El n0 de la cota inferior. */
    public static long n0Inferior() {
        // TODO 2.1.3
        throw new UnsupportedOperationException("TODO 2.1.3: CotasEjercicio.n0Inferior");
    }

    // TODO 2.1.3: escribe aqui, en comentario, que se puede afirmar sobre f a la vista de las dos
    // cotas, con el nombre de la cota que corresponda, y por que no hacia falta buscar c1 y c2 a
    // la vez.
}
