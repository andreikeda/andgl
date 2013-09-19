package br.com.limaogames.framework.model;

import br.com.limaogames.framework.math.Rectangle;
import br.com.limaogames.framework.math.Vector2;

/**
 * Classe para definir objetos iterativos.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Vector2
 * @see Rectangle
 */
public class GameObject {
    public final Vector2 position;
    public final Rectangle bounds;
    
    /**
     * Construtor da classe.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @param width - Float largura do objeto.
     * @param height - Float altura do objeto.
     */
    public GameObject(float x, float y, float width, float height) {
        this.position = new Vector2(x,y);
        this.bounds = new Rectangle(x-width/2, y-height/2, width, height);
    }
}
