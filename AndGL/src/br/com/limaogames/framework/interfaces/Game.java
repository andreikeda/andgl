package br.com.limaogames.framework.interfaces;

import br.com.limaogames.framework.Screen;
import br.com.limaogames.framework.impl.GLGraphics;

/**
 * Interface para prover as principais funcionalidades do aplicativo.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Input
 * @see FileIO
 * @see Graphics
 * @see GLGraphics
 * @see Audio
 * @see Screen
 */
public interface Game extends Android {
	/**
	 * Retorna objeto de {@link Input}.
	 * 
	 * @return Objeto de {@link Input}.
	 */
    public Input getInput();

    /**
     * Retorna objeto de {@link FileIO}.
     * 
     * @return Objeto de {@link FileIO}.
     */
    public FileIO getFileIO();

    /**
     * Retorna objeto de {@link Graphics}.
     * 
     * @return Objeto de {@link Graphics}.
     */
    public Graphics getGraphics();
    
    /**
     * Retorna objeto de {@link GLGraphics}.
     *  
     * @return Objeto de {@link GLGraphics}.
     */
    public GLGraphics getGLGraphics();

    /**
     * Retorna objeto de {@link Audio}.
     * 
     * @return Objeto de {@link Audio}.
     */
    public Audio getAudio();

    /**
     * Atribui a nova {@link Screen} ao topo das telas.
     * 
     * @param screen - Objeto de {@link Screen}.
     */
    public void setScreen(Screen screen);

    /**
     * Retorna a atual {@link Screen}.
     * 
     * @return Atual {@link Screen}.
     */
    public Screen getCurrentScreen();

    /**
     * Retorna a {@link Screen} inicial.
     * 
     * @return {@link Screen} inicial.
     */
    public Screen getStartScreen();
    
    /**
     * Realiza login no Facebook utilizando a API do próprio Facebook.
     * 
     * @param fbAppId
     * @param permissions
     */
    public void loginFacebook(String fbAppId, String permissions);
    
//    /**
//     * Altera o estado do jogo para 'PAUSED'.
//     */
//    public void pause();
    
    /**
     * Publica mensagem na timeline do Facebook.
     * 
     * @param message - String mensagem a ser publicada.
     */
	public void publishFeed(String message);
	
//	/**
//	 * Altera o estado do jogo para 'RESTARTED'.
//	 */
//	public void restart();
//	
//	/**
//	 * Altera o estado do jogo para 'RUNNING'.
//	 */
//	public void resume();
}