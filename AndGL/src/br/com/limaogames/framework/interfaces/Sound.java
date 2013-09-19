package br.com.limaogames.framework.interfaces;

/**
 * Interface para prover funcionalidades para manipulação dos sons do jogo.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public interface Sound {
	/**
	 * Tocar efeito sonoro.
	 * 
	 * @param volume - Float indicando o volume do efeito sonoro a ser tocado.
	 */
    public void play(float volume);

    /**
     * Eliminar som.
     */
    public void dispose();
}
