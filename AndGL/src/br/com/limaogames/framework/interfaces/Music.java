package br.com.limaogames.framework.interfaces;

/**
 * Interface para prover funcionalidades para manipula��o de m�sicas.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public interface Music {
	/**
	 * Inicia m�sica.
	 */
    public void play();

    /**
     * P�ra m�sica.
     */
    public void stop();

    /**
     * Pausa m�sica.
     */
    public void pause();

    /**
     * Define se a m�sica deve ter loop ou n�o.
     * 
     * @param looping - Boolean se a m�sica deve ter loop ou n�o.
     */
    public void setLooping(boolean looping);

    /**
     * Define o volume da m�sica.
     * 
     * @param volume - Float volume da m�sica.
     */
    public void setVolume(float volume);

    /**
     * Retorna se m�sica est� tocando.
     * 
     * @return Boolean <b>true</b> se m�sica est� tocando ou <b>false</b> caso contr�rio.
     */
    public boolean isPlaying();

    /**
     * Retorna se m�sica est� parada.
     * 
     * @return Boolean <b>true</b> se m�sica est� parada ou <b>false</b> caso contr�rio.
     */
    public boolean isStopped();

    /**
     * Retorna se m�sica possui loop.
     * 
     * @return Boolean <b>true</b> se m�sica possui loop ou <b>false</b> caso contr�rio.
     */
    public boolean isLooping();

    /**
     * Elimina m�sica.
     */
    public void dispose();
}
