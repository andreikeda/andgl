package br.com.limaogames.framework.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface para prover as funcionalidades para manipulação de arquivos.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see InputStream
 * @see IOException
 * @see OutputStream
 */
public interface FileIO {
	/**
	 * Cria uma instância de {@link InputStream} do asset lido através do caminho passado por parâmetro.
	 * 
	 * @param fileName - Caminho do asset.
	 * @return Instância de {@link InputStream}.
	 * @throws IOException - caso arquivo com o caminho especificado não possa ser aberto ou não exista.
	 */
    public InputStream readAsset(String fileName) throws IOException;

    /**
     * Cria uma instância de {@link InputStream} do arquivo lido através do caminho passado por parâmetro.
     * 
     * @param fileName - Caminho do arquivo.
     * @return Instância de {@link InputStream}.
     * @throws IOException - caso arquivo com o caminho especificado não possa ser aberto ou não exista.
     */
    public InputStream readFile(String fileName) throws IOException;

    /**
     * Cria uma instância de {@link OutputStream} para escrever nele mesmo através do caminho passado por parâmetro.
     * 
     * @param fileName - Caminho do arquivo.
     * @return Instância de {@link OutputStream}.
     * @throws IOException - caso arquivo não possa ser criado ou não possua permissão para escrita.
     */
    public OutputStream writeFile(String fileName) throws IOException;
}
