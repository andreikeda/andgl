package br.com.limaogames.framework.impl;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

/**
 * Classe para prover a funcionalidade para manipulação de imagens utilizando a biblioteca openGL.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class GLGraphics {
    GLSurfaceView glView;
    GL10 gl;
    
    /**
     * Construtor da classe.
     * 
     * @param glView - Objeto de {@link GLSurfaceView}.
     */
    public GLGraphics(GLSurfaceView glView) {
        this.glView = glView;
    }
    
    /**
     * Retorna objeto de {@link GL10}.
     * 
     * @return Objeto de {@link GL10}.
     */
    public GL10 getGL() {
        return gl;
    }
    
    /**
     * Atribui parâmetro ao objeto {@link GL10}.
     * 
     * @param gl - Objeto de {@link GL10}.
     */
    public void setGL(GL10 gl) {
        this.gl = gl;
    }
    
    /**
     * Retorna largura de objeto de {@link GLSurfaceView}.
     * 
     * @return Largura do objeto de {@link GLSurfaceView}.
     */
    public int getWidth() {
        return glView.getWidth();
    }
    
    /**
     * Retorna altura de objeto de {@link GLSurfaceView}.
     * 
     * @return Altura do objeto de {@link GLSurfaceView}.
     */
    public int getHeight() {
        return glView.getHeight();
    }
}
