package br.com.limaogames.framework.gl;

import javax.microedition.khronos.opengles.GL10;

import br.com.limaogames.framework.impl.GLGraphics;
import br.com.limaogames.framework.math.Vector2;

/**
 * Classe para prover o suporte a camera (área visível do jogo).
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Camera2D {
    public final Vector2 position;
    public float zoom;
    public final float frustumWidth;
    public final float frustumHeight;
    final GLGraphics glGraphics;
    
    /**
     * Construtor da classe.
     * 
     * @param glGraphics - Objeto da classe {@link GLGraphics}.
     * @param frustumWidth - Float com a largura da camera.
     * @param frustumHeight - Float com a altura da camera.
     */
    public Camera2D(GLGraphics glGraphics, float frustumWidth, float frustumHeight) {
        this.glGraphics = glGraphics;
        this.frustumWidth = frustumWidth;
        this.frustumHeight = frustumHeight;
        this.position = new Vector2(frustumWidth / 2, frustumHeight / 2);
        this.zoom = 1.0f;
    }
    
    /**
     * Construtor da classe.
     * 
     * @param glGraphics - Objeto da classe {@link GLGraphics}.
     * @param frustumWidth - Float com a largura da camera.
     * @param frustumHeight - Float com a altura da camera.
     * @param zoom - Float com o valor do zoom da camera.
     */
    public Camera2D(GLGraphics glGraphics, float frustumWidth, float frustumHeight, float zoom) {
        this.glGraphics = glGraphics;
        this.frustumWidth = frustumWidth;
        this.frustumHeight = frustumHeight;
        this.position = new Vector2(frustumWidth / 2, frustumHeight / 2);
        this.zoom = zoom;
    }
    
    /**
     * Método para gerar o campo de visão e matrizes para texturização dos gráficos.
     */
    public void setViewportAndMatrices() {
        GL10 gl = glGraphics.getGL();
        gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrthof(position.x - frustumWidth * zoom / 2, 
                    position.x + frustumWidth * zoom/ 2, 
                    position.y - frustumHeight * zoom / 2, 
                    position.y + frustumHeight * zoom/ 2, 
                    1, -1);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    
    /**
     * Método descobre o valor relativo do "toque do usuário" em relação ao mundo do jogo.
     * 
     * @param touch - Objeto de {@link Vector2} contendo as coordenadas x e y do toque do usuário.
     */
    public void touchToWorld(Vector2 touch) {
        touch.x = (touch.x / glGraphics.getWidth()) * frustumWidth * zoom;
        touch.y = (1 - touch.y / glGraphics.getHeight()) * frustumHeight * zoom;
        touch.add(position).sub(frustumWidth * zoom / 2, frustumHeight * zoom / 2);
    }
}
