package br.com.limaogames.framework.math;

/**
 * Classe para criação de elementos circulares.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Vector2
 */
public class Circle {
    public final Vector2 center = new Vector2();
    public float radius;

    /**
     * Construtor da classe.
     * 
     * @param x - Float coordenada x do centro do objeto.
     * @param y - Float coordenada y do centro do objeto.
     * @param radius - Float raio do objeto.
     */
    public Circle(float x, float y, float radius) {
        this.center.set(x,y);
        this.radius = radius;
    }
}
