package br.com.limaogames.framework.math;

/**
 * Classe para criação de elementos retangulares.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Vector2
 */
public class Rectangle {
    public final Vector2 lowerLeft;
    public float width, height;
    
    /**
     * Construtor da classe.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @param width - Float largura do elemento.
     * @param height - Float altura do elemento.
     */
    public Rectangle(float x, float y, float width, float height) {
        this.lowerLeft = new Vector2(x,y);
        this.width = width;
        this.height = height;
    }
}
