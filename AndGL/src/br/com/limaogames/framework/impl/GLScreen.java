package br.com.limaogames.framework.impl;

import br.com.limaogames.framework.Screen;
import br.com.limaogames.framework.interfaces.Game;

/**
 * Classe abstrata para prover as funcionalidades das {@link Screen} utilizando a biblioteca openGL.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Screen
 */
public abstract class GLScreen extends Screen {
    protected final GLGraphics glGraphics;
    protected final GLGame glGame;
    
    /**
     * Construtor da classe.
     * 
     * @param game - Interface dos métodos principais para manter aplicativo rodando.
     */
    public GLScreen(Game game) {
        super(game);
        glGame = (GLGame)game;
        glGraphics = ((GLGame)game).getGLGraphics();
    }
    
    /**
     * Construtor da classe.
     * 
     * @param game - Interface dos métodos principais para manter aplicativo rodando.
     * @param screenId - Inteiro utilizado para caso desenvolvedor necessite ter um controle da tela que está sendo exibida ao usuário.
     */
    public GLScreen(Game game, int screenId) {
        super(game, screenId);
        glGame = (GLGame)game;
        glGraphics = ((GLGame)game).getGLGraphics();
    }

}
