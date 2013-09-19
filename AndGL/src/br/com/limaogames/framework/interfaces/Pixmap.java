package br.com.limaogames.framework.interfaces;

import br.com.limaogames.framework.interfaces.Graphics.PixmapFormat;

/**
 * Interface para prover funcionalidades para manipulação de objetos gráficos.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public interface Pixmap {
	/**
	 * Retorna largura da imagem.
	 * 
	 * @return Inteiro largura da imagem.
	 */
    public int getWidth();

    /**
     * Retorna altura da imagem.
     * 
     * @return Inteiro altura da imagem.
     */
    public int getHeight();

    /**
     * Retorna formato da imagem.
     * 
     * @return <b>enum</b> {@link PixmapFormat}.
     */
    public PixmapFormat getFormat();

    /**
     * Elimina imagem.
     */
    public void dispose();
}
