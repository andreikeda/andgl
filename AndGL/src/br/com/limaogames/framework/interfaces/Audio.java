package br.com.limaogames.framework.interfaces;


/**
 * Interface para prover as funcionalidades para adicionar novos �udios.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Music
 * @see Sound
 */
public interface Audio {
	/**
	 * Cria nova inst�ncia de {@link Music} recebendo como par�metro o caminho do arquivo.
	 * 
	 * @param filename - Caminho do arquivo de �udio.
	 * @return Objeto de {@link Music}.
	 */
    public Music newMusic(String filename);

    /**
     * Cria nova inst�ncia de {@link Sound} recebendo como par�metro o caminho do arquivo.
     * 
     * @param filename - Caminho do arquivo de �udio.
     * @return Objeto de {@link Sound}.
     */
    public Sound newSound(String filename);
}
