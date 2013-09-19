package br.com.limaogames.framework;

import br.com.limaogames.framework.interfaces.Game;

/**
 * Classe abstrata para as telas do aplicativo.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Game
 */
public abstract class Screen {
    protected final Game game;
    public int screenId;

    /**
     * Construtor da classe.
     * 
     * @param game - Interface com os métodos principais do fluxo do jogo. 
     */
    public Screen(Game game) {
        this.game = game;
    }

    /**
     * Construtor da classe.
     * 
     * @param game - Interface com os métodos principais do fluxo do jogo.
     * @param screenId - Inteiro utilizado para caso desenvolvedor necessite ter um controle da tela que está sendo exibida ao usuário.
     */
    public Screen(Game game, int screenId) {
        this.game = game;
        this.screenId	= screenId;
    }

    public abstract void update(float deltaTime);

    public abstract void present(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();
}
