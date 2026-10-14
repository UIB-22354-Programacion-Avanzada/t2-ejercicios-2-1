package es.uib.prgava.tema2.ejercicios;

import java.util.function.LongUnaryOperator;

/**
 * Ejercicio 2.1.4. El punto de cruce de dos funciones de coste.
 *
 * <p>Decir que un algoritmo es más rápido que otro sin decir para qué tamaño es una frase
 * incompleta. Este método contesta la pregunta que sí tiene respuesta: a partir de qué tamaño uno
 * hace menos trabajo que el otro.
 */
public final class CruceEjercicio {

    private CruceEjercicio() { }

    /**
     * El menor n ≥ 1 para el que {@code coste1(n) < coste2(n)}.
     *
     * @param coste1 función de coste del primer algoritmo
     * @param coste2 función de coste del segundo
     * @param limite último tamaño que se examina, incluido
     * @return el primer n donde gana {@code coste1}, o −1 si no gana en ningún n ≤ {@code limite}
     * @throws IllegalArgumentException si {@code limite} es menor que 1 o si alguna función es
     *         {@code null}
     */
    public static int primerNDondeGana(LongUnaryOperator coste1, LongUnaryOperator coste2, int limite) {
        // TODO 2.1.4: valida los argumentos y recorre n de 1 a limite devolviendo el primero que
        // cumpla la desigualdad estricta. Este metodo no lleva contador.
        throw new UnsupportedOperationException("TODO 2.1.4: CruceEjercicio.primerNDondeGana");
    }
}
