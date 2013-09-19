package br.com.limaogames.framework.interfaces;

/**
 * Interface para prover funcionalidades para manipulação de músicas.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public interface Music {
	/**
	 * Inicia música.
	 */
    public void play();

    /**
     * Pára música.
     */
    public void stop();

    /**
     * Pausa música.
     */
    public void pause();

    /**
     * Define se a música deve ter loop ou não.
     * 
     * @param looping - Boolean se a música deve ter loop ou não.
     */
    public void setLooping(boolean looping);

    /**
     * Define o volume da música.
     * 
     * @param volume - Float volume da música.
     */
    public void setVolume(float volume);

    /**
     * Retorna se música está tocando.
     * 
     * @return Boolean <b>true</b> se música está tocando ou <b>false</b> caso contrário.
     */
    public boolean isPlaying();

    /**
     * Retorna se música está parada.
     * 
     * @return Boolean <b>true</b> se música está parada ou <b>false</b> caso contrário.
     */
    public boolean isStopped();

    /**
     * Retorna se música possui loop.
     * 
     * @return Boolean <b>true</b> se música possui loop ou <b>false</b> caso contrário.
     */
    public boolean isLooping();

    /**
     * Elimina música.
     */
    public void dispose();
}
