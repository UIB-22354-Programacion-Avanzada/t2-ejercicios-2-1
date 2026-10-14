package es.uib.prgava.tema2.ejercicios;

import java.util.function.IntUnaryOperator;

/**
 * Ejercicio 2.1.6. Un almacén de {@code int} que crece solo, contando las copias.
 *
 * <p>Es lo que hace {@code ArrayList} por dentro, y el objeto del ejercicio es la cuenta: con una
 * estrategia que <strong>multiplica</strong> la capacidad, las copias totales son menos de dos por
 * elemento añadido —de ahí el coste amortizado constante—; con una estrategia que suma una
 * cantidad fija, crecen con el cuadrado del número de elementos.
 *
 * <p>La estrategia entra por el constructor, de modo que las dos políticas se comparan sin
 * escribir la clase dos veces.
 */
public final class ArrayCreciente {

    // TODO 2.1.6: declara aqui el array, cuantos elementos hay de verdad, la estrategia y el
    // contador de copias.

    /**
     * @param capacidadInicial longitud del array con el que se empieza, al menos 1
     * @param crecimiento recibe la capacidad actual y devuelve la nueva; por ejemplo
     *        {@code c -> 2 * c} o {@code c -> c + 10}
     * @throws IllegalArgumentException si {@code capacidadInicial} es menor que 1
     * @throws NullPointerException si {@code crecimiento} es {@code null}
     */
    public ArrayCreciente(int capacidadInicial, IntUnaryOperator crecimiento) {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: constructor de ArrayCreciente");
    }

    /**
     * Añade un valor al final, haciendo crecer el array si está lleno.
     *
     * <p>Cuando toca crecer, al contador de copias se le suma el número de elementos copiados,
     * que es el tamaño actual y no la capacidad.
     *
     * @throws IllegalStateException si la estrategia de crecimiento no aumenta la capacidad
     */
    public void anadir(int valor) {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: ArrayCreciente.anadir");
    }

    /**
     * El valor de una posición escrita.
     *
     * @throws IndexOutOfBoundsException si {@code posicion} no está entre 0 y {@code tamano() - 1}
     */
    public int get(int posicion) {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: ArrayCreciente.get");
    }

    /** Cuántos elementos se han añadido. */
    public int tamano() {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: ArrayCreciente.tamano");
    }

    /** Longitud del array interno, que es otra cosa que el tamaño. */
    public int capacidad() {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: ArrayCreciente.capacidad");
    }

    /** Elementos copiados en total desde que se creó el almacén. */
    public long copiasRealizadas() {
        // TODO 2.1.6
        throw new UnsupportedOperationException("TODO 2.1.6: ArrayCreciente.copiasRealizadas");
    }
}
