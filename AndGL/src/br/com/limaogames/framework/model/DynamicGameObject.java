package br.com.limaogames.framework.model;

import br.com.limaogames.framework.math.Vector2;

/**
 * Classe para definir objetos que se movem no cenário.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see GameObject
 * @see Vector2
 */
public class DynamicGameObject extends GameObject {
    public final Vector2 velocity;
    public final Vector2 accel;
    
    /**
     * Construtor da classe.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @param width - Float largura do objeto.
     * @param height - Float altura do objeto.
     */
    public DynamicGameObject(float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
