package br.com.limaogames.framework.gl;

/**
 * Classe para armazenar região dentro de um objeto {@link Texture}.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class TextureRegion {    
    public final float u1, v1;
    public final float u2, v2;
    public final Texture texture;
    
    /**
     * Construtor da classe.
     * 
     * @param texture - Objeto de {@link Texture}.
     * @param x - Float da coordenada "x" da região a ser armazenada.
     * @param y - Float da coordenada "y" da região a ser armazenada.
     * @param width - Float da largura da região a ser armazenada.
     * @param height - Float da altura da região a ser armazenada.
     */
    public TextureRegion(Texture texture, float x, float y, float width, float height) {
        this.u1 = x / texture.width;
        this.v1 = y / texture.height;
        this.u2 = this.u1 + width / texture.width;
        this.v2 = this.v1 + height / texture.height;        
        this.texture = texture;
    }
}
