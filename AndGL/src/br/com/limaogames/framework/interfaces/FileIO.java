package br.com.limaogames.framework.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface para prover as funcionalidades para manipula��o de arquivos.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see InputStream
 * @see IOException
 * @see OutputStream
 */
public interface FileIO {
	/**
	 * Cria uma inst�ncia de {@link InputStream} do asset lido atrav�s do caminho passado por par�metro.
	 * 
	 * @param fileName - Caminho do asset.
	 * @return Inst�ncia de {@link InputStream}.
	 * @throws IOException - caso arquivo com o caminho especificado n�o possa ser aberto ou n�o exista.
	 */
    public InputStream readAsset(String fileName) throws IOException;

    /**
     * Cria uma inst�ncia de {@link InputStream} do arquivo lido atrav�s do caminho passado por par�metro.
     * 
     * @param fileName - Caminho do arquivo.
     * @return Inst�ncia de {@link InputStream}.
     * @throws IOException - caso arquivo com o caminho especificado n�o possa ser aberto ou n�o exista.
     */
    public InputStream readFile(String fileName) throws IOException;

    /**
     * Cria uma inst�ncia de {@link OutputStream} para escrever nele mesmo atrav�s do caminho passado por par�metro.
     * 
     * @param fileName - Caminho do arquivo.
     * @return Inst�ncia de {@link OutputStream}.
     * @throws IOException - caso arquivo n�o possa ser criado ou n�o possua permiss�o para escrita.
     */
    public OutputStream writeFile(String fileName) throws IOException;
}
