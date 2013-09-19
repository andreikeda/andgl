package br.com.limaogames.framework.interfaces;


/**
 * Interface para prover as funcionalidades para adicionar novos áudios.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Music
 * @see Sound
 */
public interface Audio {
	/**
	 * Cria nova instância de {@link Music} recebendo como parâmetro o caminho do arquivo.
	 * 
	 * @param filename - Caminho do arquivo de áudio.
	 * @return Objeto de {@link Music}.
	 */
    public Music newMusic(String filename);

    /**
     * Cria nova instância de {@link Sound} recebendo como parâmetro o caminho do arquivo.
     * 
     * @param filename - Caminho do arquivo de áudio.
     * @return Objeto de {@link Sound}.
     */
    public Sound newSound(String filename);
}
